/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * CI1312 - BASES DE DATOS I
 * @version 1.0
 * @author Carlos Delgado Rojas
 */
package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public JPanel pnLogin;
    private JButton entrarButton2;
    private JPasswordField pwUser;
    private JTextField tfUserName;
    private JButton cancelarButton;
    private JLabel lbImage;
    private WindowManager wmManager;


    public Login(WindowManager pManager) {

        wmManager = pManager;

        entrarButton2.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfUserName.getText();
                String pass =  new String(pwUser.getPassword());
                if(pass != "" && user != ""){
                    wmManager.validateUser(user,pass);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Por favor ingrese un usuario y contraseña validos");
                }
                //wmManager.createGUI(Grant.ACCOUNTANT);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pnLogin = new JPanel();
        entrarButton2 = new JButton();
        pwUser = new JPasswordField();
        tfUserName = new JTextField();
        cancelarButton = new JButton();
        lbImage = new JLabel();
    }

    public JPanel getPane(){
        return pnLogin;
    }
}
