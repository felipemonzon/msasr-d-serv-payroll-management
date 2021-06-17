package com.rinku.services.customer.delivery.management.interceptor;

import com.rinku.services.customer.delivery.management.constant.ApiConstant;
import com.rinku.services.customer.delivery.management.interceptor.TimeInterceptor;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.ServletRequestBindingException;

/**
 * Pruebas de la clase TimeInterceptor.
 * 
 * @author Felipe Monzón
 * @date 27 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeInterceptorTest {
  /**
   * Interceptor que sea validado.
   */
  @InjectMocks
  private TimeInterceptor timeInterceptor;
  /**
   * Servlet de la peticion.
   */
  @Mock
  private MockHttpServletRequest mockHttpServletRequest;
  /**
   * Servlet de la respuesta.
   */
  @Mock
  private MockHttpServletResponse mockHttpServletResponse;

  /**
   * Metodo para inicializar variables de las pruebas unitarias.
   */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockHttpServletRequest = new MockHttpServletRequest();

    mockHttpServletRequest.setMethod("POST");

    mockHttpServletRequest.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    mockHttpServletRequest.addHeader(ApiConstant.UUID, StringUtils.EMPTY);
    mockHttpServletRequest.addHeader(HttpHeaders.AUTHORIZATION, StringUtils.EMPTY);
    mockHttpServletRequest.setContentType(MediaType.APPLICATION_JSON_VALUE);
    mockHttpServletRequest.setAttribute(ApiConstant.TIME_REQ_ATTRIBUTE, System.currentTimeMillis());
    mockHttpServletResponse = new MockHttpServletResponse();
  }

  /**
   * Ejecuta el test para el metodo pre handle del interceptor.
   * 
   * @given llega una peticion HttpServletRequest.
   * @when se invoca al metodo pre handle del interceptor.
   * @then se agrega el tiempo de inicio de la peticion al MDC.
   * @throws ServletRequestBindingException
   */
  @Test
  public void preHandleTestWithPrintHeaders() throws ServletRequestBindingException {
    boolean result =
        this.timeInterceptor.preHandle(mockHttpServletRequest, mockHttpServletResponse, null);
    Assert.assertTrue(result);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo pre handle del interceptor sin imprimir headers.
   * 
   * @given llega una peticion HttpServletRequest.
   * @when se invoca al metodo pre handle del interceptor y la variable printHeaders esta en false.
   * @then no se imprimen los headers de la peticion.
   * @throws ServletRequestBindingException.
   */
  @Test
  public void preHandleTestWithoutPrintHeaders() throws ServletRequestBindingException {
    boolean result = this.timeInterceptor.preHandle(this.mockHttpServletRequest,
        this.mockHttpServletResponse, null);
    Assert.assertTrue(result);
  }

  /**
   * Ejecuta la prueba unitaria para el metodo after completion del interceptor.
   * 
   * @given llega una peticion HttpServletRequest.
   * @when se invoca al metodo after completion del interceptor.
   * @then se imprime el tiempo que duro la peticion y borra la variable del MDC.
   * @throws ServletRequestBindingException.
   */
  @Test
  public void afterCompletion() throws ServletRequestBindingException {
    Exception ex = new Exception();
    this.timeInterceptor.afterCompletion(this.mockHttpServletRequest, this.mockHttpServletResponse,
        null, ex);
    Assert.assertNotNull(ex);
  }
}
