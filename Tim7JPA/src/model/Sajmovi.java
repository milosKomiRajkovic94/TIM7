package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SAJMOVI database table.
 * 
 */
@Entity
@NamedQuery(name="Sajmovi.findAll", query="SELECT s FROM Sajmovi s")
public class Sajmovi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsajma;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_SAJMA")
	private Date datumSajma;

	@Column(name="NAZIV_SAJMA")
	private String nazivSajma;

	//bi-directional many-to-one association to Administrator
	@ManyToOne
	@JoinColumn(name="IDADMINISTRATOR")
	private Administrator administrator;

	public Sajmovi() {
	}

	public int getIdsajma() {
		return this.idsajma;
	}

	public void setIdsajma(int idsajma) {
		this.idsajma = idsajma;
	}

	public Date getDatumSajma() {
		return this.datumSajma;
	}

	public void setDatumSajma(Date datumSajma) {
		this.datumSajma = datumSajma;
	}

	public String getNazivSajma() {
		return this.nazivSajma;
	}

	public void setNazivSajma(String nazivSajma) {
		this.nazivSajma = nazivSajma;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

}