package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the KORISNIK database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnika;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_RODJENJA")
	private Date datumRodjenja;

	private String email;

	private String ime;

	private String mesto;

	private String password;

	private String prezime;

	//bi-directional many-to-many association to Knjiga2
	@ManyToMany(mappedBy="korisniks")
	private List<Knjiga2> knjiga2s;

	//bi-directional many-to-one association to Forum
	@OneToMany(mappedBy="korisnik")
	private List<Forum> forums;

	public Korisnik() {
	}

	public int getIdkorisnika() {
		return this.idkorisnika;
	}

	public void setIdkorisnika(int idkorisnika) {
		this.idkorisnika = idkorisnika;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Knjiga2> getKnjiga2s() {
		return this.knjiga2s;
	}

	public void setKnjiga2s(List<Knjiga2> knjiga2s) {
		this.knjiga2s = knjiga2s;
	}

	public List<Forum> getForums() {
		return this.forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public Forum addForum(Forum forum) {
		getForums().add(forum);
		forum.setKorisnik(this);

		return forum;
	}

	public Forum removeForum(Forum forum) {
		getForums().remove(forum);
		forum.setKorisnik(null);

		return forum;
	}

}