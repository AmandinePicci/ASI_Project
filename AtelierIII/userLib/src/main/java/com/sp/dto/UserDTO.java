package com.sp.dto;

import java.util.List;

public class UserDTO {

	private int id;
	private String userName;
	private String mdp;
	private int argent;
	private List<Integer> cardList;

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
	
	public List<Integer> getCarte(){
		return(this.cardList);
	}
	
	public void setAjoutCarte(int c) {
		this.cardList.add(c);
	}
	
	public void setRemoveCarte(int c){
		this.cardList.remove(c);
	}

}
