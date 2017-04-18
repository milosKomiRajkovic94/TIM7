package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UTISCIOKNJIZI database table.
 * 
 */
@Entity
@NamedQuery(name="Utiscioknjizi.findAll", query="SELECT u FROM Utiscioknjizi u")
public class Utiscioknjizi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Utiscioknjizi(String utisak, Knjiga2 k){
		this.utisak = utisak;
		this.knjiga2 = k;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idutiska;

	private String utisak;

	//bi-directional many-to-one association to Knjiga2
	@ManyToOne
	@JoinColumn(name="IDKNJIGA")
	private Knjiga2 knjiga2;

	public Utiscioknjizi() {
	}

	public int getIdutiska() {
		return this.idutiska;
	}

	public void setIdutiska(int idutiska) {
		this.idutiska = idutiska;
	}

	public String getUtisak() {
		return this.utisak;
	}

	public void setUtisak(String utisak) {
		this.utisak = utisak;
	}

	public Knjiga2 getKnjiga2() {
		return this.knjiga2;
	}

	public void setKnjiga2(Knjiga2 knjiga2) {
		this.knjiga2 = knjiga2;
	}

}