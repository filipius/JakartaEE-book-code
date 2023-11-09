package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@WebFilter("/secured2/*")
public class SecurityFilter2 implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    
		System.out.println("Accessing the filter...");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String auth = null;
		
	
		if (session != null && session.getAttribute("auth") != null)
		{
			auth = (String) session.getAttribute("auth");
		}
		System.out.println("Resultado = " + auth);

		
		if (auth == null || httpReq.getRequestURI().endsWith(".jsp"))
		{
			request.getRequestDispatcher("/error.html").forward(request, response);
		}
		else if (auth != null)
		{
			System.out.println("MOOOOOOVING");
			chain.doFilter(request, response);
		}
	}
}
