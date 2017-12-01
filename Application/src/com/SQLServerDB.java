/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;
import java.sql.*; //allows real interactions

/**
 * This class is an specific implementation of SQLServer database
 */
public class SQLServerDB implements DBManager {

    /**
     * The ip address of the machine which has the dataBase
     */
    private static String IP_ADDRESS;

    /**
     * The port allowed to listen queries
     */
    private static String PORT;

    /**
     * The name of the database
     */
    private static String DATABASE_NAME;

    /**
     * The real object that has the current connection
     */
    private Connection connection;

    /**
     * The constructor
     * @param ipAddress ip address of the machine with the dataBase
     * @param port the port allowed to listen queries
     */
    public SQLServerDB(String ipAddress, String port, String database){
        IP_ADDRESS = ipAddress;
        PORT = port;
        DATABASE_NAME = database;
        this.connection = null;
    }

    @Override
    public boolean connect(String user, String password) {
        //first define the URL
        String dataBaseURL =
                "jdbc:sqlserver://" + IP_ADDRESS + ":" + PORT + ";DatabaseName=" + DATABASE_NAME +
                        ";user=" + user + ";password=" + password;
        //we are trying to connect now
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //danger code
            this.connection = DriverManager.getConnection(dataBaseURL);
            return true;
        } catch (SQLException s){
            //this error is from getConnection line
            s.printStackTrace();
            return false;
        } catch (ClassNotFoundException c){
            //this error is from Class.forName line
            c.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean disconnect() {
        try{
            if((this.connection!=null) && (!this.connection.isClosed())){
                this.connection.close();
            }
            return true;
        } catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isConnected() {
        try{
            if(this.connection!=null){
                return !this.connection.isClosed();
            }
            return false;
        } catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    @Override
    public ResultSet processQuery(String query) {
        try{
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException s){
            s.printStackTrace();
            return null;
        }
    }
}
