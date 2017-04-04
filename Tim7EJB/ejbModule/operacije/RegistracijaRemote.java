package operacije;

import javax.ejb.Remote;

import model.Knjiga2;
import model.Korisnik;

@Remote
public interface RegistracijaRemote {
	public boolean registracijaKorisnika(Korisnik k);
	public boolean unesiKnjigu(Knjiga2 k);
}
