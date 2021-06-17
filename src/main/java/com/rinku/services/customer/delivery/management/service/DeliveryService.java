package com.rinku.services.customer.delivery.management.service;

import com.rinku.services.customer.delivery.management.model.Delivery;
import com.rinku.services.customer.delivery.management.model.DeliveryRequest;
import com.rinku.services.customer.delivery.management.model.DeliveryResponse;
import com.rinku.services.customer.delivery.management.model.DeliverySaveResponse;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Servicio para entregas.
 * 
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public interface DeliveryService {
  /**
   * Consulta todas las entregas de los empleados.
   * 
   * @return una lista de {@code Delivery}
   */
  List<Delivery> getDeliveries();

  /**
   * Busca la(s) entrega(s) diaria(s) por una opcion de busqueda.
   * 
   * @param option opcion a buscar
   * @param value valor de busqueda
   * @return una lista de tipo {@code Delivery}
   */
  List<Delivery> getDeliveriesBy(String option, String value);

  /**
   * Consulta una lista páginada de las entregas.
   * 
   * @return una lista páginada de tipo {@code DeliveryResponse}
   */
  DeliveryResponse getDeliveries(Pageable pageable);

  /**
   * Guarda una entrega.
   * 
   * @param request objeto de tipo {@code DeliveryRequest}
   * @return folio del registro de la entrega
   */
  DeliverySaveResponse save(DeliveryRequest request);

  /**
   * Actualiza una entrega.
   * 
   * @param request objeto de tipo {@code DeliveryRequest}
   * @param id identificador de la entrega
   */
  void replaceDelivey(DeliveryRequest request, long id);
}
