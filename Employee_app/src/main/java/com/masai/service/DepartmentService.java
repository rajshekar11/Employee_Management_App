package com.masai.service;

import com.masai.exceptions.DepartmentException;
import com.masai.model.Department;

public interface DepartmentService {

	public Department addDepartmentWithEmployees(Department dept) throws DepartmentException;
	
	public Department addDepartmentWithoutEmployees(Department dept) throws DepartmentException;
	
}
