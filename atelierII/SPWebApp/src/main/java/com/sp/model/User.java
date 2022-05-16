package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import com.sp.model.Carte;

@Entity
public class User {
	@Id
	@GeneratedValue

	private int id;
	private String userName;
	private String mdp;
	private int argent;
	
	@OneToMany
	private List<Carte> cardList;
	
	public User() {
	}

	public User(int id,String userName, String mdp, int argent) {
		super();
		this.id=id;
		this.userName = userName;
		this.mdp = mdp;
		this.argent = argent;
		this.cardList=null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public List<Carte> getCarte(){
		return(this.cardList);
	}
	
	public void setAjoutCarte(Carte c) {
		this.cardList.add(c);
	}
	
	public void setRemoveCarte(Carte c) {
		this.cardList.remove(c);
	}
	@Override
	public String toString() {
		return "USER ["+this.id+"]: userName:"+this.userName+", mdp:"+this.mdp+", argent:"+this.argent;
	}
}

