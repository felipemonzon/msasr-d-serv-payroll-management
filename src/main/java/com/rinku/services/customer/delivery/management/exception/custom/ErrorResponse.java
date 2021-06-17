package com.rinku.services.customer.delivery.management.exception.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rinku.services.customer.delivery.management.utilities.Utilities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDateTime;

/**
 * Respuesta de error.
 * 
 * @author: Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  /**
   * Tipo de error.
   */
  private String type;
  /**
   * Código del error.
   */
  @Builder.Default
  private String code = StringUtils.EMPTY;
  /**
   * Detalles del error.
   */
  @Builder.Default
  private String details = StringUtils.EMPTY;
  /**
   * Ubicación del error.
   */
  @Builder.Default
  private String location = StringUtils.EMPTY;
  /**
   * Información adicional del error.
   */
  @Builder.Default
  private String moreInfo = StringUtils.EMPTY;
  /**
   * UUID header de la petición.
   */
  @Builder.Default
  private String uuid = StringUtils.EMPTY;
  /**
   * Fecha y hora cuando ocurre el error.
   */
  @Builder.Default
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utilities.DATE_TIME_PATTERN)
  private LocalDateTime timestamp = LocalDateTime.now();
}
