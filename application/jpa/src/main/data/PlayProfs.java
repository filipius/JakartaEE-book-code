package play.jpa;

/*
import java.util.ArrayList;
import java.util.List;
*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PlayProfs {

	public static void main(String[] args) {
		Professor1 profs[] = {new Professor1("Jorge Jesus"), new Professor1("Rui Vitoria"), new Professor1("Sergio Conceicao")};
		Student1 sts[] = {new Student1("Coates", profs[0]), new Student1("Mathieu", profs[0]), new Student1("Julio Cesar", profs[1]), new Student1("Andre Andre", profs[2])};

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("playAula");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		for (Professor1 p : profs)
			em.persist(p);
		for (Student1 s : sts)
			em.persist(s);

		et.commit();
		emf.close();
	}

}
