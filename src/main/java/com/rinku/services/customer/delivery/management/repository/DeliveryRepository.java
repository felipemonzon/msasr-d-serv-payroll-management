package com.rinku.services.customer.delivery.management.repository;

import com.rinku.services.customer.delivery.management.constant.DatabaseConstant;
import com.rinku.services.customer.delivery.management.entity.DeliveryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositorio para empleados.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
  /**
   * Consulta una entrega por numero de empleado.
   * 
   * @param employeeNumber numero de empleado
   * @return lista de tipo {@code DeliveryEntity}
   */
  List<DeliveryEntity> findByEmployeeNumber(String employeeNumber);

  /**
   * Consulta las entregas registradas de un empleado por su numero y fecha.
   * 
   * @param employeeNumber numero de empleado
   * @param registrationDate fecha de registro
   * @return {@code DeliveryEntity}
   */
  @Query(nativeQuery = true, value = DatabaseConstant.FIND_BY_EMPLOYEE_AND_DATE)
  DeliveryEntity findByEmployeeNumberAndRegistrationDate(
      @Param(DatabaseConstant.EMPLOYEE_NUMBER_PARAMETER) String employeeNumber,
      @Param(DatabaseConstant.REGISTRATION_DATE_PARAMETER) String registrationDate);

  /**
   * Consulta una entrega por su folio.
   * 
   * @param invoiceBranch folio asigando a la entregas
   * @return {@code DeliveryEntity}
   */
  DeliveryEntity findByInvoiceBranch(final String invoiceBranch);

  /**
   * Consulta una entrega por numero de empleado o folio.
   * 
   * @param employeeNumber numero de empleado
   * @param invoiceBranch folio asigando a la entregas
   * @return lista de tipo {@code DeliveryEntity}
   */
  List<DeliveryEntity> findByEmployeeNumberOrInvoiceBranch(final String employeeNumber,
      final String invoiceBranch);
}
