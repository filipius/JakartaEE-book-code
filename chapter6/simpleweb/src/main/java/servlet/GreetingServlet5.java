package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting5")
public class GreetingServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<String> myList = new ArrayList<String>();
		myList.add("One...");
		myList.add("Two...");
		myList.add("Three...");
		request.setAttribute("myListOfNumbers", myList);
		request.getRequestDispatcher("/display5.jsp").forward(request, response);
	}
}