package com.iacsd.employeeManagement.schema;

import javax.validation.Valid;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.iacsd.employeeManagement.model.Employee;
import com.iacsd.employeeManagement.model.User;

public class CommonSchema {

	private CommonSchema() {
		// To prevent instantiation
	}

	public static final String GET_USER_BY_EMAIL_ID = "SELECT id,address, user_name, password, email_id,mobile_number FROM User WHERE email_id=:emailId";

	public static final String SAVE_USER = "INSERT INTO User(address, user_name, password, email_id,mobile_number) VALUES (:address, :userName, :password,:emailId, :mobileNumber)";

	public static final String SELECT_ALL_EMPLOYEES = "SELECT id, email_id, first_name, last_name FROM Employee";

	public static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, email_id, first_name, last_name FROM Employee WHERE id=:id";

	public static final String SAVE_EMPLOYEE = "INSERT INTO Employee(email_id, first_name, last_name) VALUES (:emailId, :firstName, :lastName)";

	public static final String UPDATE_EMPLOYEE = "UPDATE Employee SET email_id=:emailId, first_name=:firstName,last_name=:lastName WHERE id=:id";

	public static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE id=:id ";

	public static SqlParameterSource saveUSer(User user) {
		return new MapSqlParameterSource().addValue("address", user.getAddress())
				.addValue("userName", user.getUserName()).addValue("password", user.getPassword())
				.addValue("emailId", user.getEmailId()).addValue("mobileNumber", user.getMobileNumber());
	}
	
	public static SqlParameterSource updateEmployee(@Valid Employee employee, Long employeeId) {
		return new MapSqlParameterSource().addValue("firstName", employee.getFirstName())
				.addValue("lastName", employee.getLastName()).addValue("emailId", employee.getEmailId()).addValue("id", employeeId);
	}

	public static SqlParameterSource getSqlParametersForSelectAndDelete(Long bankId) {
		return new MapSqlParameterSource().addValue("bankId", bankId);
	}

	public static SqlParameterSource getUserByEmailId(String emailId) {
		return new MapSqlParameterSource().addValue("emailId", emailId);
	}

	public static SqlParameterSource saveEmployee(@Valid Employee employee) {
		return new MapSqlParameterSource().addValue("firstName", employee.getFirstName())
				.addValue("lastName", employee.getLastName()).addValue("emailId", employee.getEmailId());
	}

	public static SqlParameterSource deleteEmployee(Long employeeId) {
		return new MapSqlParameterSource().addValue("id", employeeId);
	}

	public static SqlParameterSource getEmployeeById(Long employeeId) {
		return new MapSqlParameterSource().addValue("id", employeeId);
	}

	

}
