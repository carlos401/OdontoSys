/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;

import java.sql.ResultSet;

/**
 * This interface allows the app to connect with any database
 */
public interface DBManager {
    /**
     * Connects with the Database using authentication
     * @param user the username to connect
     * @param password the password for authentication
     * @return true if the connection was successfully, false otherwise
     */
    boolean connect(String user, String password);

    /**
     * Disconnects the Database if the connection already exists
     * @return true if the disconnection was successfully, false otherwise
     */
    boolean disconnect();

    /**
     * Allows to execute SQL statements to the Database
     * important: use the method isConnected to avoid exceptions
     * @param query the query to execute
     * @return A result set of rows
     */
    ResultSet processQuery(String query);

    /**
     * Use this method to know if some connection is active
     * @return true if the connection is active, false otherwise
     */
    boolean isConnected();
}
