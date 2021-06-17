package com.rinku.services.customer.delivery.management.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Paginación de objetos.
 * 
 * @author Felipe Monzón
 * @since 27 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Setter
@Getter
@SuperBuilder(toBuilder = true)
public class Pagination {
  /**
   * Página Actual.
   */
  private int currentPage;
  /**
   * Páginas totales.
   */
  private int totalPages;
  /**
   * Página final.
   */
  private boolean lastPage;
  /**
   * Página inicial.
   */
  private boolean firstPage;
}
