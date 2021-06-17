package com.rinku.services.customer.delivery.management.constant;

/**
 * Database constants.
 * 
 * @author Felipe Monzón
 * @since 27 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class DatabaseConstant {
  /**
   * Propiedad para el campo "create_user".
   */
  public static final String CREATE_USER = "create_user";
  /**
   * Property for table field "create_date".
   */
  public static final String CREATE_DATE = "create_date";
  /**
   * Property for table field "lastmodified_user".
   */
  public static final String LAST_MODIFIED_USER = "lastmodified_user";
  /**
   * Property for table field "lastmodified_date".
   */
  public static final String LAST_MODIFIED_DATE = "lastmodified_date";
  /**
   * Property for table name "Activity".
   */
  public static final String ACTIVITIES_TABLE = "activities";
  /**
   * Property for table name "id_activities".
   */
  public static final String ID_ACTIVITY_FIELD = "id_activities";
  /**
   * Property for table field "registration_date".
   */
  public static final String REGISTRATION_DATE_FIELD = "registration_date";
  /**
   * Property for table field "rol".
   */
  public static final String ROL_FIELD = "rol";
  /**
   * Property for table field "employee_number".
   */
  public static final String EMPLOYEE_NUMBER_FIELD = "employee_number";
  /**
   * Property for table field "deliveries".
   */
  public static final String DELIVERIES_FIELD = "deliveries";
  /**
   * Property for table field "assigned_rol".
   */
  public static final String ASSIGNED_ROL_FIELD = "assigned_rol";
  /**
   * Property for table field "invoicebranch".
   */
  public static final String INVOICE_BRANCH_FIELD = "invoicebranch";
  /**
   * Property for table name "roles".
   */
  public static final String ROLES_TABLE = "roles";
  /**
   * Property for table field "id_role".
   */
  public static final String ID_ROL_FIELD = "id_rol";
  /**
   * Property for table field "description".
   */
  public static final String DESCRIPTION_FIELD = "description";
  /**
   * Property for table filed "salary".
   */
  public static final String SALARY_FIELD = "salary";
  /**
   * Consulta si el empleado ya registro sus entregas del dia.
   */
  public static final String FIND_BY_EMPLOYEE_AND_DATE =
      "SELECT act.id_activities, act.assigned_rol, act.deliveries, act.employee_number, act.invoicebranch, act.registration_date "
          + "FROM rinku.activities act WHERE act.employee_number = :employeeNumber "
          + "AND CAST(act.registration_date AS DATE) = :registrationDate";
  /**
   * Parametro para el numero de empleado.
   */
  public static final String EMPLOYEE_NUMBER_PARAMETER = "employeeNumber";
  /**
   * Parametro para la fecha de registro.
   */
  public static final String REGISTRATION_DATE_PARAMETER = "registrationDate";

  /**
   * Private constructor to avoid initializations .
   */
  private DatabaseConstant() {}
}
