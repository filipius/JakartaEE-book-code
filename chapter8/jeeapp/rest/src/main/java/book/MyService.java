package book;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import beans.IManageStudents;
import data.Student;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/myservice")
@Produces(MediaType.APPLICATION_JSON)
public class MyService {

	@EJB
	private IManageStudents manageStudents;
	
	@GET
	@Path("/test")
	public String method1() {
		System.out.println("M1 executing....");
	    
		return "M1 executed...";
	}
	
	@GET
	@Path("/add")
	public String method2() {
		System.out.println("M2 executing....");
		String name = "name_" + new Time(Calendar.getInstance().getTimeInMillis());
		manageStudents.addStudent(name);
	    
		return name;
	}
	
	@GET
	@Path("/list")
	public List<Student> method3() {
		System.out.println("M3 executing....");		
		List<Student> list = manageStudents.listStudents();

		return list;
	}
}
