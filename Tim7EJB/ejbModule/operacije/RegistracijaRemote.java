package operacije;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.Administrator;
import model.DodatniPodaci;
import model.Forum;
import model.Knjiga2;
import model.Komentar;
import model.Korisnik;
import model.Sajmovi;
import model.Utiscioknjizi;

@Remote
public interface RegistracijaRemote {
	public boolean registracijaKorisnika(Korisnik k);
	public boolean unesiKnjigu(Knjiga2 k);
	public ArrayList<Knjiga2> vratiPoAutoru(String tekstKriterijuma);
	public ArrayList<Knjiga2> vratiBestSellere();
	public ArrayList<Knjiga2> vratiPoNaslovu(String tekstKriterijuma);
	public Knjiga2 vratiKnjiguPoIDu(int idknjiga);
	public boolean unesiUtisak(String utisak, Knjiga2 k);
	public ArrayList<Utiscioknjizi> vratiUtiske(Knjiga2 k);
	public boolean unosForuma(String naziv, Korisnik k);
	public ArrayList<Forum> vratiForume();
	public Forum vratiForumPoIDu(int idforuma);
	public boolean unosObjave(String objava, Forum f);
	public ArrayList<Komentar> vratKomentare(Forum forum);
	public boolean unosDodatnogPodatka(float cena, String lokacija, Knjiga2 knjiga);
	public List<DodatniPodaci> vratiSveDP();
	public boolean unesiSajam(Sajmovi s);
	public Administrator vratiAdministratora();
	public ArrayList<Sajmovi> prikazZanimljivosti();
	public boolean unesiOcenuKnjige(Knjiga2 knj, String ocena);
}
