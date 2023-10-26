package jpaprimer;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import jpaprimer.data.Player;
import jpaprimer.data.Team;

public class FavoriteTeam {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Players");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Team> q = em.createQuery("select t from Team t where t.name = :t", Team.class);
		q.setParameter("t", "Academica");

		List<Team> resultteams = q.getResultList();
		if (resultteams.size() > 0)
			for (Player p : resultteams.get(0).getPlayers()) {
				System.out.println(p.getName());
			}
		
		em.close();
		emf.close();
	}

}