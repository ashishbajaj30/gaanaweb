package com.gaana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gaana.base.Page;

public class TopChartsPage extends Page{

	public static String curURL;
	public static int count;
	public static WebElement element;
	
	public  String getURL(){
		
		curURL = driver.getCurrentUrl();
		return curURL;
		
		
	}
	
	public String getText(){
		
		return driver.findElement(By.xpath(Page.OR.getProperty("bollywoodtopchart"))).getText();
		
	}
	
	public int contentCheck(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("topadd"))));
		//driver.navigate().refresh();
		element=driver.findElement(By.xpath(OR.getProperty("topchartcontent")));
		count = element.findElements(By.tagName("a")).size();
		return count;
	}
	
	public boolean verifyTextPresent(String value){
		
		return driver.getPageSource().contains(value);
	}

}
