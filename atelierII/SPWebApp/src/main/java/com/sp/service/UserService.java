package com.sp.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.model.Connexion;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	
	public void addUser(User u) {
		User createdUser=uRepository.save(u);
		System.out.println(createdUser);
	}
	public int deleteUser(Connexion c) {
		int ret=1;
		List<User> utilisateurs = new ArrayList<User>();
		utilisateurs=uRepository.findByUserName(c.getUserName());
		if(utilisateurs.size()<0) {
			return ret;
		}
		else {
			User user = utilisateurs.get(0);
			if(c.getMdp().equals(user.getMdp())) {
				ret=user.getId();
				uRepository.delete(user);
				return ret;
			}
			else {
				return ret;
			}
		}
	}
	
	public User updateUser (User u) {
		return uRepository.save(u);
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}

	public int connect(Connexion c) {
		/*on va recupérer l'id de l'utilisateur et le stocker avec JS car on ne veut pas conserver de trace en full REST*/
		/*on compare mdp et identifiant avec bdd (méthode post ?) si oui retourne true - lancement requete get pour recup l'id et le transmettre 
		 * au jS */
		int ret = -1;
		List<User> utilisateurs = new ArrayList<User>();
		utilisateurs=uRepository.findByUserName(c.getUserName());
		if(utilisateurs.size()<0) {
			return ret;
		}
		else {
			User user = utilisateurs.get(0);
			if(c.getMdp().equals(user.getMdp())) {
				ret=user.getId();
				return ret;
			}
			else {
				return ret;
			}
		}
		
		
		
	}
	
}
