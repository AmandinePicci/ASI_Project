package com.project.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import javax.print.DocFlavor.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import com.project.model.dto.FireDto;
import com.project.model.dto.VehicleDto;


@RestController 
public class ProjectController {
	
	
	  
  	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  		public String index(Model model) {  
  		return "index";
 
  	}
  	
  	@RequestMapping(value = { "/vehicle/{id}" }, method = RequestMethod.GET)
		public StringBuffer getOneVehiclex(@PathVariable String id) throws IOException{
  			StringBuffer ret = null;
	  		try {
				URL url = new URL("http://vps.cpe-sn.fr:8081/vehicle/"+id);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
					
	
				}
				in.close();
				ret = content;
			} catch (MalformedURLException e) {
				
			}
			
  		
			return ret;  
		

	}

  	@RequestMapping(value = { "/facility" }, method = RequestMethod.GET)
		public StringBuffer getAllFacilities(Model model) throws IOException {  
  		
		try {
			URL url = new URL("http://vps.cpe-sn.fr:8081/facility");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
				

			}
			in.close();
			return content;
		} catch (MalformedURLException e) {
			
		}
		return null;
	}
  	
  	@RequestMapping(value = { "/facility/{id}" }, method = RequestMethod.GET)
		public StringBuffer getFacilitybyId(@PathVariable String id) throws IOException {  
  			try {
  				URL url = new URL("http://vps.cpe-sn.fr:8081/facility/"+id);
  				HttpURLConnection con = (HttpURLConnection) url.openConnection();
  				con.setRequestMethod("GET");
  				
  				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
  				
  				String inputLine;
  				StringBuffer content = new StringBuffer();
  				while ((inputLine = in.readLine()) != null) {
  					
  					content.append(inputLine);
  					//System.out.println(inputLine);
  					String[] words = inputLine.split(",");
  					
  					for(int i = 0; i < words.length; i++) {
  						words[i] = words[i].split(":")[1];
	  					//System.out.println(words[i]);
  					}
  					words[words.length-1] = words[words.length-1].substring(0,words[words.length-1].length()-1);
  					System.out.println(words[4]);
  				}
  				in.close();
  				
  				return content;
  			} catch (MalformedURLException e) {
  				
  			}
  			return null;
	}
  	
  	@RequestMapping(value = { "/vehicule/{teamuuid}" }, method = RequestMethod.POST)
		public StringBuffer addVehicule(@PathVariable String teamuuid) throws IOException {  
			try {
  				URL url = new URL("http://vps.cpe-sn.fr:8081/vehicule/"+teamuuid);
  				HttpURLConnection con = (HttpURLConnection) url.openConnection();
  				con.setRequestMethod("POST");
  				
  				int status = con.getResponseCode();
  				
  				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
  				String inputLine;
  				StringBuffer content = new StringBuffer();
  				while ((inputLine = in.readLine()) != null) {
  					content.append(inputLine);
  				}
  				in.close();
  				System.out.println(status);
  				return content;
  			} catch (MalformedURLException e) {
  				
  			}
  			return null;
	}
  	
  	
		public double[] getAllFire() throws IOException{  
  		
  		double[] coordinates= new double[4];
  		try {
  				URL url = new URL("http://vps.cpe-sn.fr:8081/fire/");
  				HttpURLConnection con = (HttpURLConnection) url.openConnection();
  				con.setRequestMethod("GET");
  				
  				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
  				
  				String inputLine;
  				StringBuffer content = new StringBuffer();
  				while ((inputLine = in.readLine()) != null) {
  					
  					content.append(inputLine);
  					String[] words = inputLine.split(",");
  					
  					for(int i = 0; i < words.length; i++) {
  						words[i] = words[i].split(":")[1];
	  					
  					}
  					words[5] = words[5].substring(0,words[5].length()-1);
  					
  					coordinates[0] = Double.parseDouble(words[5]);
  					coordinates[1] = Double.parseDouble(words[4]);
  					coordinates[2] = Double.parseDouble(words[2]);
  					coordinates[3] = Double.parseDouble(words[0]);
  					
  				}
  				in.close();
  				
  			} catch (MalformedURLException e) {
  				
  			}
  			return coordinates;
			
}
	
		public double getOneFire(int fireId) throws IOException{ 
	  		double fireIntensity = 0;
	  		
	  		try {
	  				URL url = new URL("http://vps.cpe-sn.fr:8081/fire/"+fireId);
	  				HttpURLConnection con = (HttpURLConnection) url.openConnection();
	  				con.setRequestMethod("GET");
	  				
	  				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	  		
	  				String inputLine;
	  				StringBuffer content = new StringBuffer();
	  				while ((inputLine = in.readLine()) != null) {
	  				
	  					content.append(inputLine);
	  					String[] words = inputLine.split(",");
	  					
	  					for(int i = 0; i < words.length; i++) {
	  						words[i] = words[i].split(":")[1];
	  					}
	  					words[5] = words[5].substring(0,words[5].length()-1);
	  					
	  					fireIntensity = Double.parseDouble(words[2]);  
	  					//fireId = Integer.parseInt(words[0]);  
	  					//System.out.println(words[0]);
	  				}
	  				in.close();
	  				
	  			} catch (MalformedURLException e) {
	  				
	  			}
			return fireIntensity;
	  			
		}


  	@RequestMapping(value = { "/moveVehicle/{teamuuid}" }, method = RequestMethod.GET)
		public double updateVehicle(@PathVariable String teamuuid, @PathVariable int id, @RequestBody VehicleDto vehicle) throws IOException, InterruptedException { 
  		double[] coordinates = getAllFire();
  		
  		double fireIntensity = getOneFire((int)coordinates[3]);
  		
  		coordinates = getAllFire();
		JSONObject json = new JSONObject();
  		json.put("crewMember", vehicle.getCrewMember());
  		json.put("facilityRefID", 82);
  		json.put("fuel", vehicle.getFuel());
  		json.put("id", id);
  		json.put("lat", coordinates[0]);
  		json.put("liquidQuantity", vehicle.getLiquidQuantity());
  		json.put("liquidType", vehicle.getLiquidType());
  		json.put("lon", coordinates[1]);
  		json.put("type", vehicle.getType());
  	
  		HttpPost post = new HttpPost("http://vps.cpe-sn.fr:8081/vehicle/"+teamuuid);

        post.setEntity(new StringEntity(json.toString(),ContentType.APPLICATION_JSON));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            //System.out.println(EntityUtils.toString(response.getEntity()));
        }
  		
  		
  		while(true) {
  			
	  		if(fireIntensity > 0) {	  			
	  			
	  			Thread.sleep(1000);
	  			System.out.println(fireIntensity+" "+coordinates[3]);
	  		}
	  		
	  		else {
	  			Thread.sleep(5000);
	  			coordinates = getAllFire();
	  			JSONObject json2 = new JSONObject();
	  			json.put("crewMember", vehicle.getCrewMember());
	  	  		json.put("facilityRefID", 82);
	  	  		json.put("fuel", vehicle.getFuel());
	  	  		json.put("id", vehicle.getId());
	  	  		json.put("lat", coordinates[0]);
	  	  		json.put("liquidQuantity", vehicle.getLiquidQuantity());
	  	  		json.put("liquidType", vehicle.getLiquidType());
	  	  		json.put("lon", coordinates[1]);
	  	  		json.put("type", vehicle.getType());
	  	  	
	  	  		HttpPost post2 = new HttpPost("http://vps.cpe-sn.fr:8081/vehicle/"+teamuuid);
	
	  	        post2.setEntity(new StringEntity(json2.toString(),ContentType.APPLICATION_JSON));
	
	  	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
	  	             CloseableHttpResponse response = httpClient.execute(post2)) {
	
	  	            //System.out.println(EntityUtils.toString(response.getEntity()));
	  	        }
	  		}
	  		fireIntensity = getOneFire((int)coordinates[3]);
  		}
}
  	
  	@RequestMapping(value = { "/vehicle/{teamuuid}/{id}" }, method = RequestMethod.DELETE)
		public String delVehicle(@PathVariable int teamuuid, @PathVariable int id) {  
  			int myTeamuuid = teamuuid;
  			int vehicleId = id;
		return "";
	}

  	
  	
  	@RequestMapping(value = { "/gestion_vehicules" }, method = RequestMethod.GET)
		public String gestion_vehicules(Model model) {  
		return "gestion_vehicules";
	}
  	
  	/*@RequestMapping(value = { "/eteindre"}, method = RequestMethod.GET)
  		public void eteindre_feu() {
  		
  	}*/
}
