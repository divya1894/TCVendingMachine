package com.yash.casestudy.TCVendingMachine;

public class ContainerDTO {

	private Integer Tea;
	
	private Integer Coffee;
	
	private Integer Milk;
	
	private Integer Sugar;
	
	private Integer Water;

	public ContainerDTO(Integer Tea, Integer Coffee, Integer Water, Integer Milk, Integer Sugar) {
		this.Tea = Tea;
		this.Coffee = Coffee;
		this.Water = Water;
		this.Milk = Milk;
		this.Sugar = Sugar;
	}

	public Integer getTea() {
		return Tea;
	}

/*	public void setTea(Integer tea) {
		Tea = tea;
	}*/

	public Integer getCoffee() {
		return Coffee;
	}

/*	public void setCoffee(Integer coffee) {
		Coffee = coffee;
	}*/

	public Integer getMilk() {
		return Milk;
	}

/*	public void setMilk(Integer milk) {
		Milk = milk;
	}*/

	public Integer getSugar() {
		return Sugar;
	}

/*	public void setSugar(Integer sugar) {
		Sugar = sugar;
	}*/

	public Integer getWater() {
		return Water;
	}

/*	public void setWater(Integer water) {
		Water = water;
	}*/
	
}
