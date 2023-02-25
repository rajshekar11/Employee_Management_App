package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	
}
