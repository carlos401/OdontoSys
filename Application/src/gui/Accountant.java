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
import java.util.Calendar;

public class Accountant {
    private JPanel pnConsultaDeFacturas;
    private JTabbedPane tabbedPane1;
    private JLabel lbUserName;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JTextField tfNumeroFactura;
    private JLabel lbTransaccion;
    private JComboBox cbProveedor;
    private JTextArea textArea1;
    private JRadioButton rbGenCompra;
    private JRadioButton rbGenVenta;
    private JComboBox cbDesdeMes;
    private JComboBox cbDesdeAño;
    private JComboBox cbHastaAño;
    private JComboBox cbDesdeDia;
    private JComboBox cbHastaDia;
    private JComboBox cbGenerarProveedor;
    private JTable tbTabla;
    private JComboBox cbHastaMes;
    private JButton btConsultar;
    private JButton btGenerar;
    private JLabel lbProveedor;
    private int countToEnableConsulta;
    private int countToEnableGenerar;
    private WindowManager wmManager;

    public Accountant(WindowManager pManager) {
        countToEnableConsulta = 0;
        countToEnableGenerar = 0;
        rbGenCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbGenVenta.setSelected(false);
                if(countToEnableGenerar == 0){
                    enableGenerar();
                    for (int i = 1960; i < Calendar.getInstance().get(Calendar.YEAR); i++) {
                        cbDesdeAño.addItem(i);
                        cbHastaAño.addItem(i);
                    }
                    countToEnableGenerar++;
                }
                else{
                    lbProveedor.setText("Proveedor");
                    //Cargar los proveedores en el combobox cbGenerarProveedores

                }


            }
        });

        rbGenVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbGenCompra.setSelected(false);
                if(countToEnableGenerar == 0){
                    enableGenerar();
                    for (int i = 1960; i < Calendar.getInstance().get(Calendar.YEAR); i++) {
                        cbDesdeAño.addItem(i);
                        cbHastaAño.addItem(i);
                    }
                    countToEnableGenerar++;
                }
                else{
                    lbProveedor.setText("Cliente");
                    //Cargar los clientes en el combobox cbGenerarProveedores
                    countToEnableConsulta = 0;
                }
            }
        });

        //--------------------------------------------------------------------------------------------------------
        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbVenta.setSelected(false);
                if(countToEnableConsulta == 0){
                    cbProveedor.setEnabled(true);
                    tfNumeroFactura.setEnabled(true);
                    btConsultar.setEnabled(true);
                    countToEnableConsulta++;
                }

            }
        });
        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbCompra.setSelected(false);
                if(countToEnableConsulta == 0){
                    cbProveedor.setEnabled(true);
                    tfNumeroFactura.setEnabled(true);
                    btConsultar.setEnabled(true);
                    countToEnableConsulta++;
                }
                else{
                    cbProveedor.setEnabled(false);
                    countToEnableConsulta = 0;
                }
            }
        });
        //-------------------------------------------------------------------------------------------------------
        cbDesdeMes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = cbDesdeMes.getSelectedItem();
                System.out.println(selectedItem.toString());
                int days = calcDias(selectedItem.toString(),1);
                cbDesdeDia.removeAllItems();
                for (int j = 1; j <= days; j++) {
                    cbDesdeDia.addItem(j);
                }
                cbDesdeDia.setEnabled(true);
            }
        });

        cbHastaMes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = cbHastaMes.getSelectedItem();
                System.out.println(selectedItem.toString());
                int days = calcDias(selectedItem.toString(),2);
                cbHastaDia.removeAllItems();
                for (int j = 1; j <= days; j++) {
                    cbHastaDia.addItem(j);
                }
                cbHastaDia.setEnabled(true);
            }
        });


        cbDesdeAño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbDesdeMes.setEnabled(true);
                cbDesdeMes.setSelectedItem(cbDesdeMes.getSelectedItem());
            }
        });
        cbHastaAño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbHastaMes.setEnabled(true);
                cbHastaMes.setSelectedItem(cbHastaMes.getSelectedItem());
            }
        });

    }
    private int calcDias(String pMes,int u){
        int days = 0;
        switch(pMes){
            case "Enero":
            case"Marzo":
            case "Mayo":
            case "Julio":
            case "Agosto":
            case "Octubre":
            case "Diciembre":
                days = 31;
                break;
            case "Abril":
            case "Junio":
            case "Septiembre":
            case "Noviembre":
                days = 30;
                break;
            case "Febrero":
                String año;
                if(u == 1){
                   año = cbDesdeAño.getSelectedItem().toString();
                }
                else{
                    año = cbHastaAño.getSelectedItem().toString();
                }


                int i = Integer.parseInt(año);
                if((i % 400)!=0){
                    if(((i%4) == 0) && ((i%100)!=0)){
                        days = 29;
                    }
                    else{
                        days = 28;
                    }
                }
                else{
                    days = 29;
                }
                break;

        }
        return days;
    }
    private void enableGenerar(){
        cbHastaAño.setEnabled(true);
        //cbDesdeMes.setEnabled(true);
        cbDesdeAño.setEnabled(true);
        //cbHastaMes.setEnabled(true);
        //cbDesdeDia.setEnabled(true);
        //cbHastaDia.setEnabled(true);
        cbGenerarProveedor.setEnabled(true);
        btGenerar.setEnabled(true);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.btConsultar  = new JButton();
        this.tfNumeroFactura = new JTextField();
        this.cbProveedor = new JComboBox();
        this.btGenerar = new JButton();
        this.cbDesdeDia = new JComboBox();
        this.cbHastaDia = new JComboBox();
        this.cbDesdeMes = new JComboBox();
        this.cbHastaMes = new JComboBox();
        this.cbDesdeAño = new JComboBox();
        this.cbHastaAño = new JComboBox();

        this.btConsultar = new JButton();
        this.cbGenerarProveedor = new JComboBox();
        this.rbCompra = new JRadioButton();
        this.rbVenta = new JRadioButton();
        this.rbGenVenta = new JRadioButton();
        this.rbGenCompra = new JRadioButton();
        this.pnConsultaDeFacturas = new JPanel();
        this.tabbedPane1 = new JTabbedPane();
        this.tbTabla = new JTable();
        this.lbTransaccion = new JLabel();
        this.lbUserName = new JLabel();
        this.textArea1 = new JTextArea();
    }

    public JPanel getPane(){
        return pnConsultaDeFacturas;
    }
}
