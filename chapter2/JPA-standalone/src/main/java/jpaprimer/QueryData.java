package jpaprimer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpaprimer.data.*;

public class QueryData {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Players");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Player p where p.height > :height");
		q.setParameter("height", 1.85f);
		@SuppressWarnings("unchecked")
		List<Player> players = q.getResultList();
		if (players.size() > 0)
			for (Player p : players)
				System.out.println(p);
	}
}