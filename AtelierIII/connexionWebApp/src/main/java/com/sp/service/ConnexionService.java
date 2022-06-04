package com.sp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class ConnexionService {

	static final String URL_GET_USER = "http://localhost:8081/jeu/getUserByUsername/";

	public int connect(User u) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("my_other_key", "my_other_value");

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// Send request with GET method, and Headers.
		ResponseEntity<String> response = restTemplate.exchange(URL_GET_USER + u.getUserName(), //
				HttpMethod.GET, entity, String.class);

		String result = response.getBody();

		JSONObject userJson = new JSONObject(result);
		
		if(u.getMdp().equals(userJson.getString("mdp"))) {
			return userJson.getInt("id");
		}
		else {
			return -1;
		}

	}

}
