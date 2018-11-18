package com.bmpl.sms.users.DTO;

import java.util.ArrayList;

public class UserDTO {
	private String userid;
	private String password;
	private String rolename;
	private ArrayList<RightDTO> rights;
	private boolean checklogin;
	
	
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public ArrayList<RightDTO> getRights() {
		return rights;
	}
	public void setRights(ArrayList<RightDTO> rights) {
		this.rights = rights;
	}
	public boolean isChecklogin() {
		return checklogin;
	}
	public void setChecklogin(boolean checklogin) {
		this.checklogin = checklogin;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
