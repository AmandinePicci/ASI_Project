package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Carte;
import com.sp.repository.CarteRepository;
import com.sp.service.UserService;

import com.sp.model.User;

import java.util.List;

@Service
public class CarteService {
	@Autowired
	CarteRepository cRepository;
	
	@Autowired
	UserService uService;
	
	public void CreationCarte (Carte c) {
		Carte createdCarte=cRepository.save(c);
		System.out.println(createdCarte);
	}
	
	public void SuppressionCarte (Carte c) {
		cRepository.delete(c);
		System.out.println(c);
	}
	
	/**
	 * Fonction d'achat de carte avec la bdd, pas de deuxieme utilisateur
	 * @param c, carte qu'on veut acheter
	 * @param id, identifier de l'acheteur
	 */
	public void achatCarte (Carte c, int id_u) {
		User u = uService.getUser(id_u);
		
		int money=u.getArgent();
		int prix =c.getPrix();
		if (money>=prix) {
			u.setArgent(money-prix);
			u.setAjoutCarte(c);
			uService.updateUser(u);
			System.out.println("Carte acheté : Argent retiré et Carte supprimé");
		}
		else {
			System.out.println("PAS ASSEZ D'ARGENT !!! achat non validé");
		}
		
	}
	
	public void venteCarte (Carte c, int id_u) {
		User u = uService.getUser(id_u);
		List<Carte> lst = u.getCarte();
		if (lst.contains(c)) {
			int money=u.getArgent();
			int prix =c.getPrix();
			u.setArgent(money+prix);	
			u.setRemoveCarte(c);
			uService.updateUser(u);
			System.out.println("Carte vendue : Argent ajouté et Carte ajouté");
		}
		else {
			System.out.println("Vous ne possédez pas cette carte");
		}
		
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
