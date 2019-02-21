package main.java;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="titre")
	private String titre;
	@Column(name="auteur")
	private String auteur;
	
	@ManyToMany
	@JoinTable(name="COMPO", joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
	Set<Emprunt> listEmprunt;
	
	
	
	public Set<Emprunt> getListEmprunt() {
		return listEmprunt;
	}


	public void setListEmprunt(Set<Emprunt> listEmprunt) {
		this.listEmprunt = listEmprunt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public Livre() {	
	}
	

}
