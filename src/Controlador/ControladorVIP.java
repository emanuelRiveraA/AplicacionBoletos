/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.BoletoNormal;
import modelo.BoletoVIP;
import modelo.ComprarBoletoVIP;
import vista.RegistroPersonaVIP;

/**
 *
 * @author Idalia
 */
public class ControladorVIP implements ActionListener{

   //vamos a asociar las clases como se nos venga en gana
    private RegistroPersonaVIP registroPersonaVIP;
    private BoletoVIP boletoVIP;
    private ComprarBoletoVIP comprarBoletoVIP;
    
    public ControladorVIP(RegistroPersonaVIP v){
        //Asociacion con la vista
        this.registroPersonaVIP=v;
    }
    
    public void iniciar(String titulo){
        
        //pa darle titulo a la vista
        registroPersonaVIP.setTitle(titulo);
        registroPersonaVIP.setLocationRelativeTo(null);
        registroPersonaVIP.setVisible(true);
        asignarControl();
    }
    
    //Tomar control de los elementod de la vista
    private void asignarControl(){
        
        //
        registroPersonaVIP.getBtn_guardar().addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == registroPersonaVIP.getBtn_guardar()) calcular();        
        else System.exit(0);
        
    }
    
    private void calcular() {
        
        try {
            String nombre = registroPersonaVIP.getTxt_nombre().getText();
            String apellido = registroPersonaVIP.getTxt_apellido().getText();
            int edad = Integer.parseInt(registroPersonaVIP.getTxt_edad().getText());
            
            boletoVIP = new BoletoVIP(90, 3, 20);
            
            comprarBoletoVIP = new ComprarBoletoVIP();
            
            String sql = "insert into boletoVIP values(null,?,?,?,?)";
            PreparedStatement ps;
            
            ps = Conexion.crearConexion().obtenerConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);
            ps.setFloat(4, (float) comprarBoletoVIP.calcularPrecio(boletoVIP));
            
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
