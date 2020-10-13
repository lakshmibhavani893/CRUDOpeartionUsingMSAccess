package com.db.service;

import java.util.List;

import com.db.dao.EmployeeDao;
import com.db.dao.EmployeeDaoImpl;
import com.db.model.Employee;

/**
 * 
 * @author Bhavani
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();

	/**
	 * @param employee
	 * @return boolean
	 */
	public boolean insertEmployee(Employee employee) {
		return dao.insertEmployee(employee);
	}

	/**
	 * @param employee
	 * @return boolean
	 */
	public boolean updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

	/**
	 * @param employeeId
	 * @return boolean
	 */
	public boolean deleteEmployee(int employeeId) {
		return dao.deleteEmployee(employeeId);
	}

	/**
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
