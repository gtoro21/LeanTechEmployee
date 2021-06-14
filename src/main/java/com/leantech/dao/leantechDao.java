package com.leantech.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.leantech.model.Employee;
import com.leantech.model.EmployeeInpout;
import com.leantech.model.EmployeeLess;
import com.leantech.model.Person;
import com.leantech.model.Position;
import com.leantech.model.personOutput;
import com.leantech.model.positionListOutput;
import com.leantech.repository.employeeRepository;
import com.leantech.repository.personRepository;
import com.leantech.repository.positionRepository;


public class leantechDao implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8023415186234324503L;

//	public static ResponseEntity<Position> createPosition(String Position, com.leantech.repository.positionRepository positionRepository2){
//		try {			
//			// consultamos si la posicion 			
//			Position _Position = positionRepository2.save(new Position(Position));
//			return new ResponseEntity<>(_Position, HttpStatus.CREATED);
//		} catch (Exception e) {
////			e.printStackTrace();
//			System.out.println(e.getCause());
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	public static ResponseEntity<Position> searchPosition(long id,positionRepository positionRepository) {
//		Optional<Position> PositionData = positionRepository.findById(id);	
//		if (PositionData.isPresent()) {
//			
//			return new ResponseEntity<>(PositionData.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//	}
//
//	public static ResponseEntity<Position> updatePosition(long id,String position ,positionRepository positionRepository) {
//		Optional<Position> positionlData = positionRepository.findById(id);
//		if (positionlData.isPresent()) {
//			Position _position = positionlData.get();
//			_position.setName(position);
//			return new ResponseEntity<>(positionRepository.save(_position), HttpStatus.OK);
//		} else {						
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	public static ResponseEntity<HttpStatus> deletePosition(long id,positionRepository positionRepository,employeeRepository employeeRepository) {
//		try {						
//			List<Employee> employeeData = employeeRepository.findByIdPosition(id);
//			if (employeeData.size()>0) {					
//				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//			}
//			else {
//				positionRepository.deleteById(id);
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}			
//	} catch (Exception e) {			
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	}

	public static ResponseEntity<Employee> createEmployee(EmployeeInpout employeeInpout,positionRepository positionRepository,employeeRepository employeeRepository,personRepository personRepository) {
		
		System.out.println(employeeInpout);
			Position PositionData = new Position();
			Person PersonData = new Person();
			Employee employeeData =new Employee();

				PositionData = (Position) positionRepository.findByName(employeeInpout.getPosition());						
				System.out.println(PositionData);
			if (PositionData==null) {
				PositionData = new Position();
				PositionData = positionRepository.save(new Position(employeeInpout.getPosition().toString()));
			}
			

				PersonData = personRepository.findAllByAllData(employeeInpout.getName(),employeeInpout.getAddress(),employeeInpout.getCellPhone(),employeeInpout.getCityName(),employeeInpout.getLastName());
				System.out.println(PersonData);
			
			if (PersonData==null) {
				
				PersonData=personRepository.save(new Person(employeeInpout.getName(),employeeInpout.getLastName(),employeeInpout.getAddress(),employeeInpout.getCellPhone(),employeeInpout.getCityName()));

			}else {
		
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
						
			employeeData = employeeRepository.save(new Employee(PositionData,PersonData,employeeInpout.getSalary()));
		
		
		return new ResponseEntity<>(employeeData, HttpStatus.CREATED);
	}

	public static ResponseEntity<List<Employee>> getEmployee(String position, String name,
			positionRepository positionRepository, employeeRepository employeeRepository,
			personRepository personRepository) {
		//consultamos al empleado
		List<Employee> employees = new ArrayList<Employee>();
		
			if (position.isEmpty() && name.isEmpty()) {// consultamos por todo
				
				employees = employeeRepository.findAll();
				
			}else if (!position.isEmpty() && name.isEmpty()) {// consultamos por salario
				
				Position _position = positionRepository.findByName(position);			
				employees = employeeRepository.findByIdPosition(_position.getId());
				
			}else if (position.isEmpty() && !name.isEmpty()) {
				
				List<Person> _person = personRepository.findByName(name);			
				if (_person.size()>0) {
					for (Person person : _person) {
//						System.out.println(employeeRepository.findByIdPerson(person.getId()));
						employees.add(employeeRepository.findByIdPerson(person.getId()));
					}
				}
				
			}			
		
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
//		return employees;
	}

	public static ResponseEntity<List<positionListOutput>> getPosition(positionRepository positionRepository,
		employeeRepository employeeRepository, personRepository personRepository) {
		
		List<Position> positionData = positionRepository.findAll();		
		List<positionListOutput> positionListOutput = new ArrayList<positionListOutput>();
		
		for (Position position : positionData) {
			
			positionListOutput positionListOutputPivot = new positionListOutput();
			positionListOutputPivot.setId(position.getId());
			positionListOutputPivot.setName(position.getName());
			
				List<EmployeeLess> employeeLessList = new ArrayList<EmployeeLess>();
				List<Employee> employees = employeeRepository.findByIdPositionOrder(position.getId());
				
				for (Employee employeesPivot : employees) {
					
					EmployeeLess employelessPivot = new EmployeeLess();
					personOutput personOutputPivot = new personOutput();
					employelessPivot.setId(employeesPivot.getId());
					personOutputPivot.setAddress(employeesPivot.getPerson().getAddress());
					personOutputPivot.setCellPhone(employeesPivot.getPerson().getCellPhone());
					personOutputPivot.setCityName(employeesPivot.getPerson().getCityName());
					personOutputPivot.setLastName(employeesPivot.getPerson().getLastName());
					personOutputPivot.setName(employeesPivot.getPerson().getName());
					employelessPivot.setPerson(personOutputPivot);
					employelessPivot.setSalary(employeesPivot.getSalary());
					employeeLessList.add(employelessPivot);
					
				}
				
				positionListOutputPivot.setEmployees(employeeLessList);	
							
			positionListOutput.add(positionListOutputPivot);
		}
		
		return new ResponseEntity<>(positionListOutput, HttpStatus.OK);
	}

	public static ResponseEntity<Employee> updateEmployee(long id, EmployeeInpout employeeInpout,
			employeeRepository employeeRepository, personRepository personRepository,positionRepository positionRepository) {
		
		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			
			Employee _employee = employeeData.get();
						
			Person person = new Person();
			person.setAddress(employeeInpout.getAddress());
			person.setCellPhone(employeeInpout.getCellPhone());
			person.setCityName(employeeInpout.getCityName());
			person.setLastName(employeeInpout.getLastName());
			person.setName(employeeInpout.getName());
			person.setId(_employee.getPerson().getId());
			
			
			Position positionData = (Position) positionRepository.findByName(employeeInpout.getPosition());						
		if (positionData==null) {
			positionData = new Position();
			positionData = positionRepository.save(new Position(employeeInpout.getPosition().toString()));
		}

			personRepository.save(person);// veamos que id modifico						
			
			
			_employee.setSalary(employeeInpout.getSalary());
			_employee.setPerson(person);
			_employee.setPosition(positionData);
			
			return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
		} else {						
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public static ResponseEntity<List<Employee>> deleteEmployee(long id, employeeRepository employeeRepository,
			personRepository personRepository) {
		
		System.out.println();
		long idPerson=employeeRepository.findPersonById(id);
		
		employeeRepository.deleteById(id);
		personRepository.deleteById(idPerson);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	 
}
