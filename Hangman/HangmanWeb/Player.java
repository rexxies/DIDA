package nl.didacticum.servlets;

import java.io.Serializable;
/*
 * Java bean consists of: 
 * empty constructor
 * getters & setters
 * class must implement serializable
 */
public class Player implements Serializable{
	
	private String name;
	private int timesWon = 0;
	
	//empty constructor
	public Player() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimesWon() {
		return timesWon;
	}
	public void setTimesWon(int timesWon) {
		this.timesWon = timesWon;
	}
}
