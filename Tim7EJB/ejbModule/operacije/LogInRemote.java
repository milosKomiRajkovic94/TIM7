package operacije;

import javax.ejb.Remote;

import model.Korisnik;

@Remote
public interface LogInRemote {
	public Korisnik ulogujKorisnika(String email, String password);
}
