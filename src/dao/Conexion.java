/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//patron singleton para conexxion a base de datos
public class Conexion {
    
    //1. Atributo de clase del tipo clase
    private static Conexion conexion;
    private Connection cnn;
    
    //2. constructor privado
    private Conexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//localizar el driver
        cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/compraBoletos?useLegacyDatetimeCode=false&serverTimezone=America/New_York", "user","pass");
    }
    
    //3. Metodo de clase tipo de la clase
    public static Conexion crearConexion() throws ClassNotFoundException, SQLException{
        
        //4. condicion para controlar el numero de las intrucciones
        if (conexion == null) {
            
            conexion = new Conexion();
        }
        
        return conexion;
    }
    
     //5. metodo para la conexion con la base de datos
    public Connection obtenerConexion(){
        return cnn;
    }
}
