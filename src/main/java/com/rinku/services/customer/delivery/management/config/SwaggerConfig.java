package com.rinku.services.customer.delivery.management.config;

import com.rinku.services.customer.delivery.management.constant.SwaggerProperties;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración para swagger-ui.
 *
 * @author Felipe Monzón
 * @since 30 may 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {
  /**
   * Constantes con los valores obtenidos del archivo properties.
   */
  private final SwaggerProperties swaggerConstants;

  /**
   * Genera el swagger-ui.
   *
   * @return información del producto
   */
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(Boolean.FALSE)
        .select().apis(RequestHandlerSelectors.basePackage(this.swaggerConstants.getBasePackage()))
        .paths(PathSelectors.any()).build().apiInfo(apiInfo());
  }

  /**
   * Constructor para la información de la API.
   *
   * @return información del producto
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(this.swaggerConstants.getTitle())
        .description(this.swaggerConstants.getDescriptionApi())
        .version(this.swaggerConstants.getVersion())
        .contact(new Contact(this.swaggerConstants.getDeveloperName(),
            this.swaggerConstants.getContactUrl(), this.swaggerConstants.getDeveloperEmail()))
        .build();
  }
}
