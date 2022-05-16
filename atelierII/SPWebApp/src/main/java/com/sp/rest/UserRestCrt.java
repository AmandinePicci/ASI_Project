  package com.sp.rest;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.User;
  import com.sp.model.Connexion;
  import com.sp.service.UserService;

  @RestController
  public class UserRestCrt {
      @Autowired
      UserService uService;
      
      @RequestMapping(method=RequestMethod.POST,value="/user")
      public void addUser(@RequestBody User user) {
          uService.addUser(user);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
      public User getUser(@PathVariable String id) {
          User u=uService.getUser(Integer.valueOf(id));
          return u;
      }
     
      
      @RequestMapping(method=RequestMethod.DELETE,value="/deleteUser")
      public void deleteUser(@RequestBody Connexion connexion) {
          uService.deleteUser(connexion);
      }
      
      
      @RequestMapping(method=RequestMethod.POST,value="/connect")
      public int connect(@RequestBody Connexion connexion) {
    	  int ret=-1;
          ret=uService.connect(connexion);
          return ret;
      }
      
     
      
  }
