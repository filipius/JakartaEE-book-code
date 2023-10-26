package jpaprimer;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import jpaprimer.data.Player;

public class QueryData {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Players");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Player> q = em.createQuery("select p from Player p where p.height > :height", Player.class);
		q.setParameter("height", 1.85f);

		List<Player> players = q.getResultList();
		if (players.size() > 0)
			for (Player p : players)
				System.out.println(p);
		
		em.close();
		emf.close();
	}
}