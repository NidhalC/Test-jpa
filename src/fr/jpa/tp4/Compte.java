package fr.jpa.tp4;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="numero_compte")
	private int numero_compte;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="solde")
	private double solde;
	
	@ManyToMany(mappedBy="listCompte")
	private Set<Client> listClient;
	
	@OneToMany(mappedBy="monCompte")
	private Set<Operation> listOp;

	public int getNumero_compte() {
		return numero_compte;
	}

	public void setNumero_compte(int numero_compte) {
		this.numero_compte = numero_compte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getListClient() {
		return listClient;
	}

	public void setListClient(Set<Client> listClient) {
		this.listClient = listClient;
	}

	public Set<Operation> getListOp() {
		return listOp;
	}

	public void setListOp(Set<Operation> listOp) {
		this.listOp = listOp;
	}
	
	
	

}
