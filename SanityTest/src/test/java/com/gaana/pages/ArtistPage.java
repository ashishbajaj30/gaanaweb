package com.gaana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gaana.base.Page;

public class ArtistPage extends Page {

	
	public static int count;
	public static WebElement element;
	
	public  String getURL(){	
		
		
		System.out.println("1111");
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		return actual;
	}
	
	 public int contentCheck(){
			
			
			element=driver.findElement(By.xpath(OR.getProperty("artistcontent")));
			count = element.findElements(By.tagName("li")).size();
			return count;
		}
}
