/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */

package gui;

import javax.swing.*;

public class WindowManager {

    private final int ADMINISTRATOR = 89;
    private final int SECRETARY = 2;
    private final int CONTABLE = 1;
    private final int GENERICO = 68;
    private final String TITLE = "Sistema de Registro de Transacciones - OdontoSys";

    public WindowManager(){

    }
    /**
     *
     * @param pUser
     * @param pPass
     */
    public void validateUser(String pUser,String pPass){
        //App.
    }

    /**
     * Este metodo se encarga de escoger la interfaz grafica del usuario de que se esta loggeando en la applicacion
     *
     * @param pTipo
     */
    public void createGUI(int pTipo){
        switch (pTipo){
            case ADMINISTRATOR:
                break;
            case SECRETARY:
                break;
            case CONTABLE:
                break;
            case GENERICO:
                break;
            default:
                break;
        }
    }

    private void runLogin(){
        JFrame frame = new JFrame(TITLE);
        frame.setContentPane(new Login(this).getPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void runAdministrator(){

    }

    private void runSecretary(){

    }

    private void runAccountant(){

    }

}
