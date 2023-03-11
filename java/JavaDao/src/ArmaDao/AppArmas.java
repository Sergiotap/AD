/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArmaDao;

/**
 *
 * @author iesjdc
 */
public class AppArmas {
    public static void main(String[] args) {
 
     ArmasInterface objetoDAO = FactoriaArmas.getArmasDao();
        
       ArmasInterface  arma1=objetoDAO.getNuevoArma("Juramento por la libertad",5,"Espada Ligera" );
    }
}
