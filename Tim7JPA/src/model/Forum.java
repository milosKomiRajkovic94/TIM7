package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FORUM database table.
 * 
 */
@Entity
@NamedQuery(name="Forum.findAll", query="SELECT f FROM Forum f")
public class Forum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idforuma;

	private String naziv;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="IDKORISNIKA")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="forum")
	private List<Komentar> komentars;

	public Forum() {
	}

	public int getIdforuma() {
		return this.idforuma;
	}

	public void setIdforuma(int idforuma) {
		this.idforuma = idforuma;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setForum(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setForum(null);

		return komentar;
	}

}