package com.leantech.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leantech.model.Employee;


public interface employeeRepository extends JpaRepository<Employee, Long> {

	
	@Query(nativeQuery = true, value = "select * from employee where position_id = :position")
	 List<Employee> findByIdPosition(@Param("position")long position);
	
	@Query(nativeQuery = true, value = "select * from employee where person_id = :person")
	 Employee findByIdPerson(@Param("person")Long person);
	
	@Query(nativeQuery = true, value = "select * from employee where position_id = :position ORDER BY salary DESC" )
	List<Employee> findByIdPositionOrder(@Param("position")long position);
	
	@Query(nativeQuery = true, value = "select person_id from employee where id = :id" )
	long findPersonById(@Param("id")long id);
}
