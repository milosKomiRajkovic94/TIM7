package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ADMINISTRATOR database table.
 * 
 */
@Entity
@Table(name="ADMINISTRATOR")
@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Administrator(String email, String ime, String mesto, String password, String prezime, Date datumrodjenja){
		this.email = email;
		this.ime = ime;
		this.mesto = mesto;
		this.password = password;
		this.prezime = prezime;
		this.datumrodjenja = datumrodjenja;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idadministrator;

	@Temporal(TemporalType.DATE)
	private Date datumrodjenja;

	private String email;

	private String ime;

	private String mesto;

	private String password;

	private String prezime;

	//bi-directional many-to-many association to Knjiga2
	@ManyToMany(mappedBy="administrators")
	private List<Knjiga2> knjiga2s;

	//bi-directional many-to-one association to Sajmovi
	@OneToMany(mappedBy="administrator")
	private List<Sajmovi> sajmovis;

	public Administrator() {
	}

	public int getIdadministrator() {
		return this.idadministrator;
	}

	public void setIdadministrator(int idadministrator) {
		this.idadministrator = idadministrator;
	}

	public Date getDatumrodjenja() {
		return this.datumrodjenja;
	}

	public void setDatumrodjenja(Date datumrodjenja) {
		this.datumrodjenja = datumrodjenja;
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

	public List<Sajmovi> getSajmovis() {
		return this.sajmovis;
	}

	public void setSajmovis(List<Sajmovi> sajmovis) {
		this.sajmovis = sajmovis;
	}

	public Sajmovi addSajmovi(Sajmovi sajmovi) {
		getSajmovis().add(sajmovi);
		sajmovi.setAdministrator(this);

		return sajmovi;
	}

	public Sajmovi removeSajmovi(Sajmovi sajmovi) {
		getSajmovis().remove(sajmovi);
		sajmovi.setAdministrator(null);

		return sajmovi;
	}

}