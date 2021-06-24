package ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import data.Player;
import data.Team;


public class ManageProfessor {
    @PersistenceContext(name="playAula")
    EntityManager em;

    public void addProfessor(String name) {
        Professor p = new Professor(name);
        em.persist(name);
    }

    public boolean isProfessor(Student s, Professor p) {
        return s.getProf() == p;
    }
}