package com.rinku.services.customer.delivery.management.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Respuesta para la páginacion de las entregas de empleados.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DeliveryResponse extends Pagination {
  /**
   * Lista de entregas de los empleados.
   */
  List<Delivery> deliveries;
}
