package com.iacsd.employeeManagement.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iacsd.employeeManagement.dao.commonDao;
import com.iacsd.employeeManagement.model.Employee;
import com.iacsd.employeeManagement.model.Login;
import com.iacsd.employeeManagement.model.User;
import com.iacsd.employeeManagement.service.CommonService;

@Service
@Transactional
class commonServiceImpl implements CommonService {
	private static final Logger LOGGER = Logger.getLogger(commonServiceImpl.class);

	@Autowired
	private commonDao commonDao;

	@Override
	public long saveUser(@Valid User user) {
		return commonDao.saveUSer(user);
	}

	@Override
	public User userLogin(@Valid Login login) {
		User user = commonDao.getUserByEmailId(login);
		LOGGER.info(user);
		System.out.println(user);
		if (user!=null || login.getPassword().equalsIgnoreCase(user.getPassword())) {
			System.out.println("LOGIN SUCCESSFULL");
			return user;
		}
		System.out.println("LOGIN FAILED");
		return null;
	}

	@Override
	public long saveEmployee(@Valid Employee employee) {
		return commonDao.saveEmployee(employee);
	}

	@Override
	public int updateEmployee(@Valid Employee employee, Long employeeId) {
		return commonDao.updateEmployee(employee, employeeId);
	}

	@Override
	public int deleteEmployee(Long employeeId) {
		return commonDao.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = commonDao.getAllEmployees();
		System.out.println(allEmployees);
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return commonDao.getEmployeeById(employeeId);
	}
}
