package operacije;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Knjiga2;
import model.Korisnik;
import model.Utiscioknjizi;

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


	@Override
	public ArrayList<Knjiga2> vratiBestSellere() {
		// TODO Auto-generated method stub
		boolean upit = true;
		TypedQuery<Knjiga2> query = em.createQuery("SELECT knjiga FROM Knjiga2 knjiga WHERE knjiga.bestseller = :upit", Knjiga2.class);
		query.setParameter("upit", upit);
		return (ArrayList<Knjiga2>) query.getResultList();
	}
	
	@Override
	public ArrayList<Knjiga2> vratiPoNaslovu(String tekstKriterijuma) {
		// TODO Auto-generated method stub
		TypedQuery<Knjiga2> query = em.createQuery("SELECT knjiga FROM Knjiga2 knjiga WHERE knjiga.naslov = :naslov", Knjiga2.class);
		query.setParameter("naslov", tekstKriterijuma);
		return (ArrayList<Knjiga2>) query.getResultList();
	}
	
	@Override
	public ArrayList<Knjiga2> vratiPoAutoru(String tekstKriterijuma) {
		// TODO Auto-generated method stub
		TypedQuery<Knjiga2> query = em.createQuery("SELECT knjiga FROM Knjiga2 knjiga WHERE knjiga.autor = :autor", Knjiga2.class);
		query.setParameter("autor", tekstKriterijuma);
		return (ArrayList<Knjiga2>) query.getResultList();
	}


	@Override
	public Knjiga2 vratiKnjiguPoIDu(int idknjige) {
		// TODO Auto-generated method stub
		TypedQuery<Knjiga2> query = em.createQuery("SELECT k FROM Knjiga2 k where k.idknjiga =:id", Knjiga2.class);
		query.setParameter("id", idknjige);
		return query.getSingleResult();
	}
	
	@Override
	public ArrayList<Utiscioknjizi> vratiUtiske(Knjiga2 k) {
		// TODO Auto-generated method stub
		TypedQuery<Utiscioknjizi> query = em.createQuery("SELECT utisak FROM Utiscioknjizi utisak WHERE utisak.knjiga2 =:k", Utiscioknjizi.class);
		query.setParameter("k", k);
		return (ArrayList<Utiscioknjizi>) query.getResultList();
	}
	
	@Override
	public boolean unesiUtisak(String utisak, Knjiga2 k) {
		// TODO Auto-generated method stub
		Utiscioknjizi u = new Utiscioknjizi(utisak, k);
		em.persist(u);
		return true;
	}
}
