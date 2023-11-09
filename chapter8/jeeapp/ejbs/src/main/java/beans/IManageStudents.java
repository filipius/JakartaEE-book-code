package beans;

import java.util.List;

import jakarta.ejb.Remote;

import data.Student;

@Remote
public interface IManageStudents {
	public void addStudent(String name);
	public List<Student> listStudents();
}