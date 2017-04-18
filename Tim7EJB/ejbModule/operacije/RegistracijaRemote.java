package operacije;

import java.util.ArrayList;

import javax.ejb.Remote;

import model.Knjiga2;
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
}
