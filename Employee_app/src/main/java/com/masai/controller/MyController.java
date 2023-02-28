package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.DepartmentException;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Department;
import com.masai.model.Employee;
import com.masai.service.DepartmentService;
import com.masai.service.EmployeeService;

@RestController
@RequestMapping("/employeeManageMent")
public class MyController {
	
	@Autowired
	private EmployeeService emps;
	
	@Autowired
	private DepartmentService depts;
	
	@PostMapping("/deptwithoutemployee")
	public ResponseEntity<Department> addDepartmentWithoutEmployees(@RequestBody Department dept) throws  DepartmentException{
		Department sdept= depts.addDepartmentWithoutEmployees(dept);
		
		return new ResponseEntity<Department>(sdept,HttpStatus.CREATED);
	}
	
	@PostMapping("/deptwithemployee")
	public ResponseEntity<Department> addDepartmentWithEmployees(@RequestBody Department dept) throws  DepartmentException{
		Department sdept= depts.addDepartmentWithEmployees(dept);
		
		return new ResponseEntity<Department>(sdept,HttpStatus.CREATED);
	}

	@PostMapping("/emp/{deptNo}")
	public ResponseEntity<Employee> addEmployeeWithExistingDept(@PathVariable("deptNo") int deptNo,@RequestBody Employee emp) throws EmployeeException, DepartmentException{
		Employee emp1=emps.addEmployeeWithExistingDept(deptNo, emp);
		
		return new ResponseEntity<Employee>(emp1,HttpStatus.CREATED);
	}
	
	@GetMapping("/emp/{deptNo}")
	public ResponseEntity<List<Employee>> getAllEmployeesFromDept(@PathVariable("deptNo") int deptNo) throws EmployeeException, DepartmentException{
		List<Employee> li= emps.getAllEmployeesFromDept(deptNo);
		
		return new ResponseEntity<List<Employee>>(li,HttpStatus.OK);
	}
}
