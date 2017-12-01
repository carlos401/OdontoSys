/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;

/**
 * This interface allows the app to connect with any database
 */
public interface DBManager {
    /**
     * This methods connects with the DB
     * @param user the user for the connection
     * @param password the password for authentication
     * @return true if the connection was successfully
     */
    boolean connect(String user, String password);


    boolean disconnect();
}
