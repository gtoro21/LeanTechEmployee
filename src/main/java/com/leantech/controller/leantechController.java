package com.leantech.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.leantech.model.Employee;
import com.leantech.model.EmployeeInpout;
import com.leantech.dao.leantechDao;
import com.leantech.model.positionListOutput;
import com.leantech.repository.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class leantechController {
		
	@Autowired
	positionRepository positionRepository;	
	
	@Autowired
	employeeRepository employeeRepository;
	
	@Autowired
	personRepository personRepository;
	
	
	@ApiOperation(value = "create employees")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 204, message = "Not Content", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class) })
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeInpout EmployeeInpout) {		
		return leantechDao.createEmployee(EmployeeInpout,positionRepository,employeeRepository,personRepository);
	}
	
	
	@ApiOperation(value = "Update employees")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success" , response = ResponseEntity.class),
			@ApiResponse(code = 204, message = "Not Content", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class)})		
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeInpout EmployeeInpout) {
		
		return leantechDao.updateEmployee(id,EmployeeInpout,employeeRepository,personRepository,positionRepository);
	}
	
	
	@ApiOperation(value = "Request employees by name or position ")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 204, message = "Not Content", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class) })	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee(
			@RequestHeader (value = "position" ,required = false) String position ,
			@RequestHeader (value = "name" ,required = false) String name) {
		return leantechDao.getEmployee(position,name,positionRepository,employeeRepository,personRepository);
	}
	

	@ApiOperation(value = "Delete employee")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 204, message = "Not Content", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class) })	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("id") long id){
			
		return leantechDao.deleteEmployee(id,employeeRepository,personRepository);
	}
	
	
	@ApiOperation(value = "Request all position´s")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 204, message = "Not Content", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class) })
	@GetMapping("/position")
	public ResponseEntity<List<positionListOutput>> getPosition() {
		
		return leantechDao.getPosition(positionRepository,employeeRepository,personRepository);
	}

}
