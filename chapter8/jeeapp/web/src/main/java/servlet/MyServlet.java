package servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.IManageStudents;
import data.Student;

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