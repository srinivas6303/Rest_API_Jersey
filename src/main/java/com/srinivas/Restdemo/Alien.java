package com.srinivas.Restdemo;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Alien {
	private int alienid;
	private String name;
	private int points;
	
	public int getAlienid() {
		return alienid;
	}
	public void setAlienid(int alienid) {
		this.alienid = alienid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Alien [alienid=" + alienid + ", name=" + name + ", points=" + points + "]";
	}
	
	
	
}
