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
     * This methods connects with the DB
     * @param user the user for the connection
     * @param password the password for authentication
     * @return true if the connection was successfully
     */
    boolean connect(String user, String password);

    /**
     * Disconnects the dataBase
     * @return true if the disconnection was successfully
     */
    boolean disconnect();

    /**
     * Allows to execute SQL statement to the DB
     * first use the method isConnected to avoid exceptions
     * @param query the query to execute
     * @return A result set of tuples
     */
    ResultSet processQuery(String query);

    /**
     * Use this method to know if some connection us active
     * @return true if the connection is active
     */
    boolean isConnected();
}
