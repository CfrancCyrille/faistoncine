package myapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CommentaireForm {

    private Long id;
    @NotEmpty
    private String auteur;
    @NotBlank
    private String titre;
    @NotEmpty
    private String sur;
    @NotEmpty
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
