package beans;

import java.util.List;

import data.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ManageStudents implements IManageStudents {

	@PersistenceContext(unitName = "playAula")
	EntityManager em;

	public void addStudent(String name) {
		System.out.println("Adding student " + name + "...");
		Student s = new Student(name);
		em.persist(s);
	}

	public List<Student> listStudents() {
		System.out.println("Retrieving students from the database...");
		TypedQuery<Student> q = em.createQuery("select s from Student s", Student.class);
		List<Student> list = q.getResultList();
		return list;
	}
}