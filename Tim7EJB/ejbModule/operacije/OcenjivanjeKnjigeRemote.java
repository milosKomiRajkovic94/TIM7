package operacije;

import java.util.ArrayList;

import javax.ejb.Remote;

import model.Knjiga2;

@Remote
public interface OcenjivanjeKnjigeRemote {

	ArrayList<Knjiga2> vratiKnjige();

}
