package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DODATNI_PODACI database table.
 * 
 */
@Entity
@Table(name="DODATNI_PODACI")
@NamedQuery(name="DodatniPodaci.findAll", query="SELECT d FROM DodatniPodaci d")
public class DodatniPodaci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddp;

	private float cena;

	private String lokacija;

	//bi-directional many-to-one association to Knjiga2
	@ManyToOne
	@JoinColumn(name="IDKNJIGA")
	private Knjiga2 knjiga2;

	public DodatniPodaci() {
	}

	public int getIddp() {
		return this.iddp;
	}

	public void setIddp(int iddp) {
		this.iddp = iddp;
	}

	public float getCena() {
		return this.cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getLokacija() {
		return this.lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public Knjiga2 getKnjiga2() {
		return this.knjiga2;
	}

	public void setKnjiga2(Knjiga2 knjiga2) {
		this.knjiga2 = knjiga2;
	}

}