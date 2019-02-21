package fr.jpa.tp4;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="banqueClient")
	private Set<Client> mesClients;
	
	public Banque(){
		
	}
	public Banque(String nom){
		this.nom = nom;
		
	}

}
