package operacije;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Administrator;
import model.Knjiga2;
import model.Korisnik;

/**
 * Session Bean implementation class LogIn
 */
@Stateful
@Startup
@LocalBean
public class LogIn implements LogInRemote {
private Korisnik ulogovaniKorisnik;
	
	@PersistenceContext
	EntityManager em;
	
	public Knjiga2 knjiga;

	private Administrator ulogovaniAdministrator;
    /**
     * Default constructor. 
     */
    public LogIn() {
        // TODO Auto-generated constructor stub
    }
    
    public LogIn(Knjiga2 knjiga){
    	this.knjiga = knjiga;
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
	
	@Schedule(year="*", month="*", dayOfMonth="1st",  persistent=false)
	public void vratiKnjiguMeseca(){
		TypedQuery<Knjiga2> q = em.createQuery("SELECT k FROM Knjiga2 k ORDER BY RAND() LIMIT 1", Knjiga2.class);
		knjiga = q.getSingleResult();
	}

	@Override
	public Knjiga2 vratiKnjigu() {
		// TODO Auto-generated method stub
		return knjiga;
	}

	@Override
	public Administrator ulogujAdministratora(String email, String password) {
		// TODO Auto-generated method stub
		TypedQuery<Administrator> query = em.createQuery("SELECT a FROM Administrator a WHERE a.email = :email AND a.password = :password", Administrator.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<Administrator> administratori = query.getResultList();
		
		if(administratori != null && !administratori.isEmpty()){
			ulogovaniAdministrator = administratori.get(0);
			return ulogovaniAdministrator;
		}else{
			ulogovaniAdministrator = null;
			return  null;
		}
	}
}
