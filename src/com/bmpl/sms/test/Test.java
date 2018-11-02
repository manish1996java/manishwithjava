package com.bmpl.sms.test;

import com.bmpl.sms.users.view.LoginButtonScreen;

public class Test {
	
	//to display the splash screen welcome frame, and Login screen.
	public static void main(String args[]) throws InterruptedException
	{
		SplashScreen screen = new SplashScreen();
		Welcome welcome = new Welcome();
		screen.setVisible(true);
		for(int i=0;i<=100;i++) {
			Thread.sleep(100); // to take time gap in loading on splashscreen.
			screen.loadingnum.setText(Integer.toString(i)+"%");
			screen.loadingbar.setValue(i);
			if(i==100)
			{
				welcome.setVisible(true);
				screen.setVisible(false);
				screen.dispose();
				for(int j=0;j<=20;j++)
				{
					Thread.sleep(60);
					if(j==20)
					{
						
						LoginButtonScreen Lbs = new LoginButtonScreen();
						Lbs.setVisible(true);
						welcome.dispose();
					}
				}
			}
		}
	}
}
