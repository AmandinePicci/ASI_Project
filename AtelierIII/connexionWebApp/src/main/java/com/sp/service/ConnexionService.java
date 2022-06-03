package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class ConnexionService {
	
	@Autowired
	UserRepository uRepository;

	public int connect(User u) {
		/*on va recupérer l'id de l'utilisateur et le stocker avec JS car on ne veut pas conserver de trace en full REST*/
		/*on compare mdp et identifiant avec bdd (méthode post ?) si oui retourne true - lancement requete get pour recup l'id et le transmettre 
		 * au jS */
		int ret = -1;
		List<User> utilisateurs = new ArrayList<User>();
		utilisateurs=uRepository.findByUserName(u.getUserName());
		if(utilisateurs.size()<=0) {
			return ret;
		}
		else {
			User user = utilisateurs.get(0);
			if(u.getMdp().equals(user.getMdp())) {
				ret=user.getId();
				return ret;
			}
			else {
				return ret;
			}
		}
		
		
		
	}

}
