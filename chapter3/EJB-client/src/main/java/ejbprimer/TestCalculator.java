package ejbprimer;


import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.ICalculator;


public class TestCalculator {

	public static void main(String[] args) throws NamingException {
		ICalculator cr = InitialContext.doLookup("EJB-server/Calculator!ejb.ICalculator");
		System.out.println(cr.add(5, 3));
	}

}
