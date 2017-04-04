package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the KNJIGA2 database table.
 * 
 */
@Entity
@Table(name="KNJIGA2")
@NamedQuery(name="Knjiga2.findAll", query="SELECT k FROM Knjiga2 k")
public class Knjiga2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Knjiga2(String autor,boolean bestseller,String naslov,String oblast,String opis,byte[] img,Korisnik k){
		this.autor = autor;
		this.bestseller = bestseller;
		this.naslov = naslov;
		this.oblast = oblast;
		this.opis = opis;
		this.slika = img;
		this.korisnik = k;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idknjiga;

	private String autor;

	private boolean bestseller;

	private String naslov;

	private String oblast;

	private String opis;

	@Lob
	private byte[] slika;

	//bi-directional many-to-one association to DodatniPodaci
	@OneToMany(mappedBy="knjiga2")
	private List<DodatniPodaci> dodatniPodacis;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="IDKORISNIKA")
	private Korisnik korisnik;

	//bi-directional many-to-many association to Administrator
	@ManyToMany
	@JoinTable(
		name="KNJIGA2_ADMINISTRATOR"
		, joinColumns={
			@JoinColumn(name="IDKNJIGA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDADMINISTRATOR")
			}
		)
	private List<Administrator> administrators;

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

	public boolean getBestseller() {
		return this.bestseller;
	}

	public void setBestseller(boolean bestseller) {
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

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Administrator> getAdministrators() {
		return this.administrators;
	}

	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}

}