package ejb;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import data.Student;
import data.Professor;



@Stateless
@LocalBean
public class ManageProfessors {
    @PersistenceContext(name="playAula")
    EntityManager em;

    public ManageProfessors() {
        System.out.println("Test-------------------------------------------------");
    }

    public void addProfessor(String name) {
        Professor p = new Professor(name);
        em.persist(name);
    }

    public boolean isProfessor(Student s, Professor p) {
        return s.getProf() == p;
    }

    public List<Professor> getProfessors() {
        Query q = em.createQuery("from Professor p");
        List<Professor> list = q.getResultList();
        return list;
    }

    public List<Student> getStudents(Professor p) {
        return p.getStudents();
    }

}