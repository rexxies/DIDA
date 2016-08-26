package javaBeans;

import java.io.Serializable;
import java.util.ArrayList;

public class Lock implements Serializable{
	
	String name, ipaddress;
	ArrayList keyList;//integer arraylist
	
	public Lock() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public ArrayList getKeyList() {
		return keyList;
	}
	public void setKeyList(ArrayList keyList) {
		this.keyList = keyList;
	}
}
