package com.rinku.services.customer.delivery.management.constant;

/**
 * Constantes de rutas.
 * 
 * @author Felipe Monzón
 * @since 27 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class RoutesConstant {
  /**
   * Ruta base del proyecto.
   */
  public static final String BASE_PATH = "${api.uri.basePath}";
  /**
   * Ruta para la consulta de la nomina de empleados.
   */
  public static final String DELIVERY_RETRIEVE_PATH = "${api.uri.delivery.retrieve.mapping}";
  /**
   * Ruta para el guardado de la nomina de empleados.
   */
  public static final String DELIVERY_SAVE_PATH = "${api.uri.delivery.save.mapping}";
  /**
   * Ruta para la actualización de la nomina de empleados.
   */
  public static final String DELIVERY_UPDATE_PATH = "${api.uri.delivery.update.mapping}";
  /**
   * Ruta para la páginacion de la nomina de empleados.
   */
  public static final String DELIVERY_PAGINATION_PATH =
      "${api.uri.delivery.retrieve.pagintation.mapping}";
  /**
   * Ruta para la buscar las entregas de empleados.
   */
  public static final String DELIVERY_SEARCH_PATH = "${api.uri.delivery.search.mapping}";

  /**
   * Constructor de la clase.
   */
  private RoutesConstant() {}
}
