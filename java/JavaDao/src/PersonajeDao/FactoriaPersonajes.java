package PersonajeDao;



import PersonajeDao.PersonajesBD;
import PersonajeDao.PersonajesInterface;


public class FactoriaPersonajes {
    public static PersonajesInterface getPersonajesDao(){
    
        
        return new PersonajesBD();
    }
    
}