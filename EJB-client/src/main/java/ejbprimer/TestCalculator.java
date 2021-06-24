package ejbprimer;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.CalculatorRemote;


public class TestCalculator {

	public static void main(String[] args) throws NamingException {
		CalculatorRemote cr = InitialContext.doLookup("EJB-server-1/Calculator!ejb.CalculatorRemote");
		System.out.println(cr.add(5, 3));
	}

}
