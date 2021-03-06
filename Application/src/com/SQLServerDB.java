/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;
import java.sql.*; //allows real interactions
import java.util.List;

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
     * @param ipAddress the ip address of the machine that has the dataBase
     * @param port the port allowed to listen queries
     */
    public SQLServerDB(String ipAddress, String port, String database){
        IP_ADDRESS = ipAddress;
        PORT = port;
        DATABASE_NAME = database;
        //to create a connection use the methods created for this
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
        } catch (ClassNotFoundException c){
            //this error is from Class.forName line
            c.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean disconnect() {
        try{
            if((this.connection!=null) && (!this.connection.isClosed())){
                this.connection.close();
                return true;
            }
        } catch (SQLException s){
            s.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isConnected() {
        try{
            if(this.connection!=null){
                return !this.connection.isClosed();
            }
        } catch (SQLException s){
            s.printStackTrace();
        }
        return false;
    }

    @Override
    public ResultSet processQuery(String query) {
        try{
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException s){
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet callStoredProcedure(String sql, List<String> parameters) {
        try{
            //statement which will be called
            CallableStatement cst = this.connection.prepareCall(sql);
            //set all the parameters to the function
            for(int index=1 ; index <= parameters.size(); ++index){
                cst.setString(index,parameters.get(index-1));
            }
            if(cst.execute()){
                return cst.getResultSet();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
