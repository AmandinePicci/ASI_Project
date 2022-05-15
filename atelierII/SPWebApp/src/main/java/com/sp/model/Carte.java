package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Carte {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String family;
	private String smallImgUrl;
	private String imgUrl;
	private int energy;
	private int hp;
	private int defence;
	private int attack;
	

	public Carte() {}
	
	public Carte(int id,String name, String description, String family, String smallImgUrl, String imgUrl, int energy, int hp, int defence, int attack ) {
		super();
		this.id=id;
		this.name = name;
		this.description=description;
		this.family=family;
		this.smallImgUrl=smallImgUrl;
		this.imgUrl = imgUrl;
		this.energy = energy;
		this.hp = hp;
		this.defence=defence;
		this.attack=attack;
		
	}

	
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

	@Override
	public String toString() {
		return "CARTE ["+this.id+"]: name : "+this.name+", description : "+this.description +", famille : "+this.family +", imgUrl : "+this.imgUrl +", Vignette imgUrl : "+this.smallImgUrl +", energy : "+this.energy +", hp : "+this.hp+", defence : "+this.defence+", attack : "+this.attack;
	}
}
