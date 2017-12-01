/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;
import gui.WindowManager;

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
        //this may change to OracleDB for example
       this.dataBase = new SQLServerDB("172.16.202.58","1433","EMPRESA");

       //also instances the windowManager
       this.windowManager = new WindowManager();
    }

    /**
     * This method initializes the connection to the DB using the interface
     *  also begins the user interactions through the WindowManager
     */
    public void start(){
        this.dataBase.connect("Carlos","contra1234");
        System.out.println("Connection successful");
        //content here
    }
}
