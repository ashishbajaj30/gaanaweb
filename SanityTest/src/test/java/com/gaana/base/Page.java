package com.gaana.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.gaana.util.TestConfig;
import com.gaana.util.monitoringMail;
import com.relevantcodes.extentreports.Chart;
import com.relevantcodes.extentreports.ExtentReports;

public class Page {

	public static WebDriver driver;
	//public static Logger log = Logger.getLogger("devpinoyLogger");
	//public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\testdata.xlsx");
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static List<WebElement> elements;
	static final ExtentReports reports = ExtentReports.get(Page.class);
	public static monitoringMail mail ;
	public static DesiredCapabilities cap;
	//public static RemoteWebDriver remote;
	
	@BeforeSuite
	public void setUp() throws IOException, ClassNotFoundException, SQLException{
		System.out.println("Test Before Suite");
		if(driver==null){
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fis);
			//reports.init(System.getProperty("user.dir")+ "\\src\\test\\resources\\reports\\report.html", true);
			reports.init("E:\\reports\\report.html", true);
			reports.config().documentTitle("Gaana Web Automation ");
			reports.config().reportTitle("Gaana Web Automation Results");
			reports.config().reportHeadline("Gaana Web Automation Results");
			reports.config().chartTitle(Chart.TEST, "Gaana TestCases Graph");
			//reports.config().chartTitle(Chart.TEST_SET, "test set chart");
			mail = new monitoringMail();
			
			if(Config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				elements = new ArrayList<WebElement>();
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "c:\\softwares\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}else if(Config.getProperty("browser").equals("chrome")){
				
				//System.setProperty("webdriver.chrome.driver", "c:\\softwares\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(Config.getProperty("browser").equals("grid")){
				
				 cap = DesiredCapabilities.firefox();
				 cap.setBrowserName("firefox");
				 cap.setPlatform(Platform.WINDOWS);
				 
				 driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				 elements = new ArrayList<WebElement>();
				
				
			}
			
			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//driver.findElement(By.xpath(OR.getProperty("gotit"))).click();
			//DbManager.setMysqlDbConnection();
			
			//New onboarding flow - skipping one billion and language selection pop-up
			
			driver.findElement(By.xpath(OR.getProperty("skip_onebillion"))).click();
			driver.findElement(By.xpath(OR.getProperty("skip_language"))).click();
		}
		
	}
	
	@AfterSuite
	public void tearDown() throws AddressException, MessagingException{
		
		//System.out.println("Inside mail 1");
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		System.out.println("mail sent");
		driver.quit();
		//reports.endTest();
	}
	
	public WebDriver getDriver(){
		
		return driver;
	}
	
}
