/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Idalia
 */
public class ComprarBoletoVIP implements Boleto<BoletoVIP>{

    @Override
    public double calcularPrecio(BoletoVIP obj) {
        return ((obj.getPrecio()*obj.getHora_permanencia())-obj.getDescuento());
    }
    
}
