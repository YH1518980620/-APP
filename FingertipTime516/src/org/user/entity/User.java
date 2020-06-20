package org.user.entity;

public class User {
	private String uname;
	private String uid;
	private String usex;
	private String upwd;
	public User() {
		
	}
	public User(String name,String id,String sex,String pwd) {
		uname=name;
		uid=id;
		usex=sex;
		upwd=pwd;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
}
