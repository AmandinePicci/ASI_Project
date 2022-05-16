package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Connexion {
	@Id
	@GeneratedValue
	private String userName;
	private String mdp;
	
	public Connexion() {
	}

	public Connexion(String userName, String mdp) {
		super();
		this.userName = userName;
		this.mdp = mdp;
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

	@Override
	public String toString() {
		return "UserName:"+this.userName+", mdp:"+this.mdp;
	}
}
