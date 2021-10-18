package ejbprimer;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.*;
import data.*;


public class TestCalculator {

	public static void main(String[] args) throws NamingException {
		IManageStudents cr = InitialContext.doLookup("ear/ejbs/ManageStudents!beans.IManageStudents");
		System.out.println(cr.listStudents());
	}

}
