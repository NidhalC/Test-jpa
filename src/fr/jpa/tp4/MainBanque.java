package fr.jpa.tp4;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class MainBanque {
	
	public static void testCreationClient(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Client c = new Client ();
		Adresse a =new Adresse(2,"rue de la banque",98000, "LeMans");
		Banque b = new Banque("Cic");
		em.persist(b);
		
		c.setNom("Blanc");
		c.setPrenom("Michel");
		c.setAdresseClient(a);
		c.setBanqueClient(b);
		
		LivretA livret = new LivretA();
		livret.setTaux(0.2);
		livret.setSolde(1500);
		livret.setNumero("00001");
		em.persist(livret);
		Set<Compte> compteClient = new HashSet<Compte>();
		compteClient.add(livret);
		c.setListCompte(compteClient);
		em.persist(c);
		transaction.commit();
		
		//Client c2 = (Client) em.find(Client.class, 1);
		
		
	}
	

	public static void main(String[] args) {
		testCreationClient();
	}

}
