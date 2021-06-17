package com.rinku.services.customer.delivery.management.exception;

import com.rinku.services.customer.delivery.management.constant.ApiConstant;
import com.rinku.services.customer.delivery.management.exception.custom.BadRequestException;
import com.rinku.services.customer.delivery.management.exception.custom.DeliveryRegisterException;
import com.rinku.services.customer.delivery.management.exception.custom.ErrorResponse;
import com.rinku.services.customer.delivery.management.exception.custom.NoDataFoundException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Administrador de excepciones.
 *
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class ExceptionManagment {
  /**
   * Enumerator for errors.
   */
  public enum ErrorType {
    ERROR, WARN, INVALID, FATAL
  }

  /**
   * Mensaje de error general.
   */
  private static final String GENERIC_ERROR_MESSAGE = "Ocurrio un Error, Intentelo más tarde.";

  /**
   * Maneja una excepción de tipo BadRequestException.
   *
   * @param req Objeto HttpServlet de petición.
   * @param ex Excepción recibida BadRequestException.
   * @return errorResponse Objeto de respuesta específica para BadRequestException.
   */
  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveBadRequestException(HttpServletRequest req, BadRequestException ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    String moreInfo = null;

    if (ObjectUtils.isEmpty(ex.getBadFields())) {
      moreInfo = String.join(ApiConstant.COMMA, ex.getBadFields());
    }

    errorResponse.setType(ErrorType.INVALID.name());
    errorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setMoreInfo(moreInfo);
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpRequestMethodNotSupportedException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida UnauthorizedException.
   * @return errorResponse Objeto de respuesta específica para
   *         HttpRequestMethodNotSupportedException.
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  public ErrorResponse resolveHttpRequestMethodNotSupportedException(HttpServletRequest req,
      HttpRequestMethodNotSupportedException ex) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setType(ErrorType.INVALID.name());
    errorResponse.setCode(String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()));
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());

    return errorResponse;

  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMediaTypeNotAcceptableException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida HttpMediaTypeNotAcceptableException.
   * @return errorResponse Objeto de respuesta específica para HttpMediaTypeNotAcceptableException.
   */
  @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
  @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
  public ErrorResponse resolveHttpMediaTypeNotAcceptableException(HttpServletRequest req,
      HttpMediaTypeNotAcceptableException ex) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setType(ErrorType.INVALID.name());
    errorResponse.setCode(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMediaTypeNotSupportedException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida HttpMediaTypeNotAcceptableException.
   * @return errorResponse Objeto de respuesta específica para HttpMediaTypeNotSupportedException.
   */
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public ErrorResponse resolveHttpMediaTypeNotSupportedException(HttpServletRequest req,
      HttpMediaTypeNotSupportedException ex) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setType(ErrorType.INVALID.name());
    errorResponse.setCode(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Maneja una excepción de tipo {@link MethodArgumentNotValidException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida MethodArgumentNotValidException.
   * @return errorResponse Objeto de respuesta específica para MethodArgumentNotValidException.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
      MethodArgumentNotValidException ex) {
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

    List<String> fields = new ArrayList<>();
    Map<String, List<String>> groupedErrors = new HashMap<>();

    for (FieldError fieldError : fieldErrors) {
      String field = fieldError.getField();
      groupedErrors.computeIfAbsent(fieldError.getDefaultMessage(),
          key -> Collections.singletonList(field));
      fields.add(field);
    }
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setType(ErrorType.INVALID.name());
    errorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
    errorResponse.setDetails(groupedErrors.toString());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setMoreInfo(fields.toString());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Maneja una excepción de tipo {@code DataIntegrityViolationException} generada por excepciones
   * SQL.
   *
   * @param req Petición
   * @param ex excepción generada por JPA
   * @return objeto de respuesta especifico para {@see DataIntegrityViolationException}
   */
  @ExceptionHandler({DataIntegrityViolationException.class,
      SQLIntegrityConstraintViolationException.class})
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorResponse resolveDataIntegrityViolationException(HttpServletRequest req,
      DataIntegrityViolationException ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setType(ErrorType.ERROR.name());
    errorResponse.setCode(String.valueOf(HttpStatus.CONFLICT.value()));
    errorResponse.setDetails(GENERIC_ERROR_MESSAGE);
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Maneja una excepción de tipo {@code NoDataFoundException} generada por no encontrar datos.
   *
   * @param req Petición
   * @param ex excepción generada por no encontrar datos
   * @return objeto de respuesta especifico para {@see NoDataFoundException}
   */
  @ExceptionHandler(NoDataFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveNoDataFoundException(HttpServletRequest req,
      NoDataFoundException ex) {

    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setType(ErrorType.ERROR.name());
    errorResponse.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Maneja una excepción de tipo {@code DeliveryRegisterException}.
   *
   * @param req Petición
   * @param ex excepción generada
   * @return objeto de respuesta especifico para {@see DeliveryRegisterException}
   */
  @ExceptionHandler(DeliveryRegisterException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorResponse resolveDeliveryRegisterException(HttpServletRequest req,
      DeliveryRegisterException ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setType(ErrorType.ERROR.name());
    errorResponse.setCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setLocation(req.getRequestURI());
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    errorResponse.setTimestamp(LocalDateTime.now());

    log.error(errorResponse.toString());
    return errorResponse;
  }
}
