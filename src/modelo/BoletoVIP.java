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
public class BoletoVIP {
    
    private double precio;
    private int hora_permanencia;
    private double descuento;
    
    public BoletoVIP() {
    }

    public BoletoVIP(double precio, int hora_permanencia, double descuento) {
        this.precio = precio;
        this.hora_permanencia = hora_permanencia;
        this.descuento = descuento;
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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    
    
    
}
