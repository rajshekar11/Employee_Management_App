package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyError> employeeExceptionHandler(EmployeeException emp,WebRequest wr){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(emp.getMessage());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<MyError> departmnetExceptionHandler(DepartmentException emp,WebRequest wr){
		MyError me=new MyError();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(emp.getMessage());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
}
