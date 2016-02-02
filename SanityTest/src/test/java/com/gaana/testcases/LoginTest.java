package com.gaana.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gaana.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	
	
	public static final ExtentReports reports = ExtentReports.get(LoginTest.class);
	public static HomePage home ;
	
	@BeforeClass
	public void setup(){
		
		home = new HomePage();
	}
	
	@Test(priority=1,enabled=true)
	public void loginEmail(){
		
		reports.startTest("Validate Email login");		
		//HomePage home = new HomePage();
		home.emailLogin();
		try {
			Thread.sleep(5000);
		
		System.out.println(home.userName());
		Assert.assertEquals(home.userName(), "test");
		 reports.log(LogStatus.PASS, "user logged in and user name matched");
		 //Thread.sleep(4000);
		 home.userLogout();
		 //NewReleasePage newrel = home.loginUsergotoNewReleases();
		 //Thread.sleep(5000);
		 Assert.assertEquals(home.signIn(), true);
		 
		 reports.log(LogStatus.PASS, "User successfully logout ");
		}catch(AssertionError ae){
			
		 reports.log(LogStatus.FAIL, ae.getMessage());
		 
	} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println(e.getStackTrace());
		reports.log(LogStatus.FAIL, e.getMessage());	
		Assert.fail();
			
		}}
	
	@Test(priority=2,enabled=true)
	public void loginFacebook(){
		
		reports.startTest("Validate Facebook login");		
		//HomePage home = new HomePage();
		try {
		home.fbLogin();
		
			Thread.sleep(5000);
		
		System.out.println(home.userName());
		Assert.assertEquals(home.userName(), "ashish");
		 reports.log(LogStatus.PASS, "FB user logged in and user name matched");
		// Thread.sleep(4000);
		 
		 home.userLogout();
		 //Thread.sleep(7000);
		Assert.assertEquals(home.signIn(), true);
		 reports.log(LogStatus.PASS, "User successfully logout ");
		}catch(AssertionError ae){
			
		 reports.log(LogStatus.FAIL, ae.getMessage());
		 
	} catch (Exception e) {
		
		reports.log(LogStatus.FAIL, e.getMessage());
			// TODO Auto-generated catch block
			Assert.fail();
			
		}
		
		 }


	@Test(priority=3,enabled=true)
	public void loginGoogle(){
		
		reports.startTest("Validate Google Plus login");		
		//HomePage home = new HomePage();
		try {
		home.googleLogin();
		
			Thread.sleep(5000);
		
		System.out.println(home.userName());
		Assert.assertEquals(home.userName(), "ashish");
		 reports.log(LogStatus.PASS, "Google user logged in and user name matched");
		// Thread.sleep(4000);
		 
		 home.userLogout();
		 //Thread.sleep(7000);
		Assert.assertEquals(home.signIn(), true);
		 reports.log(LogStatus.PASS, "User successfully logout ");
		}catch(AssertionError ae){
			
		 reports.log(LogStatus.FAIL, ae.getMessage());
		 
	} catch (Exception e) {
		
		reports.log(LogStatus.FAIL, e.getMessage());
			// TODO Auto-generated catch block
			Assert.fail();
			
		}
		
		 }

}
