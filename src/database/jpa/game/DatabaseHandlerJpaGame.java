package database.jpa.game;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseHandlerJpaGame {
	
	// Create an EntityManagerFactory when you start the application.
		private static EntityManager entityManager;
		
		public static synchronized EntityManager getEntityManagerFactory()
		{
			if (entityManager == null || ! entityManager.isOpen())
			{
				entityManager = Persistence.createEntityManagerFactory("jpa-game").createEntityManager();
			}
			
			return entityManager;
		}
}
