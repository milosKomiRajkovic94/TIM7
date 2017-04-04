package operacije;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Knjiga2;
import model.Korisnik;

/**
 * Session Bean implementation class Registracija
 */
@Stateless
@LocalBean
public class Registracija implements RegistracijaRemote {
	@PersistenceContext
	EntityManager em;
	/**
     * Default constructor. 
     */
    public Registracija() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public boolean registracijaKorisnika(Korisnik k2) {
		// TODO Auto-generated method stub
		em.persist(k2);
		return true;
	}


	@Override
	public boolean unesiKnjigu(Knjiga2 k) {
		// TODO Auto-generated method stub
		em.persist(k);
		return true;
	}
}
