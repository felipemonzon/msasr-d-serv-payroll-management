package com.rinku.services.customer.delivery.management.constant;

/**
 * Constantes para el log.
 * 
 * @author Felipe Monzón
 * @since 27 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class LogConstant {
  /**
   * Log para la entrada de las peticiones.
   */
  public static final String REQUEST = "Request {}";
  /**
   * Log para mensaje de 404.
   */
  public static final String NO_DATA = "Dato no Encontrado.";
  /**
   * Log para consultar las etregas de los empleados.
   */
  public static final String EMPLOYEE_DELIVERY_RETREVE =
      "Consulta todas las entregas de los Empleados";
  /**
   * Log para consultar los empleados.
   */
  public static final String EMPLOYEES_PAGINATION = "Consulta de Empleados, pagina {}";
  /**
   * Log para los datos obtenidos de base de datos.
   */
  public static final String DATABASE_DATA = "Datos recuperados de base de datos {}";
  /**
   * Registra cuando un usuario ya dio de alta sus entregas.
   */
  public static final String DELIVERY_REGISTER_TODAY =
      "El empleado {} ya registro las entregas del dia {}";
  /**
   * Log para consultar las entregas por folio o empleado.
   */
  public static final String DELIVERIES_SEARCH_BY = "Consulta las entregas diarias de {} por {}";

  /**
   * Constructor de la clase.
   */
  private LogConstant() {}
}
