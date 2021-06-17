package com.rinku.services.customer.delivery.management.api;

import com.rinku.services.customer.delivery.management.model.Delivery;
import com.rinku.services.customer.delivery.management.model.DeliveryRequest;
import com.rinku.services.customer.delivery.management.service.DeliveryService;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Test del controlador.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DeliveryControllerTest {
  /**
   * clase a testear.
   */
  @InjectMocks
  private DeliveryController employeeController;
  /**
   * Servicio de entregas.
   */
  @Mock
  private DeliveryService employeeService;

  /**
   * Inicializa los componentes de mockito.
   */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Consulta todas las entregas
   * 
   * @when consulta todas las entregas
   * @given headers
   * @then una lista de entregas
   */
  @Test
  public void employeeRetrieveTest() {
    Mockito.when(this.employeeService.getDeliveries()).thenReturn(Arrays.asList(new Delivery()));
    Assert.assertNotNull(this.employeeController.retrieve(new HttpHeaders()));
  }

  /**
   * Consulta todas las entregas
   * 
   * @when consulta todas las entregas
   * @given headers and pagina
   * @then una lista paginada de empleados
   */
  @Test
  public void employeePaginationTest() {
    Mockito.when(this.employeeService.getDeliveries()).thenReturn(Arrays.asList(new Delivery()));
    Assert.assertNotNull(this.employeeController.retrieve(PageRequest.of(0, 1)));
  }

  /**
   * Guarda las entregas del empleado
   * 
   * @when Guarda las entregas
   * @given headers and request
   * @then httpStatus 201
   */
  @Test
  public void employeeSaveTest() {
    Assert.assertNotNull(
        this.employeeController.saveDelivery(new HttpHeaders(), new DeliveryRequest()));
  }

  /**
   * Actualiza las entregas del dia de el empleado
   * 
   * @when Actualiza las entregas del dia del empleado
   * @given headers and request
   * @then httpStatus 204
   */
  @Test
  public void employeeUpdateTest() {
    Assert.assertNotNull(
        this.employeeController.updateDelivery(new HttpHeaders(), new DeliveryRequest(), 1));
  }

  /**
   * Consulta un emplado por un opcion con exito.
   * 
   * @when consulta un empleado por una opcion
   * @given headers and request
   * @then empleado encontrado
   */
  @Test
  public void employeeSearchByTest() {
    Assert.assertNotNull(
        this.employeeController.searchBy(new HttpHeaders(), StringUtils.EMPTY, StringUtils.EMPTY));
  }
}
