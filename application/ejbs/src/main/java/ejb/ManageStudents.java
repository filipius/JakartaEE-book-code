package ejb;

import javax.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ManageStudents {
    @PersistenceContext(name="playAula")
    EntityManager em;

    public void addStudent(String name) {
        Student s = new Student(name);
        em.persist(s);
    }

    public void addProfessor(Student s, Professor p) {
        s.addProfessor(p);
    }
}
