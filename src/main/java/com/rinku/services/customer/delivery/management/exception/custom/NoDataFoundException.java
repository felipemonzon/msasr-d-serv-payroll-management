package com.rinku.services.customer.delivery.management.exception.custom;

/**
 * Excepción para datos no encontrados.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public class NoDataFoundException extends RuntimeException {
  /**
   * UID auto generado para el versionado de la clase.
   */
  private static final long serialVersionUID = 5141264074683480037L;

  /**
   * Constructor por defecto.
   */
  public NoDataFoundException() {
    super();
  }

  /**
   * Constructor que recibe el mensaje de error que debera mostrarse.
   *
   * @param message mensaje de la excepción personalizado.
   */
  public NoDataFoundException(String message) {
    super(message);
  }
}
