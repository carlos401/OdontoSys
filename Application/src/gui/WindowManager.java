/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 * @author Jose Tenorio Wong
 */

package gui;
import com.Application;
import javax.swing.*;

public class WindowManager {
    /**
     * The app that has called this manager
     * use this reference to do things with the DB
     */
    private Application application;

    /**
     * The constructor
     * @param application the reference of the app
     */
    public WindowManager(Application application){
        this.application = application;
    }

    /**
     * The name of the application
     * this is shown on screen
     */
    private final String TITLE =
            "Sistema de Registro de Transacciones - OdontoSys"; //remember that the code is typed in English, but GUI is in Spanish

    /**
     * T
     * @param pUser
     * @param pPass
     */
    public void validateUser(String pUser,String pPass){
    }

    /**
     * Este metodo se encarga de escoger la interfaz grafica del usuario de que se esta loggeando en la applicacion
     *
     * @param pTipo
     */
    public void createGUI(Grant pTipo){
        switch (pTipo){
            case ADMINISTRATOR:
                break;
            case SECRETARY:
                break;
            case ACCOUNTANT:
                break;
            case DEFAULT:
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
