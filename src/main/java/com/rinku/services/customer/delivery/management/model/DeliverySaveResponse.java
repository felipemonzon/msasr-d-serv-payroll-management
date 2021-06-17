package com.rinku.services.customer.delivery.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Salida de la api de employee-delivery-save
 * 
 * @author Felipe Monzón
 * @since 15 jun. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliverySaveResponse {
  /**
   * Propiedad para las entregas.
   */
  private String invoiceBranch;
}
