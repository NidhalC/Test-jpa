package main.java;

import java.sql.SQLDataException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.QueryException;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_test");
		EntityManager em = entityManagerFactory.createEntityManager();
	try{
			Livre monLivre = em.getReference(Livre.class, 1);
			System.out.println( " Id trouvé = "+monLivre.getId() + " Titre du livre=  "+ monLivre.getTitre()+ " Auteur = " + monLivre.getAuteur());
		} catch (EntityNotFoundException e) {

			System.out.println("L'id demandé n'existe pas");
		}
		try{
		TypedQuery<Livre> query = em.createQuery("select monLivre2 from Livre monLivre2 where monLivre2.titre='Germinal'", Livre.class);
		String titreMonLivre2 = query.getSingleResult().getTitre();
		System.out.println(titreMonLivre2);
		} catch (QueryException e) {
			System.out.println("requete JPQL pas bonne");
		}
		
		TypedQuery<Emprunt> queryEmp =em.createQuery("select monEmprunt from Emprunt monEmprunt", Emprunt.class);
		List<Emprunt> maListe =  queryEmp.getResultList();
		for(Emprunt p : maListe){
			Set<Livre> listLivre =  p.getListLivre();
			for (Livre l :listLivre){
				
				System.out.println("Auteur= "+l.getAuteur()+" Titre= " +l.getTitre());
			}
		}
		
		TypedQuery<Client> queryCli = em.createQuery("select monClient from Client monClient where id =3", Client.class);
		Client client = queryCli.getSingleResult() ;
		Set<Emprunt> listEmprunt = (Set<Emprunt>) client.getMesEmprunts();
		for(Emprunt e : listEmprunt) {
			System.out.println("Date debut emprunt : "+e.getDate_debut()+" Date de fin d'emprunt : " + e.getDate_fin());
		}
		


	}

}
