package com.gaana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gaana.base.Page;

public class DiscoverPage extends Page{
	
	public static WebElement element;
	public static int count;
	
    public static int contentCheck(){
		
		
		element=driver.findElement(By.xpath(OR.getProperty("newreleasecontent")));
		count = element.findElements(By.tagName("li")).size();
		return count;
	}

}
