package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.DepartmentException;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Department;
import com.masai.model.Employee;
import com.masai.repository.DepartmentRepository;
import com.masai.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository emprep;
	
	@Autowired
	private DepartmentRepository deptrep;

	@Override
	public Employee addEmployeeWithExistingDept(int deptNo, Employee emp) throws EmployeeException, DepartmentException {
		// TODO Auto-generated method stub
		Optional<Department> opt= deptrep.findById(deptNo);
		if(opt.isPresent()) {
			Department dept=opt.get();
			List<Employee> li= dept.getEmployees();
			li.add(emp);
			emp.setDept(dept);
			return emprep.save(emp);
		}
		throw new DepartmentException("Department doesnt exists");
	}

	@Override
	public List<Employee> getAllEmployeesFromDept(int deptNo) throws EmployeeException, DepartmentException {
		// TODO Auto-generated method stub
			Optional<Department> opt1=deptrep.findById(deptNo);
			if(opt1.isPresent()) {
				Department dept=opt1.get();
				return dept.getEmployees();
			}
			throw new DepartmentException("Department doest exists");
	}

	
}
