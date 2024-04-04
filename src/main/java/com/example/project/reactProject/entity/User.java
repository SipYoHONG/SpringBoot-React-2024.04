package com.example.project.reactProject.entity;

public class User {
	private String uid;
	private String uname;
	
	public User() { }
	public User(String uid, String uname) {
		this.uid = uid;
		this.uname = uname;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + "]";
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	

}
