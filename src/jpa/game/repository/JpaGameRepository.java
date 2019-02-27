
/*
a. Afficher les informations du joueur de nom « DOE » ;
b. Afficher la liste des pseudonymes des joueurs, triés par ordre alphabétique ;
c. Afficher les noms des joueurs qui jouent aujourd’hui ;
d. Pour un joueur, afficher les informations de ses engins utilisés ;
e. Pour un joueur et pour sa dernière partie, afficher son score et le niveau du jeu
atteint ;
f. Pour ce même joueur, modifier le type d’engin utilisé (bolide vers aéronef ou vis-
versa) et afficher les modifications ;
Utilisez autant que possible les requêtes JPQL paramétrées avec des résultats typés
« TypedQuery ».
 */

package jpa.game.repository;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import database.jpa.game.DatabaseHandlerJpaGame;
import jpa.game.model.Joueur;

public class JpaGameRepository {

	static EntityManager em = DatabaseHandlerJpaGame.getEntityManagerFactory();
	static EntityTransaction transaction = em.getTransaction();

	// afficher les infos du joueur James
	public static Joueur getJoueurByName(String name) {
		TypedQuery<Joueur> q = em.createQuery("SELECT j FROM Joueur j WHERE j.nom= :name", Joueur.class);
		q.setParameter("name", name);
		return q.getSingleResult();
	}

	// afficher la liste des joueurs, triés par ordre alphabétique
	public static List<Joueur> getListJoueursSorted() {
		TypedQuery<Joueur> q = em.createQuery("SELECT j FROM Joueur j ORDER BY j.nom", Joueur.class);
		return q.getResultList();

//		List<Joueur> j = q.getResultList();
//		j.stream().sorted().collect(Collectors.toList()).forEach(e->System.out.println(e.getNom()));

	}

	// afficher les noms des joueurs qui jouent aujourd’hui
	public static List<Joueur> getJoueursDuJour(LocalDate date) {
		TypedQuery<Joueur> q = em.createQuery(
				"SELECT j FROM Joueur j JOIN j.parties p JOIN p.joueurs WHERE p.date= :date", Joueur.class);
		q.setParameter("date", date);
		return q.getResultList();
	}

	/*
	 * Pour un joueur, afficher les informations de ses engins utilisés ;
	 */
	public static Joueur getEngin(String nom) {
		TypedQuery<Joueur> q = em.createQuery(
				"SELECT j FROM Joueur j JOIN j.avatar a JOIN a.engins WHERE j.nom= :name", Joueur.class);
		q.setParameter("name", nom);
		return q.getSingleResult();
	}
}
