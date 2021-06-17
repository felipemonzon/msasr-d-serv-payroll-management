package com.rinku.services.customer.delivery.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Clase utilizado para las apis de empleado.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequest {
  /**
   * Identificador principal de la entrega.
   */
  @NotEmpty
  private String employeeNumber;
  /**
   * Propiedad para la fecha de registro.
   */
  @NotEmpty
  private String registrationDate;
  /**
   * Propiedad para las entregas.
   */
  @Min(value = 1)
  private int deliveries;
  /**
   * Propiedad para el rol asigando.
   */
  @Min(value = 1)
  private long assignedRol;
}
