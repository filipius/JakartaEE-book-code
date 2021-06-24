package ejb;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Session Bean implementation class Calculator
 */
@Stateless
public class Calculator implements CalculatorRemote {
	Logger logger = LoggerFactory.getLogger(Calculator.class);
	/**
	 * Default constructor. 
	 */
	public Calculator() {
		logger.info("Created Calculator");
		logger.debug("Debug!! Created Calculator");
	}

	@Override
	public int add(int a, int b) {
		logger.info("adding " + a + " + " + b);
		logger.debug("Debug!! Adding " + a + " + " + b);
		return a + b;
	}

}
