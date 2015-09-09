package com.journaldev.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.jpa.data.Estado;


@Repository
public interface EstadoRepository  extends CrudRepository<Estado, Long>{






}
