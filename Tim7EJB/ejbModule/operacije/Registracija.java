package operacije;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Administrator;
import model.DodatniPodaci;
import model.Forum;
import model.Knjiga2;
import model.Komentar;
import model.Korisnik;
import model.Sajmovi;
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
	public ArrayList<Knjiga2> vratiPoAutoru(String tekstKriterijuma) {
		// TODO Auto-generated method stub
		TypedQuery<Knjiga2> query = em.createQuery("SELECT knjiga FROM Knjiga2 knjiga WHERE knjiga.autor = :autor", Knjiga2.class);
		query.setParameter("autor", tekstKriterijuma);
		return (ArrayList<Knjiga2>) query.getResultList();
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
	public Knjiga2 vratiKnjiguPoIDu(int idknjiga) {
		// TODO Auto-generated method stub
		TypedQuery<Knjiga2> query = em.createQuery("SELECT k FROM Knjiga2 k where k.idknjiga =:id", Knjiga2.class);
		query.setParameter("id", idknjiga);
		return query.getSingleResult();
	}


	@Override
	public boolean unesiUtisak(String utisak, Knjiga2 k) {
		// TODO Auto-generated method stub
		Utiscioknjizi u = new Utiscioknjizi(utisak, k);
		em.persist(u);
		return true;
	}


	@Override
	public ArrayList<Utiscioknjizi> vratiUtiske(Knjiga2 k) {
		// TODO Auto-generated method stub
		TypedQuery<Utiscioknjizi> query = em.createQuery("SELECT utisak FROM Utiscioknjizi utisak WHERE utisak.knjiga2 =:k", Utiscioknjizi.class);
		query.setParameter("k", k);
		return (ArrayList<Utiscioknjizi>) query.getResultList();
	}

	@Override
	public boolean unosForuma(String naziv, Korisnik k) {
		// TODO Auto-generated method stub
		Forum f = new Forum(naziv, k);
		em.persist(f);
		return true;
	}

	@Override
	public ArrayList<Forum> vratiForume() {
		// TODO Auto-generated method stub
		TypedQuery<Forum> query = em.createQuery("SELECT forum FROM Forum forum", Forum.class);
		return (ArrayList<Forum>) query.getResultList();
	}

	@Override
	public Forum vratiForumPoIDu(int idforuma) {
		// TODO Auto-generated method stub
		TypedQuery<Forum> query = em.createQuery("SELECT forum FROM Forum forum WHERE forum.idforuma = :idforuma", Forum.class);
		query.setParameter("idforuma", idforuma);
		return query.getSingleResult();
	}

	@Override
	public boolean unosObjave(String objava, Forum f) {
		// TODO Auto-generated method stub
		Komentar komentar = new Komentar(objava, f);
		em.persist(komentar);
		return true;
	}

	@Override
	public ArrayList<Komentar> vratKomentare(Forum forum) {
		// TODO Auto-generated method stub
		TypedQuery<Komentar> query = em.createQuery("SELECT k FROM Komentar k WHERE k.forum = :forum", Komentar.class);
		query.setParameter("forum", forum);
		return (ArrayList<Komentar>) query.getResultList();
	}
	
	@Override
	public boolean unosDodatnogPodatka(float cena, String lokacija, Knjiga2 knjiga) {
		// TODO Auto-generated method stub
		DodatniPodaci dp = new DodatniPodaci(cena, lokacija, knjiga);
		em.persist(dp);
		return true;
	}

	@Override
	public List<DodatniPodaci> vratiSveDP() {
		// TODO Auto-generated method stub
		TypedQuery<DodatniPodaci> query = em.createQuery("SELECT dp FROM DodatniPodaci dp", DodatniPodaci.class);
		return query.getResultList();
	}

	@Override
	public boolean unesiSajam(Sajmovi s) {
		// TODO Auto-generated method stub
		em.persist(s);
		return true;
	}

	@Override
	public Administrator vratiAdministratora() {
		// TODO Auto-generated method stub
		TypedQuery<Administrator> query = em.createQuery("SELECT a FROM Administrator a WHERE a.email = :email AND a.password = :password", Administrator.class);
		query.setParameter("email", "administrator@yahoo.com");
		query.setParameter("password", "adiida");
		return query.getSingleResult();
	}
}
