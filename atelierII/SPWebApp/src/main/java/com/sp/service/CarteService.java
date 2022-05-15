package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Carte;
import com.sp.repository.CarteRepository;

@Service
public class CarteService {
	@Autowired
	CarteRepository cRepository;
	
	public void CreationCarte (Carte c) {
		Carte createdCarte=cRepository.save(c);
		System.out.println(createdCarte);
	}
	
	public void SuppressionCarte (Carte c) {
		cRepository.delete(c);
		System.out.println(c);
	}
	
	public void achatCarte (Carte c) {
		
	}
	
	public void venteCarte (Carte c) {
		
	}
	
	public Carte getCarte(int id) {
		Optional<Carte> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}

}
