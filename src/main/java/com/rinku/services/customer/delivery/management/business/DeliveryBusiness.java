package com.rinku.services.customer.delivery.management.business;

import com.rinku.services.customer.delivery.management.constant.LogConstant;
import com.rinku.services.customer.delivery.management.entity.DeliveryEntity;
import com.rinku.services.customer.delivery.management.entity.RolEntity;
import com.rinku.services.customer.delivery.management.exception.custom.DeliveryRegisterException;
import com.rinku.services.customer.delivery.management.exception.custom.NoDataFoundException;
import com.rinku.services.customer.delivery.management.model.Delivery;
import com.rinku.services.customer.delivery.management.model.DeliveryRequest;
import com.rinku.services.customer.delivery.management.model.DeliveryResponse;
import com.rinku.services.customer.delivery.management.model.DeliverySaveResponse;
import com.rinku.services.customer.delivery.management.repository.DeliveryRepository;
import com.rinku.services.customer.delivery.management.service.DeliveryService;
import com.rinku.services.customer.delivery.management.utilities.Utilities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para empleados.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryBusiness implements DeliveryService {
  /**
   * Repositorio de entregas.
   */
  private final DeliveryRepository deliveryRepository;

  /**
   * {@inheritDoc}.
   */
  @Override
  @Transactional(readOnly = true)
  public List<Delivery> getDeliveries() {
    log.info(LogConstant.EMPLOYEE_DELIVERY_RETREVE);
    return this.deliveryRepository.findAll(Sort.by(Order.desc("registrationDate"))).stream()
        .map(this::mappingDelivery).collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  @Transactional(readOnly = true)
  public List<Delivery> getDeliveriesBy(String option, String value) {
    log.info(LogConstant.DELIVERIES_SEARCH_BY, value, option);
    return this.deliveryRepository.findByEmployeeNumberOrInvoiceBranch(value, value).stream()
        .map(this::mappingDelivery).collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  @Transactional(readOnly = true)
  public DeliveryResponse getDeliveries(Pageable pageable) {
    int currentPage = Utilities.getCurrentPage(pageable);
    log.info(LogConstant.EMPLOYEES_PAGINATION, currentPage);
    Page<Delivery> employees = this.deliveryRepository
        .findAll(PageRequest.of(currentPage, pageable.getPageSize())).map(this::mappingDelivery);
    return DeliveryResponse.builder().deliveries(employees.getContent())
        .currentPage(pageable.getPageNumber()).firstPage(employees.isFirst())
        .lastPage(employees.isLast()).totalPages(employees.getTotalPages()).build();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  @Transactional
  public DeliverySaveResponse save(DeliveryRequest request) {
    log.debug(LogConstant.REQUEST, request.toString());
    this.validateDelivery(request.getEmployeeNumber());
    DeliveryEntity entity = this.mappingDelivery(request);
    entity.setInvoiceBranch(Utilities.generateInvoiceBranch());
    this.deliveryRepository.save(entity);
    return DeliverySaveResponse.builder().invoiceBranch(entity.getInvoiceBranch()).build();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  @Modifying
  @Transactional
  public void replaceDelivey(DeliveryRequest request, long id) {
    log.debug(LogConstant.REQUEST, request.toString());
    DeliveryEntity entity =
        this.deliveryRepository.findById(id).<NoDataFoundException>orElseThrow(() -> {
          throw new NoDataFoundException(LogConstant.NO_DATA);
        });
    log.debug(LogConstant.DATABASE_DATA, entity.toString());
    DeliveryEntity en = this.mappingDelivery(request);
    en.setIdDelivery(id);
    this.deliveryRepository.save(en);
  }

  /**
   * Valida si el empleado ya registro sus movimientos.
   * 
   * @param employeeNumber numero de empleado
   */
  private void validateDelivery(String employeeNumber) {
    String date = Utilities.convertDateTimeToString(LocalDateTime.now(), Utilities.DATE_PATTERN);
    DeliveryEntity entity =
        this.deliveryRepository.findByEmployeeNumberAndRegistrationDate(employeeNumber, date);
    if (!ObjectUtils.isEmpty(entity)) {
      log.debug(LogConstant.DATABASE_DATA, entity.toString());
      FormattingTuple messages =
          MessageFormatter.format(LogConstant.DELIVERY_REGISTER_TODAY, employeeNumber, date);
      log.error(LogConstant.DELIVERY_REGISTER_TODAY, employeeNumber, date);
      throw new DeliveryRegisterException(messages.getMessage());
    }
  }

  /**
   * Mapea una clase de tipo entity a una clase de DTO.
   * 
   * @param entity clase obtenida de base de datos
   * @return un objeto de tipo {@link Delivery}
   */
  private Delivery mappingDelivery(final DeliveryEntity entity) {
    Delivery response = new ModelMapper().map(entity, Delivery.class);
    response.setRegistrationDate(
        Utilities.convertDate(entity.getRegistrationDate(), Utilities.DATE_TIME_PATTERN));
    response.setAssignedRol(entity.getAssignedRol().getIdRol());
    response.setAssignedRolDescription(entity.getAssignedRol().getDescription());
    return response;
  }

  /**
   * Mapea una clase de tipo entity a una clase de DTO.
   * 
   * @param request peticion de la API
   * @return un objeto de tipo {@link DeliveryEntity}
   */
  private DeliveryEntity mappingDelivery(final DeliveryRequest request) {
    return DeliveryEntity.builder()
        .registrationDate(Utilities.convertDate(request.getRegistrationDate(),
            Utilities.DATETIME_FORMAT_SLASH_SQL))
        .employeeNumber(request.getEmployeeNumber().toLowerCase())
        .assignedRol(this.mappingRol(request.getAssignedRol())).deliveries(request.getDeliveries())
        .build();
  }

  /**
   * Mapea el id al objeto {@code RolEntity}
   * 
   * @param id identificador del rol
   * @return {@code RolEntity}
   */
  private RolEntity mappingRol(Long id) {
    RolEntity rol = new RolEntity();
    rol.setIdRol(id);
    return rol;
  }
}
