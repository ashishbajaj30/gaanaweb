package com.gaana.base;

import org.openqa.selenium.By;

public class LeftNav {

	
	public static void goToHome(){
		
		Page.driver.findElement(By.xpath(Page.OR.getProperty("home"))).click();
				
	}
	
	public static void goToDiscover(){
		
		Page.driver.findElement(By.xpath(Page.OR.getProperty("discover"))).click();
				
	}
}
