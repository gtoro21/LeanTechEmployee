package com.leantech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leantech.model.Person;

public interface personRepository extends JpaRepository<Person, Long>{

	@Query(nativeQuery = true, value = "select * from person where name = :name and address = :address and cell_phone = :cell_phone and city_name = :city_name and Last_name = :Last_name")
	Person findAllByAllData(@Param("name")String name,@Param("address")String address,@Param("cell_phone")String cell_phone,@Param("city_name")String city_name,@Param("Last_name")String Last_name);

	@Query(nativeQuery = true, value = "select * from person where name = :name ")
	List<Person> findByName(@Param("name")String name);
}
