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
public class BoletoNormal {
    
    private double precio;
    private int hora_permanencia;

    public BoletoNormal() {
    }

    public BoletoNormal(double precio, int hora_permanencia) {
        this.precio = precio;
        this.hora_permanencia = hora_permanencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getHora_permanencia() {
        return hora_permanencia;
    }

    public void setHora_permanencia(int hora_permanencia) {
        this.hora_permanencia = hora_permanencia;
    }  

    
    
   
}
