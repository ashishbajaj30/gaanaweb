package com.gaana.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gaana.base.LeftNav;
import com.gaana.pages.ArtistPage;
import com.gaana.pages.DiscoverPage;
import com.gaana.pages.HomePage;
import com.gaana.pages.NewReleasePage;
import com.gaana.pages.TopChartsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ContentTest {

	
	public static final ExtentReports reports = ExtentReports.get(ContentTest.class);
	public  HomePage home;
	
	
	@BeforeClass
	public void setup(){
		
		home = new HomePage();
	}
	@Test(priority=1,enabled=true)
	public void topchartContent(){
		//bakchod comment
		reports.startTest(" Topchart Page Content Check");
		try{
			TopChartsPage top = home.gotoTopcharts();
			Thread.sleep(3000);
			int a = top.contentCheck();
		
		Assert.assertEquals(a, 40);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "40 topcharts are present in Topcharts Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
	
	@Test(priority=2,enabled=true)
	public void newReleaseContent(){
		
		reports.startTest(" New Release Page Content Check");
		try{
			NewReleasePage newrel = home.gotoNewReleases();
		
			Thread.sleep(3000);	
		int a = newrel.contentCheck();
		//Thread.sleep(3000);
		System.out.println("a "+ a);
		Assert.assertEquals(a, 45);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "45 new releases are present in New Releases Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}

	@Test(priority=3,enabled=true)
	public void artistContent(){
		
		reports.startTest(" Artist Page Content Check");
		try{
			ArtistPage artist = home.gotoArtists();
		
			Thread.sleep(3000);	
		int a = artist.contentCheck();
		//Thread.sleep(3000);
		System.out.println("a "+ a);
		Assert.assertEquals(a, 45);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Artist Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}

	@Test(priority=4,enabled=true)
	public void discoverContent(){
		
		reports.startTest(" Discover Page Content Check");
		try{
			LeftNav.goToDiscover();
		
			Thread.sleep(3000);	
		int a = DiscoverPage.contentCheck();
		//Thread.sleep(3000);
		Assert.assertEquals(a, 31);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Discover Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test(priority=5,enabled=true)
	public void homeFeaturedPlaylistContent(){
		
		reports.startTest(" Featured Playlist HomePage  Content Check");
		try{
			LeftNav.goToHome();
		
			Thread.sleep(4000);	
		int a = home.featureplaylistcontentCheck();
		//Thread.sleep(3000);
		Assert.assertEquals(a, 10);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Featured playlist homepage Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test(priority=6,enabled=true)
	public void radioMirchlistContent(){
		
		reports.startTest(" Radio mirchi  HomePage  Content Check");
		try{
			LeftNav.goToHome();
		
			Thread.sleep(4000);	
		int a = home.radiomirchilistcontentCheck();
		//Thread.sleep(3000);
		Assert.assertEquals(a, 12);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Radio Mirchi homepage Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}

	@Test(priority=7,enabled=true)
	public void gaanaRadiolistContent(){
		
		reports.startTest(" Gaana Radio HomePage  Content Check");
		try{
			LeftNav.goToHome();
		
			Thread.sleep(4000);	
		int a = home.gaanaradiolistcontentCheck();
		//Thread.sleep(3000);
		Assert.assertNotEquals(a, 0, 0);
		//Assert.assertEquals(a, 31);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Gaana Radio homepage Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}


	@Test(priority=8,enabled=true)
	public void discoverListContent(){
		
		reports.startTest(" Discover List HomePage  Content Check");
		try{
			LeftNav.goToHome();
		
			Thread.sleep(4000);	
		int a = home.discoverlistcontentCheck();
		//Thread.sleep(3000);
		Assert.assertEquals(a, 15);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Discover list homepage Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}


	@Test(priority=9,enabled=true)
	public void playListHourContent(){
		
		reports.startTest(" Playlist Of the hour HomePage  Content Check");
		try{
			LeftNav.goToHome();
		
			Thread.sleep(4000);	
		int a = home.playlistOfHourListcontentCheck();
		//Thread.sleep(3000);
		Assert.assertEquals(a, 10);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in Playlist of the hour homepage Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test(priority=10,enabled=true)
	public void newReleasesHomeContent(){
		
		reports.startTest(" New releases HomePage  Content Check");
		try{
			LeftNav.goToHome();
		
			Thread.sleep(4000);	
		int a = home.newReleasesListcontentCheck();
		//Thread.sleep(3000);
		Assert.assertEquals(a, 20);
		//Assert.assertNotEquals(a, 0, 0);
		reports.log(LogStatus.PASS, "Data is present in newreleases homepage Section");
		}catch(AssertionError ae){
			
			reports.log(LogStatus.FAIL, ae.getMessage());
		}catch(Exception e){
			
			reports.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
}
