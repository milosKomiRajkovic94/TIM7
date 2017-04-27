package operacije;

import java.util.ArrayList;

import javax.ejb.Remote;

import model.Forum;
import model.Knjiga2;
import model.Komentar;
import model.Korisnik;
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
}
