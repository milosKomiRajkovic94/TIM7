package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KOMENTAR database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkomentara;

	private int idforuma;

	private String objava;

	public Komentar() {
	}

	public int getIdkomentara() {
		return this.idkomentara;
	}

	public void setIdkomentara(int idkomentara) {
		this.idkomentara = idkomentara;
	}

	public int getIdforuma() {
		return this.idforuma;
	}

	public void setIdforuma(int idforuma) {
		this.idforuma = idforuma;
	}

	public String getObjava() {
		return this.objava;
	}

	public void setObjava(String objava) {
		this.objava = objava;
	}

}