package book;

import artifact.CalculatorWS;
import artifact.CalculatorWSService;

public class App 
{
    public static void main( String[] args )
    {    	
    	int result;
    	CalculatorWSService service = new CalculatorWSService();
        CalculatorWS calc = service.getCalculatorWSPort();
        result = calc.add(2, 3);
        System.out.println("Adding... result = " + result);
    }
}
