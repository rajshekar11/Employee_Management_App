package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptNo;
	private String deptName;
	private Integer maxEmployee;
	private Employee headOfDept;
	@JsonIgnore
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
	private List<Employee> employees;
	
}
