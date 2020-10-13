package com.db.service;

import java.util.List;

import com.db.model.Employee;

public interface EmployeeService {

	public boolean insertEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(int employeeId);

	public List<Employee> getAllEmployees();

}
