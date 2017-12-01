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
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton cancelarButton;
    private JLabel lbImage;


    private void createUIComponents() {
        // TODO: place custom component creation code here
        pnLogin = new JPanel();
        entrarButton2 = new JButton();
        passwordField1 = new JPasswordField();
        textField1 = new JTextField();
        cancelarButton = new JButton();
        lbImage = new JLabel();
    }

    public JPanel getPane(){
        return pnLogin;
    }
}
