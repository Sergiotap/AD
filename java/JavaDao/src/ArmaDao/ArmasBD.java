package ArmaDao;

import java.sql.*;

import java.sql.SQLException;
/**
 *
 * @author iesjdc
 */
public class ArmasBD implements ArmasInterface{
    private String nombre, tipo;
    private int rareza;
    private java.sql.Connection conexion=null;
    
    public ArmasBD () {
    }
    
     public ArmasInterface getNuevoArma(String nombre,int  rareza, String tipo){
        conexion=getConexion();
        java.sql.Statement sentencia=null;
        
        try{
            sentencia=conexion.createStatement();
            sentencia.execute("INSERT INTO proyecto1.ARMAS VALUES ('"+nombre+"',"+rareza+",'"+tipo+"')"); 
            
            }catch(SQLException e){  
                System.out.println("Error al intentar insertar Arma"+ e.getMessage());
                return null;
            }
        
        
        ArmasBD arma= new ArmasBD();
        arma.nombre=nombre;
        arma.rareza=rareza;
        arma.tipo=tipo;
         
        return arma;
        
    }
     
     
    
    public String getNombre(){
        return nombre;
    }
    
    public int getRareza(){
        return rareza;
    }
    public String getTipo(){
        return tipo;
    }

    
    public void  setTipo(String tipo){ 
        
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        
        try{
            sentencia= conexion.createStatement();
        
            
            sentencia.execute("UPDATE proyecto1.ARMAS SET TIPO'"+tipo+"'WHERE NOMBRE='"+this.nombre+"'");
                     
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al realizar un cambio de tipo de arma");
            return;
        }
        
        this.tipo=tipo;
        
    }
    
    public void  setRareza(int rareza){
        conexion=getConexion();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexion.createStatement(); 
        

            sentencia.execute("UPDATE proyecto1.ARMAS SET rareza="+rareza+"WHERE NOMBRE='"+this.nombre+"'");
            
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al realizar un cambio de rareza");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        
        this.rareza=rareza;
    }
    
    
    private java.sql.Connection getConexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); //Obtener el driver
        }catch (ClassNotFoundException e){
            System.out.println("No se encuentra la clase del Driver");
            return null; //devuelve null si va mal
        }
        
        Connection conexion= null;
        
        try {
            
            //obtener una conexion
            //DriverManager clase que tiene un objeto que devuelve la conexión
                                                          //jdbc:gestor:maquina:puerto/bbdd , usuario, pwd
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root", "");
                                                           
        } catch (SQLException e){
            System.out.println("No se puede obtener la conexión");
            return null;
        }
        return conexion;
    }
    
     
       
    
    
}