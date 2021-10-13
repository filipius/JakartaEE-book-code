package jpaprimer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpaprimer.data.Player;
import jpaprimer.data.Team;

public class FavoriteTeam {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Players");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Team t where t.name = :t");
		q.setParameter("t", "Academica");
		@SuppressWarnings("unchecked")
		List<Team> resultteams = q.getResultList();
		if (resultteams.size() > 0)
			for (Player p : resultteams.get(0).getPlayers()) {
				System.out.println(p.getName());
			}
	}

}