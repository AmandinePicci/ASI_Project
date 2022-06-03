package com.sp.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.dto.CarteDTOprix;
import com.sp.dto.CarteDto;
import com.sp.model.Carte;
import com.sp.service.CarteService;

@RestController
public class RestCrt {
	
	@Autowired
    CarteService cService;
	
    @RequestMapping("/hello")
    public String sayHello() {
  	  return "Hello Hero !!!";
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/carte")
    public void addCarte(@RequestBody CarteDto carteDto) {
    	Carte carte = new Carte ();
    	BeanUtils.copyProperties(carteDto, carte);
        cService.CreationCarte(carte);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/carte/{id}")
    public CarteDto getCarte(@PathVariable String id) {
        Carte c=cService.getCarte(Integer.valueOf(id));
        CarteDto carteDto = new CarteDto ();
        BeanUtils.copyProperties(c, carteDto);
        return carteDto;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/cartePrix/{id}")
    public CarteDTOprix getCartePrix(@PathVariable String id) {
        Carte c=cService.getCarte(Integer.valueOf(id));
        CarteDTOprix carteDTOprix = new CarteDTOprix ();
        BeanUtils.copyProperties(c, carteDTOprix);
        return carteDTOprix;
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteCarte(@PathVariable String id) {
  	  Carte c=cService.getCarte(Integer.valueOf(id));
  	  cService.SuppressionCarte(c);
    }
    

}
