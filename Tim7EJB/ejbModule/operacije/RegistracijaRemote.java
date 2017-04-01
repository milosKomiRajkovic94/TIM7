package operacije;

import javax.ejb.Remote;

import model.Korisnik;

@Remote
public interface RegistracijaRemote {
	public boolean registracijaKorisnika(Korisnik k);
}
