package com.sp.rest;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.Carte;
  import com.sp.service.CarteService;

  @RestController
  public class CarteRestCrt {
      @Autowired
      CarteService cService;
      
      @RequestMapping("/hello")
      public String sayHello() {
    	  return "Hello Hero !!!";
      }
      
      @RequestMapping(method=RequestMethod.POST,value="/carte")
      public void addCarte(@RequestBody Carte carte) {
          cService.CreationCarte(carte);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/carte/{id}")
      public Carte getCarte(@PathVariable String id) {
          Carte c=cService.getCarte(Integer.valueOf(id));
          return c;
      }
      
      @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
      public void deleteCarte(@PathVariable String id) {
    	  Carte c=cService.getCarte(Integer.valueOf(id));
    	  cService.SuppressionCarte(c);
      }
      
      
      
      @RequestMapping(method=RequestMethod.POST,value="/achat/{id_carte}/{id_utilisateur}")
      public void Achat(@PathVariable String id_carte, @PathVariable String id_utilisateur) {
    	  Carte c=cService.getCarte(Integer.valueOf(id_carte));
    	  cService.achatCarte(c,Integer.valueOf(id_utilisateur));
      }
      
      @RequestMapping(method=RequestMethod.POST,value="/vente/{id_carte}/{id_utilisateur}")
      public void Vente(@PathVariable String id_carte, @PathVariable String id_utilisateur) {
    	  Carte c=cService.getCarte(Integer.valueOf(id_carte));
    	  cService.venteCarte(c,Integer.valueOf(id_utilisateur));
      }
  }
