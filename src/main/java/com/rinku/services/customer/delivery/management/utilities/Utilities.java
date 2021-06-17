package com.rinku.services.customer.delivery.management.utilities;

import com.rinku.services.customer.delivery.management.constant.ApiConstant;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Utilidades para el servicio de nomina de rinku.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Slf4j
public abstract class Utilities {
  /**
   * Formato de salida de la respuesta de error.
   */
  public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
  /**
   * Formato de fecha yyyy-MM-dd.
   */
  public static final String DATE_PATTERN = "yyyy-MM-dd";
  /**
   * Formato fecha para sentencias SQL.
   */
  public static final String DATETIME_FORMAT_SLASH_SQL = "yyyy/MM/dd HH:mm";
  /**
   * Formato para el random.
   */
  private static final String RANDOM_PATTERN = "%04d";
  /**
   * Formato para la fecha a dos digitos.
   */
  private static final String TWO_DIGIT_PATTERN = "%02d";
  /**
   * Numero maximo para generar random.
   */
  private static final int MAXIMUM_RANDOM = 1000000;

  /**
   * Obtiene la pagina actual.
   *
   * @param pageable datos de paginación
   * @return pagina actual
   */
  public static int getCurrentPage(Pageable pageable) {
    int page = pageable.getPageNumber();
    if (pageable.getPageNumber() != ApiConstant.INT_ZERO_VALUE) {
      page -= ApiConstant.INT_ONE_VALUE;
    }
    return page;
  }

  /**
   * Cambia de formato una fecha.
   * 
   * @param date fecha con formato viejo
   * @param pattern formato nuevo de la fecha
   * @return fecha con formato nuevo
   */
  public static Date convertDate(String date, String pattern) {
    Date dateFormatter = null;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(pattern);
      dateFormatter = formatter.parse(date);
    } catch (ParseException pe) {
      log.error(pe.getMessage(), pe);
    }
    return dateFormatter;
  }

  /**
   * Cambia de formato una fecha.
   * 
   * @param date fecha con fomato viejo
   * @param pattern formato nuevo
   * @return fecha con formato nuevo
   */
  public static String convertDate(Date date, String pattern) {
    String dateFormat = null;
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    dateFormat = formatter.format(date);
    return dateFormat;
  }

  /**
   * Convierte una fecha a cadena
   * 
   * @param dateTime fecha en formato {@link LocalDateTime}
   * @param pattern formato nuevo de la fecha
   * @return la fecha con formato dado
   */
  public static String convertDateTimeToString(LocalDateTime dateTime, String pattern) {
    return dateTime.format(DateTimeFormatter.ofPattern(pattern));
  }

  /**
   * Genera el número del folio del movimiennto.
   * 
   * @return numero de folio generado
   */
  public static String generateInvoiceBranch() {
    SecureRandom ranGen = new SecureRandom();
    LocalDateTime dateTime = LocalDateTime.now();
    StringBuilder invoiceBranch = new StringBuilder();
    invoiceBranch.append(dateTime.getYear()).append(formatTwoDigits(dateTime.getMonth().getValue()))
        .append(formatTwoDigits(dateTime.getDayOfMonth())).append(dateTime.getHour())
        .append(dateTime.getMinute()).append(dateTime.getSecond())
        .append(String.format(RANDOM_PATTERN, ranGen.nextInt(MAXIMUM_RANDOM)));
    log.debug(invoiceBranch.toString());
    return invoiceBranch.toString();
  }

  /**
   * Convierte un numero dos digitos.
   * 
   * @param number numero a convertir
   * @return cadena con dos digios
   */
  private static String formatTwoDigits(int number) {
    return String.format(TWO_DIGIT_PATTERN, number);
  }

  /**
   * Constructor privado para evotar instancias de la clase.
   */
  private Utilities() {}
}
