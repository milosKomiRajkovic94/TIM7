package operacije;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Korisnik;

/**
 * Session Bean implementation class LogIn
 */
@Stateful
@LocalBean
public class LogIn implements LogInRemote {
private Korisnik ulogovaniKorisnik;
	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public LogIn() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Korisnik ulogujKorisnika(String email, String password) {
		// TODO Auto-generated method stub
		TypedQuery<Korisnik> query = em.createQuery("SELECT k FROM Korisnik k WHERE k.email = :email AND k.password = :password", Korisnik.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<Korisnik> korisnici = query.getResultList();
		if(korisnici != null && !korisnici.isEmpty()){
			ulogovaniKorisnik = korisnici.get(0);
			return ulogovaniKorisnik;
		}else{
			ulogovaniKorisnik = null;
			return  null;
		}
	}
}
