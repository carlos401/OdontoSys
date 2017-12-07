/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 * @author Jose Tenorio Wong
 */

package gui;

/**
 * This enum is used to define the types of windows to show
 */
public enum Grant{
    /**
     * All privileges in the view
     */
    ADMINISTRATOR,

    /**
     * More restrict than admin
     */
    SECRETARY,

    /**
     * Only reports about incomes and costs
     */
    ACCOUNTANT,

    /**
     * The default user
     */
    DEFAULT
}
