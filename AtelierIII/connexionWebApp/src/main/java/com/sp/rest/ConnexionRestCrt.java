package com.sp.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.dto.ConnexionDTO;
import com.sp.mapper.MapperConnexionUser;
import com.sp.model.User;
import com.sp.service.ConnexionService;

@RestController
public class ConnexionRestCrt {
	@Autowired
	ConnexionService cService;

	@RequestMapping(method = RequestMethod.POST, value = "/jeu/connect")
	public int connect(@RequestBody ConnexionDTO connexionDto) {
		MapperConnexionUser mapper = new MapperConnexionUser();
		int ret;
		User user = new User();
		user=mapper.mapDtoToUser(connexionDto);
		ret=cService.connect(user);
		return ret;
	}

}
