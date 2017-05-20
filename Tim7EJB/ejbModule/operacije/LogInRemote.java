package operacije;

import javax.ejb.Remote;

import model.Administrator;
import model.Knjiga2;
import model.Korisnik;

@Remote
public interface LogInRemote {

	public Korisnik ulogujKorisnika(String email, String password);

	public Knjiga2 vratiKnjigu();
	
	Administrator ulogujAdministratora(String email, String password);
}
