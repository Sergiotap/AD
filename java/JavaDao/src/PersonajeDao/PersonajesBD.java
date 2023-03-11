package PersonajeDao;

import java.sql.*;

import java.sql.SQLException;
/**
 *
 * @author iesjdc
 */
public class PersonajesBD implements PersonajesInterface{
    private String nombre, elemento, arma;
    private int rareza;
    private java.sql.Connection conexion=null;
    
    public PersonajesBD () {
    }
    
     public PersonajesInterface getNuevoPersonaje(String nombre,int  rareza,String elemento, String arma){
        conexion=getConexion();
        java.sql.Statement sentencia=null;
        
        try{
            sentencia=conexion.createStatement();
            sentencia.execute("INSERT INTO proyecto1.PERSONAJES VALUES ('"+nombre+"',"+rareza+",'"+elemento+"','"+arma+"')"); 
            
            }catch(SQLException e){  
                System.out.println("Error al intentar insertar Personaje"+ e.getMessage());
                return null;
            }
        
        
        PersonajesBD personaje= new PersonajesBD();
        personaje.nombre=nombre;
        personaje.rareza=rareza;
        personaje.elemento=elemento;
        personaje.arma=arma;
         
        return personaje;
        
    }
     
     
    
    public String getNombre(){
        return nombre;
    }
    
    public int getRareza(){
        return rareza;
    }
    public String getElemento(){
        return elemento;
    }
    public String getArma(){
        return arma;
    }
    
    public void  setArma(String arma){ 
        
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        
        try{
            sentencia= conexion.createStatement();
        
            
            sentencia.execute("UPDATE proyecto1.PERSONAJES SET ARMA'"+arma+"'WHERE NOMBRE='"+this.nombre+"'");
                     
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al realizar un cambio de arma");
            return;
        }
        
        this.arma=arma;
        
    }
    
    public void  setRareza(int rareza){
        conexion=getConexion();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexion.createStatement(); 
        

            sentencia.execute("UPDATE proyecto1.PERSONAJES SET rareza="+rareza+"WHERE NOMBRE='"+this.nombre+"'");
            
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
    public void  setElemento(String elemento){ 
        
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        
        try{
            sentencia= conexion.createStatement();
        
            
            sentencia.execute("UPDATE proyecto1.PERSONAJES SET ELEMENTO'"+elemento+"'WHERE NOMBRE='"+this.nombre+"'");
                     
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al realizar un cambio de elemento");
            return;
        }
        
        this.elemento=elemento;
        
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