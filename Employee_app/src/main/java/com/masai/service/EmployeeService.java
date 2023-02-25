package com.masai.service;

import java.util.List;

import com.masai.exceptions.DepartmentException;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {

	public Employee addEmployeeWithExistingDept(int deptNo,Employee emp) throws EmployeeException,DepartmentException;
	
	public List<Employee> getAllEmployeesFromDept(int deptNo) throws EmployeeException,DepartmentException;
}
