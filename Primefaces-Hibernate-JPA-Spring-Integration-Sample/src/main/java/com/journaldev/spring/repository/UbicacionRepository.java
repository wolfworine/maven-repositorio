package com.journaldev.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.journaldev.jpa.data.Ubicacion;

@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, Long>{

	public final static String FIND_BY_CODIGO= "SELECT u " + 
            "FROM Ubicacion u " +
            "WHERE u.id = :id ";
	
	@Query(FIND_BY_CODIGO)
	Ubicacion findCod(@Param("id")  String id);

	
	
}
