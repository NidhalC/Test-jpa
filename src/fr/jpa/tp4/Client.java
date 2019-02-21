package fr.jpa.tp4;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Embedded
	private Adresse adresseClient;
	
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banqueClient;
	
	@ManyToMany
	@JoinTable(name="COMPO", joinColumns= @JoinColumn(name="id_client", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="numero_compte", referencedColumnName="numero_compte"))
	private Set<Compte> listCompte;
	
	public Adresse getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(Adresse adresseClient) {
		this.adresseClient = adresseClient;
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
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Banque getBanqueClient() {
		return banqueClient;
	}
	public void setBanqueClient(Banque banqueClient) {
		this.banqueClient = banqueClient;
	}
	public Set<Compte> getListCompte() {
		return listCompte;
	}
	public void setListCompte(Set<Compte> listCompte) {
		this.listCompte = listCompte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
