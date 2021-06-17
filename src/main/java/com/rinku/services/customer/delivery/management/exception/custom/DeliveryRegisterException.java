package com.rinku.services.customer.delivery.management.exception.custom;

/**
 * Excepción para badRequest.
 * 
 * @author Felipe Monzón
 * @since 02 jun. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public class DeliveryRegisterException extends RuntimeException {
  /**
   * UID auto generado para el versionado de la clase.
   */
  private static final long serialVersionUID = 8925303792177335247L;

  /**
   * Constructor de la clase.
   */
  public DeliveryRegisterException() {}

  /**
   * Constructor de la clase.
   *
   * @param message mensaje de excepción arrojada por bad request.
   */
  public DeliveryRegisterException(String message) {
    super(message);
  }

}
