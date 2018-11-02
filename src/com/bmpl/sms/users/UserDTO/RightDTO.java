package com.bmpl.sms.users.UserDTO;

public class RightDTO {
	private String rightname;
	private String screen;
	
	
	public String getRightname() {
		return rightname;
	}
	public void setRightname(String rightname) {
		this.rightname = rightname;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	public RightDTO(String rightname, String screen)
	{
		this.rightname = rightname;
		this.screen = screen;
	}

}
