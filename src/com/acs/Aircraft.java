package com.acs;

public class Aircraft implements Comparable<Aircraft>{
	
	private int type;
	private int size;
	private int precedence;	
	private String name;
	
	public Aircraft(){};  

	public Aircraft(String name,int type,int size){
		this.name = name;
		this.type = type;
		this.size = size;
		setPrecedence(type+size);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrecedence() {
		return precedence;
	}

	public void setPrecedence(int precedence) {
		this.precedence = precedence;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int compareTo(Aircraft ac) {
		return this.getPrecedence()-ac.getPrecedence();
	}
	@Override
	public String toString() {
		return "Aircraft [name="+ name +", type=" + type + ", size=" + size + "]";
	}
	
	

}
