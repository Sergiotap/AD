package ArmaDao;



import ArmaDao.ArmasBD;
import ArmaDao.ArmasInterface;


public class FactoriaArmas {
    public static ArmasInterface getArmasDao(){
    
        
        return new ArmasBD();
    }

    
}