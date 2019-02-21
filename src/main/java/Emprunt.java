package main.java;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="date_debut")
		private LocalDate date_debut;
	
	@Column(name="date_fin")
	private LocalDate date_fin;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	Client monClient;
	
	@ManyToMany(mappedBy = "listEmprunt")
	Set<Livre> listLivre ;
	
	public Emprunt() {
		
	}
	

	public Client getMonClient() {
		return monClient;
	}


	public void setMonClient(Client monClient) {
		this.monClient = monClient;
	}


	public Set<Livre> getListLivre() {
		return listLivre;
	}


	public void setListLivre(Set<Livre> listLivre) {
		this.listLivre = listLivre;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	

}
