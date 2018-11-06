package com.packt.project1.controller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

interface OcenaRepository extends CrudRepository<Ocena, Integer> {
	 @Query("SELECT o FROM Ocena o WHERE o.usluga.id = :id_uslugi")
	    public List<Ocena> findOcenaDlaUslugi(@Param("id_uslugi") Integer id_u);
}
