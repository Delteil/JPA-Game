package main.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import database.jpa.game.DatabaseHandlerJpaGame;
import jpa.game.model.Bolide;
import jpa.game.model.Joueur;
import jpa.game.model.Partie;
import jpa.game.repository.JpaGameRepository;

public class MainJpaGame {

	public static void main(String[] args) {

		EntityManager em = DatabaseHandlerJpaGame.getEntityManagerFactory();

		EntityTransaction transaction = em.getTransaction();

		// Begin the transaction
		transaction.begin();

		// the record is read and the object is now managed by Hibernate in memory
		Joueur j = em.find(Joueur.class, 1);
		System.out.println(j.toString());

		// the persistent object is modified
		j.setPrenom("Didine");

//		// the new objet is transient
//		Joueur j2 = new Joueur();
////		j2.setId(4);
//		j2.setNom("BOND");
//		j2.setPrenom("James");
//
//		// this object become a persistent object
//		em.persist(j2);

		j = em.find(Joueur.class, 1);
		System.out.println(j.toString());

		// all the objects will be detached
		transaction.commit();

		// nom du 1er enregistrement
		System.out.println(em.find(Joueur.class, 1).toString());

		// nombre de joueur de la table joueur
		TypedQuery<Joueur> query = em.createQuery("select j from Joueur j", Joueur.class);
		System.out.println(query.getResultList().size());

		// infos des 10 premières lignes
		query.getResultList().stream().forEach(System.out::println);

		transaction.begin();

		// the new objet "partie" is transient
		Partie p = new Partie();
		p.setNiveau(1);
		p.setScore(2);
		p.setDate(LocalDate.now());
		em.persist(p);

		Partie p1 = new Partie();
		p1.setNiveau(3);
		p1.setScore(5);
		p1.setDate(LocalDate.now());
		em.persist(p1);

		Partie p2 = new Partie();
		p2.setNiveau(7);
		p2.setScore(10);
		p2.setDate(LocalDate.now());
		em.persist(p2);

		// all the objects will be detached
		transaction.commit();

		TypedQuery<Partie> q2 = em.createQuery("from Partie", Partie.class);

		transaction.begin();
		try {

			// methode 1
//			for (Partie partie : q2.getResultList()) {
//				partie.setNiveau(partie.getNiveau() + 1);

			// methode 2
			q2.getResultList().stream().forEach(e -> e.setNiveau(e.getNiveau() + 1));

		} catch (Exception e) {

			System.out.println("ne fonctionne pas");
		}

		// all the objects will be detached
		transaction.commit();

		// afficher les infos du joueur James
		Joueur j1 = JpaGameRepository.getJoueurByName("tasselli");
		System.out.println("le joueur" + j1);

		// afficher la liste des nom par ordre alphabetique
		System.out.println("tri dans l'ordre : " + JpaGameRepository.getListJoueursSorted());

		// afficher les noms des joueurs qui jouent aujourd’hui
		System.out.println("Partie jouée en date du "+ JpaGameRepository.getJoueursDuJour(LocalDate.of(2019, 02, 17)));

		// Pour un joueur, afficher les informations de l’engin
		System.out.println("Engin du joueur " + JpaGameRepository.getEngin("mercadier"));

		/*
		 * Pour ce même joueur, modifier le type d’engin utilisé (bolide vers aéronef ou
		 * vis- versa) et afficher les modifications
		 */
//
//		transaction.begin();
//
//		Joueur j3 = em.find(Joueur.class, 4);
//		System.out.println(j3.toString());
//		j3.getAvatar().removeEngin(1);
//		
//		
//		Bolide bolide = new Bolide();
//		bolide.set.getAvatar();
//		
//
//		Joueur j3 =

		em.close();
		System.exit(0);

	}

}
