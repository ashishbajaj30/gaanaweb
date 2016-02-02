package com.gaana.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gaana.base.LeftNav;
import com.gaana.base.Page;

public class HomePage extends Page{
	
	
	public static WebElement element;
	public static int count;
	
	/*public HomePage(WebDriver driver){
		
		this.driver=driver;
	}*/
	
	 
	public  TopChartsPage gotoTopcharts(){
		
		
		//driver.findElement(By.xpath(OR.getProperty("topchart"))).click();
		driver.findElement(By.linkText(OR.getProperty("topchart_text"))).click();
		return new TopChartsPage();
	}
	
	public static ArtistPage gotoArtists(){
		
		driver.findElement(By.xpath(OR.getProperty("artists"))).click();
		return new ArtistPage();
	}
	public static NewReleasePage gotoNewReleases(){
		
			
		System.out.println(OR.getProperty("newreleases"));
		driver.findElement(By.xpath(OR.getProperty("newreleases"))).click();
		return new NewReleasePage();
	}
	
public NewReleasePage loginUsergotoNewReleases(){
		
		driver.findElement(By.xpath(OR.getProperty("newreleases_login"))).click();
	//driver.findElement(By.linkText(OR.getProperty("newreleases_text"))).click();
		return new NewReleasePage();
	}
 public void userLogout(){
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("usericon"))));
	 driver.findElement(By.xpath(OR.getProperty("usericon"))).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("userlogout"))));
	 driver.findElement(By.xpath(OR.getProperty("userlogout"))).click();
	 
 }
	
	@SuppressWarnings("rawtypes")
	public List setlanguage(){
		
		int i =1;
		List<String> langTxt = new ArrayList<String>();
		LeftNav.goToHome();
		driver.findElement(By.xpath(OR.getProperty("language"))).click();
		
		while(driver.findElements(By.xpath(OR.getProperty("languageoption") +"["+ i + "]")).size()!=0){
			
			langTxt.add(driver.findElement(By.xpath(OR.getProperty("languageoption") +"["+ i + "]")).getText());
			i++;
		}
		System.out.println(langTxt.get(0));
		System.out.println("1 is "+ langTxt.get(1));
		return langTxt;
		
	}
	
	public void emailLogin(){
		
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("username"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("username"))));
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys("ashish.bajaj@grr.la");
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("password"))));
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("qwerty");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(Keys.ENTER);
	}
	
	public void fbLogin(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signin"))));
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		List<WebElement> fbicons = driver.findElements(By.xpath(OR.getProperty("fblogin")));
		fbicons.get(1).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iter =set.iterator();
		String Window1=iter.next();
		System.out.println("first window " + Window1);
		String Window2=iter.next();
		System.out.println("Second window " + Window2);
		driver.switchTo().window(Window2);
		driver.findElement(By.xpath(OR.getProperty("fbemail"))).sendKeys("auto.gaana@gmail.com");
		driver.findElement(By.xpath(OR.getProperty("fbpasswd"))).sendKeys("auto@123");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(OR.getProperty("fbloginbtn"))).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		set=driver.getWindowHandles();
		iter =set.iterator();
		String Parent= iter.next();		
		driver.switchTo().window(Parent);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void googleLogin(){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signin"))));	
		driver.findElement(By.xpath(OR.getProperty("signin"))).click();
		List<WebElement> fbicons = driver.findElements(By.xpath(OR.getProperty("googlelogin")));
		fbicons.get(1).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iter =set.iterator();
		String Window1=iter.next();
		System.out.println("first window " + Window1);
		String Window2=iter.next();
		System.out.println("Second window " + Window2);
		driver.switchTo().window(Window2);
		driver.findElement(By.xpath(OR.getProperty("googleemail"))).sendKeys("auto.gaana@gmail.com");
		driver.findElement(By.xpath(OR.getProperty("googlenext"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(OR.getProperty("googlepaswd"))).sendKeys("auto@123");
		driver.findElement(By.xpath(OR.getProperty("googlesignbtn"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		set=driver.getWindowHandles();
		iter =set.iterator();
		String Parent= iter.next();		
		driver.switchTo().window(Parent);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean signIn(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("signin"))));
		return driver.findElement(By.xpath(OR.getProperty("signin"))).isDisplayed();
	}
	public String userName(){
		
		return driver.findElement(By.xpath(OR.getProperty("usericon"))).getText();
		
	}
	
	
	public static int featureplaylistcontentCheck(){
		
		
		((JavascriptExecutor) driver).executeScript("scroll(0,250);");
		element=driver.findElement(By.xpath(OR.getProperty("featuredplaylistcontent")));
		count=element.findElements(By.xpath(OR.getProperty("featuredlist"))).size();
		return count;
	}
	
	public static int radiomirchilistcontentCheck(){
		
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500);");
		element=driver.findElement(By.xpath(OR.getProperty("radiomirchilistcontent")));
		count=element.findElements(By.xpath(OR.getProperty("radiomirchilist"))).size();
		return count;
	}
	
	public static int gaanaradiolistcontentCheck(){
		
		((JavascriptExecutor) driver).executeScript("scroll(0,1000);");		
		element=driver.findElement(By.xpath(OR.getProperty("gaanaradiolistcontent")));
		count=element.findElements(By.xpath(OR.getProperty("gaanaradiolist"))).size();
		return count;
	}
	public static int discoverlistcontentCheck(){
		
		
		element=driver.findElement(By.xpath(OR.getProperty("discoverlistcontent")));
		count=element.findElements(By.xpath(OR.getProperty("discoverhomelist"))).size();
		return count;
	}
	
	public static int playlistOfHourListcontentCheck(){
		
		element=driver.findElement(By.xpath(OR.getProperty("playlisthourlistcontent")));
		count=element.findElements(By.xpath(OR.getProperty("playlisthourcontent"))).size();
		return count;
	}
	
	public static int newReleasesListcontentCheck(){
		
		element=driver.findElement(By.xpath(OR.getProperty("newreleaseslist")));
		count=element.findElements(By.xpath(OR.getProperty("newreleaseslistcontent"))).size();
		return count;
	}
	
	
}
