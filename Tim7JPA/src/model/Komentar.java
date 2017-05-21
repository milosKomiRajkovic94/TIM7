package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KOMENTAR database table.
 * 
 */
@Entity
@Table(name="KOMENTAR")
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Komentar(String objava, Forum f){
		this.objava = objava;
		this.forum = f;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkomentara;

	private String objava;

	//bi-directional many-to-one association to Forum
	@ManyToOne
	@JoinColumn(name="IDFORUMA")
	private Forum forum;

	public Komentar() {
	}

	public int getIdkomentara() {
		return this.idkomentara;
	}

	public void setIdkomentara(int idkomentara) {
		this.idkomentara = idkomentara;
	}

	public String getObjava() {
		return this.objava;
	}

	public void setObjava(String objava) {
		this.objava = objava;
	}

	public Forum getForum() {
		return this.forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

}