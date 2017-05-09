package operacije;

import javax.ejb.Remote;

import model.Knjiga2;
import model.Korisnik;

@Remote
public interface LogInRemote {

	public Korisnik ulogujKorisnika(String email, String password);

	public Knjiga2 vratiKnjigu();
}
