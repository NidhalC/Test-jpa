package main.java;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@Column(name="id")
	private int id ;
	
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	
	@OneToMany(mappedBy="monClient")
	private Set<Emprunt> mesEmprunts;
	
	public Client(){
		
	}
	

	public Set<Emprunt> getMesEmprunts() {
		return mesEmprunts;
	}


	public void setMesEmprunts(Set<Emprunt> mesEmprunts) {
		this.mesEmprunts = mesEmprunts;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

}
