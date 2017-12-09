/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;
import gui.Grant;
import gui.WindowManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Application {

    /**
     * The real dataBase used
     */
    private DBManager dataBase;

    /**
     * Which controls the GUI interactions
     */
    private WindowManager windowManager;

    /**
     * The default constructor
     */
    public Application(){
        //for this project, instances an SQL database
        //this may be change to OracleDB "for example"
       this.dataBase =
               new SQLServerDB("172.16.202.93","1433","CONSULTORIO_DENTISTAS");
        //the app references itself for management
        this.windowManager = new WindowManager(this);
    }

    /**
     * This method initializes the connection to the DB using the interface
     *  also begins the user interactions through the WindowManager
     */
    public void start(){
        //this.windowManager.
    }

    /**
     * This methods connect with the database using authentication for SQLServer
     * @param username the username to connect
     * @param password the password for authentication
     * @return The corresponding category of user
     */
    public Grant connectUser(String username, String password){
        if(this.dataBase.connect(username,password)){
            //call a function which returns the numeric grant codification
            ArrayList<String> param =
                    new ArrayList<>(1); param.add(username);
            try{
                ResultSet rs = this.dataBase.callStoredProcedure("{call obtenerTipoUsuario(?)}",param);
                if(rs.next()){
                    switch (rs.getInt("Tipo")){
                        case 0:
                            return Grant.ADMINISTRATOR;
                        case 1:
                            return Grant.SECRETARY;
                        case 2:
                            return Grant.ACCOUNTANT;
                        default:
                            return Grant.DEFAULT;
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return Grant.ERROR;
    }
    //
}
