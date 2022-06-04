package com.sp.dto;

public class ConnexionDTO {

	private String userName;
	private String mdp;
	
	public ConnexionDTO() {
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName=username;
	}

	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp=mdp;
	}

}