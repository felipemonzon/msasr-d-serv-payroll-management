package com.rinku.services.customer.delivery.management.model;

import lombok.Data;

/**
 * Clase utilizado para las apis de empleado.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
public class Delivery {
  /**
   * Id auto generado de las entregas.
   */
  private Long idDelivery;
  /**
   * Identificador principal de la entrega.
   */
  private String employeeNumber;
  /**
   * Propiedad para las entregas.
   */
  private String invoiceBranch;
  /**
   * Propiedad para la fecha de registro.
   */
  private String registrationDate;
  /**
   * Propiedad para las entregas.
   */
  private int deliveries;
  /**
   * Identificador de el rol asigando.
   */
  private long assignedRol;
  /**
   * Descripcion de el rol asigando.
   */
  private String assignedRolDescription;
}
