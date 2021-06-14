package com.leantech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leantech.model.Position;

public interface positionRepository extends JpaRepository<Position, Long> {
	
	 List<Position> findAllByName(String name);
	 
	 @Query(nativeQuery = true, value = "select * from position where name = :name")
	 Position findByName(@Param("name")String name);
	 

	
}
