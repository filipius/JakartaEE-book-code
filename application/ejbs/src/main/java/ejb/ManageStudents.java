package ejb;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import data.Student;
import data.Professor;

@Stateless
public class ManageStudents {
    @PersistenceContext(name="playAula")
    EntityManager em;

    public void addStudent(String name) {
        Student s = new Student(name);
        em.persist(s);
    }

    public void addProfessor(Student s, Professor p) {
        s.setProf(p);
    }

    public List<Student> getStudents() {
        Query q = em.createQuery("from Student s");
        List<Student> list = q.getResultList();
        return list;
    }
}
