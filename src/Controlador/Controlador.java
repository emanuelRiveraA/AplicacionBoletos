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
import vista.RegistroPersona;
import modelo.ComprarBoletoNormal;

/**
 *
 * @author Idalia
 */
public class Controlador implements ActionListener{
    
    //vamos a asociar las clases como se nos venga en gana
    private RegistroPersona registroPersona;
    private BoletoNormal boletoNormal;
    private ComprarBoletoNormal comprarBoletoNormal;
    
    public Controlador(RegistroPersona v){
        //Asociacion con la vista
        this.registroPersona=v;
    }
    
    public void iniciar(String titulo){
        
        //pa darle titulo a la vista
        registroPersona.setTitle(titulo);
        registroPersona.setLocationRelativeTo(null);
        registroPersona.setVisible(true);
        asignarControl();
    }
    
    //Tomar control de los elementod de la vista
    private void asignarControl(){
        
        //
        registroPersona.getBtn_guardar().addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == registroPersona.getBtn_guardar()) calcular();        
        else System.exit(0);
        
    }
    
    private void calcular() {
        
        try {
            String nombre = registroPersona.getTxt_nombre().getText();
            String apellido = registroPersona.getTxt_apellido().getText();
            int edad = Integer.parseInt(registroPersona.getTxt_edad().getText());
            
            boletoNormal = new BoletoNormal(48.5, 5);
            
            comprarBoletoNormal = new ComprarBoletoNormal();
            
            String sql = "insert into boletoNormal values(null,?,?,?,?)";
            PreparedStatement ps;
            
            ps = Conexion.crearConexion().obtenerConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);
            ps.setFloat(4, (float) comprarBoletoNormal.calcularPrecio(boletoNormal));
            
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
}
