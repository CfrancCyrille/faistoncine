package myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String auteur;
    private String titre;
    private String sur;
    private String comment;
    
    //#region Getter & Setter...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSur() {
		return sur;
	}
	public void setSur(String sur) {
		this.sur = sur;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
