/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionboletos;

import Controlador.Controlador;
import Controlador.ControladorEntradasSalidas;
import Controlador.ControladorVIP;
import java.awt.EventQueue;
import vista.EntradasSalidas;
import vista.RegistroPersona;
import vista.RegistroPersonaVIP;

/**
 *
 * @author Idalia
 */
public class MainGenerico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //polimorfismo por genericos----- hay otros por sobrecarga de metodos y por herencia
        
        EventQueue.invokeLater(() -> {
           new Controlador(new RegistroPersona()).iniciar("Comprar Boleto Normal");
            new ControladorVIP(new RegistroPersonaVIP()).iniciar("Comprar Boleto VIP");
            new ControladorEntradasSalidas(new EntradasSalidas()).iniciar("Registrar Entradas-salidas");
        });
    }
    
}
