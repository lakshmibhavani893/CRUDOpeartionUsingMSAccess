package com.db.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.db.model.Employee;
import com.db.service.EmployeeService;
import com.db.service.EmployeeServiceImpl;

/**
 * 
 * @author Bhavani
 * This class perform the CRUD Operations
 */
public class Test {

	private static Logger logger = LoggerFactory.getLogger(Test.class);

	/**
	 * 
	 * @param args
	 * The execution starts from this method
	 */
	public static void main(String[] args) {

		EmployeeService empService = new EmployeeServiceImpl();

		Employee emp = new Employee(17, "valli", "project manager", "hema@gmail.com", "bengaluru");

		if (empService.insertEmployee(emp)) {
			logger.info("Employee details are inserted");
		} else {
			logger.error("employee details are not inserted");
		}

		Employee emp1 = new Employee(13, "kumari");

		if (empService.updateEmployee(emp1)) {
			logger.info("Employee details are updated");
		} else {
			logger.error("employee details are not updated");
		}

		if (empService.deleteEmployee(13)) {
			logger.info("Employees record is deleted");
		} else {
			logger.error("Employee record is not found for given id ");
		}

		System.out.println("Employee details are.....");
		
		if (empService.getAllEmployees() != null) {
			logger.info("End of Employees records");
		}

		
	}

}
