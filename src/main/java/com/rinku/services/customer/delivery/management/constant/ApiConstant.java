package com.rinku.services.customer.delivery.management.constant;

/**
 * Constantes para la aplicación.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class ApiConstant {
  /**
   * Constante para el símbolo de la coma.
   */
  public static final String COMMA = ",";
  /**
   * Constante para el header uuid.
   */
  public static final String HEADER_UUID = "uuid";
  /**
   * Constante para el número entero cero.
   */
  public static final int INT_ZERO_VALUE = 0;
  /**
   * Constante el número entero uno.
   */
  public static final int INT_ONE_VALUE = 1;
  /**
   * Constante para mostrar el inicio de la petición.
   */
  public static final String START_REQUEST = "Inicia Llamado [{}]";
  /**
   * Constante para la llave req.time.
   */
  public static final String TIME_REQ_ATTRIBUTE = "req.time";
  /**
   * Constante usada como llave para el atributo uuid header.
   */
  public static final String UUID_MDC_LABEL = "mdc.uuid";
  /**
   * Constante para mostrar el tiempo de petición y respuesta.
   */
  public static final String TIME_ELAPSED_MESSAGE =
      "Time elapsed for request round trip [{}]: {} ms";
  /**
   * Prefijo para las propiedades de la aplicación.
   */
  public static final String PROPERTY_PREFIX = "api";
  /**
   * Prefijo para las propiedades de swagger.
   */
  public static final String SWAGGER_PROPERTIES = "swagger";
  /**
   * Constante utilizada para representar el nombre del header uuid.
   */
  public static final String UUID = "uuid";
  /**
   * Tipo de parametro para las cabeceras.
   */
  public static final String PARAM_TYPE_HEADER = "header";
  /**
   * Descripcion de la cabecera uuid.
   */
  public static final String UUID_DESCRIPTION = "Identificador de la peticion.";
  /**
   * Constante que representa el header ChannelId.
   */
  public static final String CHANNEL_ID_HEADER = "channel_id";
  /**
   * Constante que contiene la cadena OK.
   */
  public static final String OK = "OK";
  /**
   * Constante que contiene la cadena create.
   */
  public static final String CREATE = "create";
  /**
   * Constante que contiene la cadena no content.
   */
  public static final String NO_CONTENT = "No Content";
  /**
   * Constante utilizada para mostrar un mensaje acerca de una petición mal formada.
   */
  public static final String BAD_REQUEST = "Bad Request";
  /**
   * Constante utilizada para mostrar un mensaje acerca de una petición no autorizada.
   */
  public static final String UNAUTHORIZED = "Unauthorized";
  /**
   * Constante utilizada para mostrar un mensaje acerca de recurso que no pudo ser encontrado.
   */
  public static final String RESOURCE_NOT_FOUND = "Resource not found";
  /**
   * Constante utilizada para mostrar un mensaje acerca de un Forbidden error.
   */
  public static final String FORBIDDEN_ERROR_MESSAGE = "Forbidden";
  /**
   * Constante utilizada para mostrar un mensaje acerca de un Internal server error.
   */
  public static final String INTERNAL_ERROR = "Internal server error";
  /**
   * Constante utilizada para mostrar el status code 200.
   */
  public static final int CODE_OK = 200;
  /**
   * Constante utilizada para mostrar el status code 201.
   */
  public static final int CODE_CREATE = 201;
  /**
   * Constante utilizada para mostrar el status code 204.
   */
  public static final int CODE_NO_CONTENT = 204;
  /**
   * Constante utilizada para mostrar el status code 400.
   */
  public static final int CODE_BAD_REQUEST = 400;
  /**
   * Constante utilizada para mostrar el status code 401.
   */
  public static final int CODE_UNAUTHORIZED = 401;
  /**
   * Constante utilizada para mostrar el status code 403.
   */
  public static final int CODE_FORBIDDEN = 403;
  /**
   * Constante utilizada para mostrar el status code 404.
   */
  public static final int CODE_RESOURCE_NOT_FOUND = 404;
  /**
   * Constante utilizada para mostrar el status code 500.
   */
  public static final int CODE_INTERNAL_ERROR = 500;
  /**
   * Operacion para consultar los empleados.
   */
  public static final String API_OPERATION_EMPLOYEE_RETRIEVE = "Consulta los Empleados";
  /**
   * Etiqueta para consultar los empleados.
   */
  public static final String API_TAG_EMPLOYEE_RETRIEVE = "employee-retrieve";
  /**
   * Operacion para guardar un empleado.
   */
  public static final String API_OPERATION_EMPLOYEE_SAVE = "Guarda un Empleado";
  /**
   * Etiqueta para guardar un empleado.
   */
  public static final String API_TAG_EMPLOYEE_SAVE = "employee-save";
  /**
   * Operacion para actualizar un empleado.
   */
  public static final String API_OPERATION_EMPLOYEE_UPDATE = "Actualiza un Empleado";
  /**
   * Contenido de la respuesta.
   */
  public static final String RESPONSE_CONTAINT_LIST = "List";
  /**
   * Operacion para consultar todas las entregas de los empleados.
   */
  public static final String API_OPERATION_DELIVERY_SEARCH =
      "Busca las entregas por una opcion dada";
  /**
   * Etiqueta para consultar todas las entregas de los empleados.
   */
  public static final String API_TAG_DELIVERY_RETRIEVE = "employee-delivery-retrieve";
  /**
   * Parametro de la peticion.
   */
  public static final String PARAM_OPTION = "option";
  /**
   * Parametro de la peticion.
   */
  public static final String PARAM_VALUE = "value";
  /**
   * Nombre de la operacion de entregas.
   */
  public static final String API_DELIVERY = "delivery-data";

  /**
   * Constructor de la clase.
   */
  private ApiConstant() {}
}
