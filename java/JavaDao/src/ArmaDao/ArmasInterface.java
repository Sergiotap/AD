
package ArmaDao;

public interface ArmasInterface {
    // metodos de ciclo
     public ArmasInterface getNuevoArma(String nombre,int  rareza,String tipo);
    
     public int getRareza();
     public String getTipo();     
     public void  setRareza(int rareza);
     public void  setTipo(String tipo);
}