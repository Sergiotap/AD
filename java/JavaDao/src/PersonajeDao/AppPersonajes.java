/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonajeDao;

/**
 *
 * @author iesjdc
 */
public class AppPersonajes {

    public static void main(String[] args) {

        PersonajesInterface objetoDAO = FactoriaPersonajes.getPersonajesDao();

        PersonajesInterface personaje1 = objetoDAO.getNuevoPersonaje("Kaedehara Kazuha", 5, "Anemo", "Espada Ligera");
    }
}
