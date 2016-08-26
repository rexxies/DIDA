package javaBeans;

import java.io.Serializable;

public class User implements Serializable{
	
	private int userID, userRights;
	private String name;
	
	public User() {
		super();
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getUserRights() {
		return userRights;
	}
	public void setUserRights(int userRights){
		this.userRights = userRights;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
