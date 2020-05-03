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
import vista.EntradasSalidas;

/**
 *
 * @author Idalia
 */
public class ControladorEntradasSalidas implements ActionListener{
    
    //vamos a asociar las clases como se nos venga en gana
    private EntradasSalidas entradasSalidas;
    
    public ControladorEntradasSalidas(EntradasSalidas v){
        //Asociacion con la vista
        this.entradasSalidas=v;
    }
    
    public void iniciar(String titulo){
        
        //pa darle titulo a la vista
        entradasSalidas.setTitle(titulo);
        entradasSalidas.setLocationRelativeTo(null);
        entradasSalidas.setVisible(true);
        asignarControl();
    }
    
    //Tomar control de los elementod de la vista
    private void asignarControl(){
        
        //
        entradasSalidas.getBtn_guardar().addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == entradasSalidas.getBtn_guardar()) calcular();        
        else System.exit(0);
        
    }
    
    private void calcular() {
        
        try {
            String entrada = entradasSalidas.getTxt_entrada().getText();
            String salida = entradasSalidas.getTxt_salida().getText();
            int numero = Integer.parseInt(entradasSalidas.getTxt_num_boleto().getText());
                        
            String sql = "insert into Entradas_Salidas values(null,?,?,?)";
            PreparedStatement ps;
            
            ps = Conexion.crearConexion().obtenerConexion().prepareStatement(sql);
            ps.setString(1, entrada);
            ps.setString(2, salida);
            ps.setInt(3, numero);
            
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
