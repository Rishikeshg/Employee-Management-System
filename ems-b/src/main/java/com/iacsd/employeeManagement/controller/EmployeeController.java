package com.iacsd.employeeManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.employeeManagement.exception.ResourceNotFoundException;
import com.iacsd.employeeManagement.model.Employee;
import com.iacsd.employeeManagement.service.CommonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private CommonService commonService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return commonService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee= commonService.getEmployeeById(employeeId);
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public long createEmployee(@Valid @RequestBody Employee employee) {
		return commonService.saveEmployee(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Long> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employee) throws ResourceNotFoundException {
		long numOfRowsUpdated = commonService.updateEmployee(employee, employeeId);
		return ResponseEntity.ok(numOfRowsUpdated);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		long numOfRowsUpdated = commonService.deleteEmployee(employeeId);
		return ResponseEntity.ok(numOfRowsUpdated);
	}
}
