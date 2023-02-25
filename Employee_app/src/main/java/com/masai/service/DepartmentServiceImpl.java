package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.DepartmentException;
import com.masai.model.Department;
import com.masai.repository.DepartmentRepository;
import com.masai.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private EmployeeRepository emprep;
	
	@Autowired
	private DepartmentRepository deptrep;

	@Override
	public Department addDepartmentWithEmployees(Department dept) throws DepartmentException {
		return deptrep.save(dept);
	}

	@Override
	public Department addDepartmentWithoutEmployees(Department dept) throws DepartmentException {
		// TODO Auto-generated method stub
		return deptrep.save(dept);
	}

}
