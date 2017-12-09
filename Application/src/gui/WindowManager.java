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
    private JFrame frameGUI;
    /**
     * The constructor
     * @param application the reference of the app
     */
    public WindowManager(Application application){

        this.frameGUI = new JFrame(TITLE);
        this.frameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.application = application;
    }

    /**
     * The name of the application
     * this is shown on screen
     */
    private final String TITLE =
            "Sistema de Registro de Transacciones - OdontoSys"; //remember that the code is typed in English, but GUI is in Spanish


    //ksldjfñsdjfsñlkj dfñsldkjfsñldkjfsñldkjf ñlskj dfñlksj dñflkjsdñlf kjsdñlk fjsñldkjf ñsldkjf ñlskdjf sñldkj fsñlkd jfñslk djf
    /**
     *
     * @param pUser
     * @param pPass
     */
    public void validateUser(String pUser,String pPass){
        //this.application.connectUser(pUser,pPass);
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
                runAccountant();
                break;
            case DEFAULT:
                break;
            default:
                break;
        }
    }

    public void runLogin(){
        this.frameGUI.setContentPane(new Login(this).getPane());
        frameGUI.pack();
        frameGUI.setVisible(true);

    }

    private void runAdministrator(){

    }

    private void runSecretary(){

    }

    private void runAccountant(){
        frameGUI.setContentPane(new Accountant(this).getPane());
        frameGUI.pack();
        frameGUI.setVisible(true);

    }
}
