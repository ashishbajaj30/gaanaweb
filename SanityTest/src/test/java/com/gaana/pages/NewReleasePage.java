package com.gaana.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gaana.base.Page;

public class NewReleasePage  extends Page{
	
	public static WebElement element;
	/*
	public NewReleasePage(WebDriver driver){
		
		this.driver=driver;
	}*/
	
	public static String curURL;
	public static int i,count ;
	public  String getURL(){
		
			return driver.getCurrentUrl();
			
		
	}
	
	/*@SuppressWarnings("rawtypes")
	public List getHeaderLanguages() throws InterruptedException{
		
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav_tab']")));
		i=1;
		List<String> elemText = new ArrayList<String>();
		System.out.println("11111");
		while(driver.findElements(By.xpath(OR.getProperty("headerhindi") + "["+ i +"]/a")).size()!=0){
			
			System.out.println("333333");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("headerhindi") + "["+ i +"]/a")));
			elements.add(driver.findElement(By.xpath(OR.getProperty("headerhindi") + "["+ i +"]/a")));
			System.out.println("4444444");
			elemText.add(driver.findElement(By.xpath(OR.getProperty("headerhindi") + "["+ i +"]/a")).getText());
			i++;
			System.out.println("now i is " + i);
			System.out.println("hindidi" + elemText.get(i));
		}
		
		return elemText;
		
	}
	*/
	
	public int getLanguageCount(){
		
		int countlang = 0;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("headerhindi"))));
		element=driver.findElement(By.xpath(OR.getProperty("headerhindi")));
		countlang=element.findElements(By.tagName("li")).size();
		return countlang;
	}
    public int contentCheck(){
		
		
		element=driver.findElement(By.xpath(OR.getProperty("newreleasecontent")));
		count = element.findElements(By.tagName("li")).size();
		return count;
	}

}
