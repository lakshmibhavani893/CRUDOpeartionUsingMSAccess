package com.db.dao;

import java.util.List;

import com.db.model.Employee;

public interface EmployeeDao {

	public boolean insertEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(int employeeId);

	public List<Employee> getAllEmployees();

}
