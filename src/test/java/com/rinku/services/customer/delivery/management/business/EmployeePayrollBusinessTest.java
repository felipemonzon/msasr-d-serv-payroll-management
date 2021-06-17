package com.rinku.services.customer.delivery.management.business;

import com.rinku.services.customer.delivery.management.entity.DeliveryEntity;
import com.rinku.services.customer.delivery.management.entity.RolEntity;
import com.rinku.services.customer.delivery.management.exception.custom.DeliveryRegisterException;
import com.rinku.services.customer.delivery.management.exception.custom.NoDataFoundException;
import com.rinku.services.customer.delivery.management.model.DeliveryRequest;
import com.rinku.services.customer.delivery.management.repository.DeliveryRepository;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * Test de la clase de negocio.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class EmployeePayrollBusinessTest {
  /**
   * clase a testear.
   */
  @InjectMocks
  private DeliveryBusiness deliveryBusiness;
  /**
   * Repositorio de entregas.
   */
  @Mock
  private DeliveryRepository deliveryRepository;

  /**
   * Inicializa los componentes de mockito.
   */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Consulta todas las entregas.
   * 
   * @when consulta todas las entregas
   * @given
   * @then lista de todas los entregas
   */
  @Test
  public void getDeliveriesTest() {
    Mockito.when(this.deliveryRepository.findAll())
        .thenReturn(Arrays.asList(this.getDeliveryEntity()));
    Assert.assertNotNull(this.deliveryBusiness.getDeliveries());
  }

  /**
   * Consulta las entregas por una opcion dada.
   * 
   * @when consulta las entregas por una opcion
   * @given
   * @then lista de las entregas encontradas
   */
  @Test
  public void getDeliveryByTest() {
    Mockito.when(this.deliveryRepository.findByEmployeeNumberOrInvoiceBranch(Mockito.anyString(),
        Mockito.anyString())).thenReturn(Arrays.asList(this.getDeliveryEntity()));
    Assert.assertNotNull(this.deliveryBusiness.getDeliveriesBy("ByEmployee", StringUtils.EMPTY));
  }

  /**
   * Consulta una pagina con las entregas.
   * 
   * @when consulta una pagina de entregas
   * @given parametros de paginacion
   * @then lista paginada de las entregas
   */
  @Test
  public void paginationTest() {
    Page<DeliveryEntity> pagedResponse =
        new PageImpl<>(Arrays.asList(this.getDeliveryEntity()), PageRequest.of(1, 1), 400L);
    Mockito.when(this.deliveryRepository.findAll(Mockito.any(Pageable.class)))
        .thenReturn(pagedResponse);
    Assert.assertNotNull(this.deliveryBusiness.getDeliveries(PageRequest.of(1, 1)));
  }

  /**
   * Consulta una pagina con las entregas.
   * 
   * @when consulta una pagina de entregas
   * @given parametros de paginacion
   * @then lista paginada de las entregas
   */
  @Test
  public void paginationErrorTest() {
    Throwable e = null;
    try {
      this.deliveryBusiness.getDeliveries(PageRequest.of(1, 1));
    } catch (Exception ex) {
      e = ex;
    }
    Assert.assertTrue(e instanceof NullPointerException);
  }

  /**
   * Guarda las entregas diarias del empleado.
   * 
   * @when guarda las entregas diarias con exito
   * @given request {@code DeliveryRequest}
   * @then entregas guardadas con exito
   */
  @Test
  public void saveDeliveryTest() {
    Mockito.when(this.deliveryRepository.save(Mockito.any())).thenReturn(this.getDeliveryEntity());
    this.deliveryBusiness.save(this.getDelivery("2021/06/04 20:30"));
    Assert.assertTrue(true);
  }

  /**
   * Guarda una entrega diaria ya registrada.
   * 
   * @when intenta guarda las entregas diarias ya registradas
   * @given request {@code DeliveryRequest}
   * @then una excepcion
   */
  @Test
  public void saveDeliveryRegisterTest() {
    Throwable e = null;
    try {
      Mockito.when(this.deliveryRepository
          .findByEmployeeNumberAndRegistrationDate(Mockito.anyString(), Mockito.anyString()))
          .thenReturn(this.getDeliveryEntity());
      this.deliveryBusiness.save(this.getDelivery(StringUtils.EMPTY));
    } catch (Exception ex) {
      e = ex;
    }
    Assert.assertTrue(e instanceof DeliveryRegisterException);
  }

  /**
   * Intenta actualizar las entregas diarias del empleado con un número empleado inexistente.
   * 
   * @when intenta actualizar las entregas diarias del empleado
   * @given request {@code DeliveryRequest}
   * @then error 404 dato no encontrado
   */
  @Test
  public void updateDeliveryErrorTest() {
    Throwable e = null;
    try {
      this.deliveryBusiness.replaceDelivey(new DeliveryRequest(), 1L);
    } catch (Exception ex) {
      e = ex;
    }
    Assert.assertTrue(e instanceof NoDataFoundException);
  }

  /**
   * Actualiza las entregas diarias del empleado con exito.
   * 
   * @when actualiza las entregas diarias del empleado
   * @given request {@code DeliveryRequest}
   * @then entregas guardadas con exito
   */
  @Test
  public void updateEmployeeTest() {
    Mockito.when(this.deliveryRepository.findById(Mockito.anyLong()))
        .thenReturn(Optional.of(this.getDeliveryEntity()));
    Mockito.when(this.deliveryRepository.save(Mockito.any())).thenReturn(this.getDeliveryEntity());
    this.deliveryBusiness.replaceDelivey(this.getDelivery(StringUtils.EMPTY), 1L);
    Assert.assertTrue(true);
  }

  /**
   * Obtiene un objeto entity.
   * 
   * @return una entidad de delivery
   */
  private DeliveryEntity getDeliveryEntity() {
    RolEntity rol = new RolEntity();
    rol.setDescription(StringUtils.EMPTY);
    rol.setIdRol(1L);
    return DeliveryEntity.builder().assignedRol(rol).deliveries(1).employeeNumber(StringUtils.EMPTY)
        .invoiceBranch(StringUtils.EMPTY).registrationDate(new Date()).idDelivery(1L).build();
  }

  /**
   * Obtiene un objeto entity.
   * 
   * @param date fecha
   * @return una entidad de delivery
   */
  private DeliveryRequest getDelivery(String date) {
    return DeliveryRequest.builder().assignedRol(1).deliveries(1).employeeNumber(StringUtils.EMPTY)
        .registrationDate(date).build();
  }
}
