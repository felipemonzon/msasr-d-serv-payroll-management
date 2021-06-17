package com.rinku.services.customer.delivery.management.entity;

import com.rinku.services.customer.delivery.management.constant.DatabaseConstant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad para las entregas de los empleados.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.ACTIVITIES_TABLE)
public class DeliveryEntity {
  /**
   * Id auto generado de las entregas.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = DatabaseConstant.ID_ACTIVITY_FIELD, nullable = false, updatable = false)
  private Long idDelivery;
  /**
   * Propiedad para las entregas.
   */
  @Column(name = DatabaseConstant.INVOICE_BRANCH_FIELD, nullable = false, updatable = false)
  private String invoiceBranch;
  /**
   * Propiedad para el numero de empleado.
   */
  @PrimaryKeyJoinColumn(name = DatabaseConstant.EMPLOYEE_NUMBER_FIELD,
      referencedColumnName = DatabaseConstant.EMPLOYEE_NUMBER_FIELD)
  @Column(name = DatabaseConstant.EMPLOYEE_NUMBER_FIELD, nullable = false, updatable = false)
  private String employeeNumber;
  /**
   * Propiedad para la fecha de registro.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = DatabaseConstant.REGISTRATION_DATE_FIELD, nullable = false, updatable = false)
  private Date registrationDate;
  /**
   * Propiedad para las entregas.
   */
  @Column(name = DatabaseConstant.DELIVERIES_FIELD, nullable = false)
  private int deliveries;
  /**
   * Rol asignado.
   */
  @ManyToOne
  @JoinColumn(name = DatabaseConstant.ASSIGNED_ROL_FIELD,
      referencedColumnName = DatabaseConstant.ID_ROL_FIELD)
  private RolEntity assignedRol;
}
