package com.iacsd.employeeManagement.dao.impl;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iacsd.employeeManagement.dao.commonDao;
import com.iacsd.employeeManagement.model.Employee;
import com.iacsd.employeeManagement.model.Login;
import com.iacsd.employeeManagement.model.User;
import com.iacsd.employeeManagement.schema.CommonSchema;

@Component
@Transactional
class CommonDaoImpl implements commonDao {
	private static final Logger LOGGER = Logger.getLogger(CommonDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public long saveUSer(@Valid User user) {
		try {
			LOGGER.info(getClass() + ":: saveUSer METHOD INVOKED");
			KeyHolder holder = new GeneratedKeyHolder();
			template.update(CommonSchema.SAVE_USER, CommonSchema.saveUSer(user), holder);
			System.out.println(holder.getKeys().get("id"));
			return 1;
		} catch (BadSqlGrammarException ex){
		     return 0;
			//throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			throw new RuntimeException("DataAccessException :: ", e);
		}
	}

	@Override
	public User getUserByEmailId(@Valid Login login) {
		try {
			LOGGER.info(getClass() + ":: getUserByEmailId METHOD INVOKED");
			return template.queryForObject(CommonSchema.GET_USER_BY_EMAIL_ID,
					CommonSchema.getUserByEmailId(login.getEmailId()), BeanPropertyRowMapper.newInstance(User.class));
		} catch (BadSqlGrammarException ex) {
			LOGGER.info("BadSqlGrammarException :: "+ex.getLocalizedMessage());
			throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			LOGGER.info("DuplicateKeyException :: "+e.getLocalizedMessage());
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			LOGGER.info("DataAccessException :: "+e.getLocalizedMessage());
			//throw new RuntimeException("DataAccessException :: ", e);
			return null;
		}
	}

	@Override
	public long saveEmployee(@Valid Employee employee) {
		try {
			LOGGER.info(getClass() + ":: saveEmployee METHOD INVOKED");
			KeyHolder holder = new GeneratedKeyHolder();
			template.update(CommonSchema.SAVE_EMPLOYEE, CommonSchema.saveEmployee(employee), holder);
		//	long id = Long.parseLong(String.valueOf(holder.getKeys().get("id")));
		//	LOGGER.info(getClass() + ":: saveEmployee METHOD RESPONSE WITH  ID::" + id);
			return 1;
		} catch (BadSqlGrammarException ex) {
			throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			return 0;//throw new RuntimeException("DataAccessException :: ", e);
		}
	}

	@Override
	public int updateEmployee(@Valid Employee employee, Long employeeId) {
		try {
			int numOfRowsAffected = template.update(CommonSchema.UPDATE_EMPLOYEE,
					CommonSchema.updateEmployee(employee, employeeId));
			LOGGER.info(getClass() + "POST RESPONSE :: WITH NUM OF ROWS AFFECTED:: " + numOfRowsAffected);
			return numOfRowsAffected;
		} catch (BadSqlGrammarException ex) {
			throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			throw new RuntimeException("DataAccessException :: ", e);
		}
	}

	@Override
	public int deleteEmployee(Long employeeId) {
		try {
			LOGGER.info(getClass() + ":: deleteEmployee METHOD INVOKED");
			int numOfRowsAffected = template.update(CommonSchema.DELETE_EMPLOYEE,
					CommonSchema.deleteEmployee(employeeId));
			LOGGER.info(getClass() + "POST RESPONSE :: WITH NUM OF ROWS AFFECTED:: " + numOfRowsAffected);
			return numOfRowsAffected;
		} catch (BadSqlGrammarException ex) {
			throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			throw new RuntimeException("DataAccessException :: ", e);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			LOGGER.info(getClass() + ":: getAllEmployees METHOD INVOKED");
			return template.query(
					CommonSchema.SELECT_ALL_EMPLOYEES,
					BeanPropertyRowMapper.newInstance(Employee.class));
		} catch (BadSqlGrammarException ex) {
			throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			return null;
			//throw new RuntimeException("DataAccessException :: ", e);
		}
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		try {
			LOGGER.info(getClass() + ":: getEmployeeById METHOD INVOKED");
			return template.queryForObject(CommonSchema.SELECT_EMPLOYEE_BY_ID,
					CommonSchema.getEmployeeById(employeeId), BeanPropertyRowMapper.newInstance(Employee.class));
		} catch (BadSqlGrammarException ex) {
			throw new RuntimeException("BadSqlGrammarException :: ", ex);
		} catch (DuplicateKeyException e) {
			throw new RuntimeException("DuplicateKeyException :: ", e);
		} catch (DataAccessException e) {
			throw new RuntimeException("DataAccessException :: ", e);
		}
	}
}