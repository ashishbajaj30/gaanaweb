package com.gaana.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gaana.base.LeftNav;
import com.gaana.base.Page;
import com.gaana.pages.ArtistPage;
import com.gaana.pages.HomePage;
import com.gaana.pages.NewReleasePage;
import com.gaana.pages.TopChartsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest {
	
	
	public static final ExtentReports reports = ExtentReports.get(HomePageTest.class);
	public static HomePage home = new HomePage();
	//reports.config().documentTitle("Gaana Web Automation ");
	
	

	
	@Test(priority=1,enabled=true)
	public void clickTopchart(){
		
		reports.startTest(" Topchart Header Section");		
		try{
		//	HomePage home = new HomePage();
		
			//Thread.sleep(3000);
		 TopChartsPage top = home.gotoTopcharts();
		  Thread.sleep(4000);
		  Assert.assertEquals(top.getURL(), Page.Config.getProperty("testsiteurl") + "topcharts");
		reports.log(LogStatus.PASS, "Validated the url");
		
		Thread.sleep(2000);
		Assert.assertEquals(top.verifyTextPresent("Bollywood Top 50"), true);
		reports.log(LogStatus.PASS, "Validated Bollywood topchart 50");
	}catch(AssertionError ae){
		
		reports.log(LogStatus.FAIL, ae.getMessage());
	}catch(Exception e){
		
		System.out.println("Inside exception");		
		reports.log(LogStatus.FAIL, e.getMessage());
		Assert.fail(e.getMessage());
	}
		 
	}
	

	@Test(priority=5,enabled=true)
	public void clickNewReleases() throws InterruptedException{
		
		reports.startTest(" NewReleases Header Section");	
		try{
			//HomePage home = new HomePage();
			 NewReleasePage newrel = home.gotoNewReleases();
			  //reports.log(LogStatus.INFO, "Clicked on New releases link");
		 Thread.sleep(1000);
		 
		 Assert.assertEquals(newrel.getURL(), Page.Config.getProperty("testsiteurl") + "newrelease");
		 reports.log(LogStatus.PASS, "Url is validated");
		 String [] exparr = {"HINDI" , "ENGLISH" , "TAMIL" , "TELUGU","MARATHI","PUNJABI","GUJARATI","BENGALI","KANNADA","MALAYALAM","BHOJPURI","ORIYA"};
		// Object[] actarr = newrel.getHeaderLanguages().toArray();
		
		Assert.assertEquals(newrel.getLanguageCount(), 12);
		 reports.log(LogStatus.PASS, "Header languages are validated.12 languages are present");
		 reports.endTest();
		 }catch(AssertionError ae){
				
			 reports.log(LogStatus.FAIL, ae.getMessage());
			 
		}catch(Exception e){
			 reports.log(LogStatus.FAIL, e.getMessage());
			 Assert.fail(e.getMessage());
		 }
		 
		 }
	
	@Test(priority=3,enabled=true)
	public void clickLanguages() throws InterruptedException{
		
		reports.startTest("Validate Languages Dropdown");	
		try{
		HomePage home = new HomePage();
		LeftNav.goToHome();
		 //reports.log(LogStatus.INFO, "Now on home page");
		 Thread.sleep(4000);
		 String [] exparr = {"HINDI" , "ENGLISH" , "TAMIL" , "TELUGU","PUNJABI","MARATHI","BENGALI","BHOJPURI","OTHERS"};
		 
		 Object[] actarr = home.setlanguage().toArray();
		 
		 Assert.assertEquals(actarr, exparr);
		 reports.log(LogStatus.PASS, "All the language options are validated");
		 }catch(AssertionError ae){
				
			 reports.log(LogStatus.FAIL, ae.getMessage());
			 
		}catch(Exception e){
			 
			 reports.log(LogStatus.FAIL, e.getMessage());
			 Assert.fail(e.getMessage());
		 }
		 
		 }
	
	/*@Test(priority=4,enabled=true)
	public void loginEmail(){
		
		reports.startTest("Validate Email login");		
		HomePage home = new HomePage();
		home.emailLogin();
		try {
			Thread.sleep(5000);
		
		System.out.println(home.userName());
		Assert.assertEquals(home.userName(), "ashish");
		 reports.log(LogStatus.PASS, "user name matched");
		 Thread.sleep(4000);
		 NewReleasePage newrel = home.loginUsergotoNewReleases();
		 Thread.sleep(4000);
		 Assert.assertEquals(newrel.getURL(), Page.Config.getProperty("testsiteurl") + "newrelease");
		 reports.log(LogStatus.PASS, "url is validated");
		}catch(AssertionError ae){
			
		 reports.log(LogStatus.FAIL, ae.getMessage());
		 
	} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
			reports.log(LogStatus.FAIL, e.getMessage());
		}}
	*/
	@Test(priority=2,enabled=true)
	public void clickArtist(){
		
		reports.startTest(" Artist Header Section");		
		try{
			
			ArtistPage artist = home.gotoArtists();
			
		Thread.sleep(4000);
				String actual = artist.getURL();
				 Assert.assertEquals(actual, Page.Config.getProperty("testsiteurl") + "artist");
		// Assert.assertEquals(ArtistPage.getURL(), Page.Config.getProperty("testsiteurl") + "artist");
			reports.log(LogStatus.PASS, "Validated the url");
			 	}catch(AssertionError ae){
		
		reports.log(LogStatus.FAIL, ae.getMessage());
	}catch(Exception e){
		System.out.println("Inside exception");		
		reports.log(LogStatus.FAIL, e.getMessage());
		Assert.fail(e.getMessage());
	}
		 
	}
}
