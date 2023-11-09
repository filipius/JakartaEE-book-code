package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import beans.IManageStudents;
import data.Student;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/webaccess")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IManageStudents manageStudents;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<String> field1List = manageStudents.listStudents().stream().
			map(Student::getName).collect(Collectors.toList());

		String result = "Students list: " + field1List;
		
		System.out.println(result);
		response.getWriter().print(result);
	}
}