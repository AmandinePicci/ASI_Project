package com.sp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Carte;

import java.util.Optional;

public interface CarteRepository extends CrudRepository<Carte, Integer> {
	
	public List<Carte> findByName(String name);
	
}
