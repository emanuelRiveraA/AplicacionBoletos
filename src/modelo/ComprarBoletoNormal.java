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
public class ComprarBoletoNormal implements Boleto<BoletoNormal>{

    @Override
    public double calcularPrecio(BoletoNormal obj) {
        return (obj.getPrecio()*obj.getHora_permanencia());
    }
    
}
