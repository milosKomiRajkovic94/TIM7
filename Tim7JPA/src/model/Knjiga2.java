package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the KNJIGA2 database table.
 * 
 */
@Entity
@NamedQuery(name="Knjiga2.findAll", query="SELECT k FROM Knjiga2 k")
public class Knjiga2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idknjiga;

	private String autor;

	private byte bestseller;

	private String naslov;

	private String oblast;

	private String opis;

	@Lob
	private byte[] slika;

	//bi-directional many-to-one association to DodatniPodaci
	@OneToMany(mappedBy="knjiga2")
	private List<DodatniPodaci> dodatniPodacis;

	//bi-directional many-to-one association to Administrator
	@ManyToOne
	@JoinColumn(name="IDADMINISTRATOR")
	private Administrator administrator;

	//bi-directional many-to-many association to Korisnik
	@ManyToMany
	@JoinTable(
		name="KNJIGA2_KORISNIK"
		, joinColumns={
			@JoinColumn(name="IDKNJIGA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDKORISNIKA")
			}
		)
	private List<Korisnik> korisniks;

	public Knjiga2() {
	}

	public int getIdknjiga() {
		return this.idknjiga;
	}

	public void setIdknjiga(int idknjiga) {
		this.idknjiga = idknjiga;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public byte getBestseller() {
		return this.bestseller;
	}

	public void setBestseller(byte bestseller) {
		this.bestseller = bestseller;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOblast() {
		return this.oblast;
	}

	public void setOblast(String oblast) {
		this.oblast = oblast;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public List<DodatniPodaci> getDodatniPodacis() {
		return this.dodatniPodacis;
	}

	public void setDodatniPodacis(List<DodatniPodaci> dodatniPodacis) {
		this.dodatniPodacis = dodatniPodacis;
	}

	public DodatniPodaci addDodatniPodaci(DodatniPodaci dodatniPodaci) {
		getDodatniPodacis().add(dodatniPodaci);
		dodatniPodaci.setKnjiga2(this);

		return dodatniPodaci;
	}

	public DodatniPodaci removeDodatniPodaci(DodatniPodaci dodatniPodaci) {
		getDodatniPodacis().remove(dodatniPodaci);
		dodatniPodaci.setKnjiga2(null);

		return dodatniPodaci;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

}