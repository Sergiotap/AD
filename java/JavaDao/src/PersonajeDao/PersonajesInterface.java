
package PersonajeDao;

public interface PersonajesInterface {
    // metodos de ciclo
     public PersonajesInterface getNuevoPersonaje(String nombre,int  rareza,String elemento, String arma);
    
     public int getRareza();
     public String getElemento();
     public String getArma();
     
     public void  setRareza(int rareza);
     public void  setElemento(String elemento);
     public void  setArma(String arma);
}