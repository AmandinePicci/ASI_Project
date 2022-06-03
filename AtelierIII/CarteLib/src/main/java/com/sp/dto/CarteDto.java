package com.sp.dto;

public class CarteDto {

	private int id;
	private String name;
	private String description;
	private String family;
	private int prix;
	private String smallImgUrl;
	private String imgUrl;
	private int energy;
	private int hp;
	private int defence;
	private int attack;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family=family;
	}
	
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public String getSmallImgUrl() {
		return smallImgUrl;
	}
	public void setsmallImgUrl(String smallImgUrl) {
		this.smallImgUrl= smallImgUrl;
	}

	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	
	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
