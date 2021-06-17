package com.rinku.services.customer.delivery.management.constant;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Propiedades de la aplicación.
 *
 * @author Felipe Monzón
 * @since 27 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = ApiConstant.PROPERTY_PREFIX)
public class PropertiesConstant {
  /**
   * Ruta para la intercepción de la petición.
   */
  private String interceptorPath;
}
