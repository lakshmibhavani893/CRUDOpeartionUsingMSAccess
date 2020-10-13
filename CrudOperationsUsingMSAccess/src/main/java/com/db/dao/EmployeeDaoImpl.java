package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con = ConnectionFactory.getConnection();

	/**
	 * @param employee
	 * @return boolean
	 */
	public boolean insertEmployee(Employee employee) {

		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO Employee(id,name,role,email,address) VALUES ( ?, ?,?,?,?)");
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getRole());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getAddress());

			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * @param employee
	 * @return boolean
	 */
	public boolean updateEmployee(Employee employee) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Employee SET name=? WHERE id=?");
			ps.setString(1, employee.getName());
			ps.setInt(2, employee.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * @param employeeId
	 * @return boolean
	 */
	public boolean deleteEmployee(int employeeId) {

		try {
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("DELETE FROM Employee WHERE id=" + employeeId);
			if (i >= 1) {
				return true;
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployees() {

		String query = "SELECT * FROM Employee";

		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			while (rs.next()) {
				System.out.println(" empName :" + rs.getString(1) + " role :" + rs.getString(2) + " email: "
						+ rs.getString(3) + " address:" + rs.getString(4));

			}
			stmt.close();
			return employees;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
