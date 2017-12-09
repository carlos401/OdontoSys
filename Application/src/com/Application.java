/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package com;
import gui.WindowManager;
import java.sql.ResultSet;

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
       //also instances the windowManager
        this.windowManager = new WindowManager();
    }

    /**
     * This method initializes the connection to the DB using the interface
     *  also begins the user interactions through the WindowManager
     */
    public void start(){
        this.dataBase.connect("TPG1","123789654");
        if(this.dataBase.isConnected()){
            System.out.println("Connection successful");
//            ResultSet tuple = this.dataBase.processQuery(
//                    "SELECT * FROM PERSONA P, TELEFONOS T" +
//                            " WHERE P.IDENTIFICACION = T.ID_PERSONA;");
//            try{
//                while(tuple.next()){
//                    System.out.println(tuple.getString("Identificacion") + " " +
//                            tuple.getString("Nombre") + " " +
//                            tuple.getString("Telefono"));
//                }
//            } catch(Exception e){
//                e.printStackTrace(); cambio
//            }
        }
        System.out.println(this.dataBase.disconnect());
        //content here
    }
}
