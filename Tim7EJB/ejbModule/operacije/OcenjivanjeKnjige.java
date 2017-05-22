package operacije;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Knjiga2;

/**
 * Session Bean implementation class OcenjivanjeKnjige
 */
@Stateful
@Startup
@LocalBean
public class OcenjivanjeKnjige implements OcenjivanjeKnjigeRemote {
	@PersistenceContext
	public EntityManager em;
	
	public ArrayList<Knjiga2> knjige;
	
    /**
     * Default constructor. 
     */
    public OcenjivanjeKnjige() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Schedule(year="*", month="*", dayOfMonth="1st")
    public void vratiKnjigePoOcenama(){
    	TypedQuery<Knjiga2> query = em.createQuery("SELECT k FROM Knjiga2 k ORDER BY k.ocena DESC", Knjiga2.class);
		knjige =  (ArrayList<Knjiga2>) query.getResultList();
    }
    
    @Override
    public ArrayList<Knjiga2> vratiKnjige(){
    	return knjige;
    }
}
