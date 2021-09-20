package ejb;

//import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.jboss.ejb3.annotation.SecurityDomain;
//import javax.annotation.security.RolesAllowed;


/**
* Session Bean implementation class Calculator
*/
@Stateless
//@Remote(CalculatorRemote.class)
//@RolesAllowed({ "guest" })
//@SecurityDomain("other")
public class Calculator implements ICalculator {
	Logger logger = LoggerFactory.getLogger(Calculator.class);

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
