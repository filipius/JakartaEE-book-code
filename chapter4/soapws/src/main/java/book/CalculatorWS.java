package book;

import javax.jws.WebService;

@WebService
public class CalculatorWS {

	public int add(int a, int b) {
		System.out.println("Calculating (" + a + " plus " + b + ") at the server...");
		return a + b;
	}

	public int subtract(int a, int b) {
		System.out.println("Calculating (" + a + " minus " + b + ")at the server...");
		return a - b;
	}
}