package com.gaana.util;

public class TestConfig {

	

	
	//public static String server="smtp.gmail.com";
	public static String server="smtp.outlook.office365.com";
	//public static String server="192.168.24.144";
	
	public static String from = "ashish.bajaj1@timesinternet.in";
	public static String password = "india@123";
	public static String[] to ={"ashish.bajaj1@timesinternet.in","ankur.girdhar@timesinternet.in"};
	//public static String[] to ={"ashish.bajaj1@timesinternet.in","sk.rahman@timesinternet.in","ankur.girdhar@timesinternet.in","aviraj.roy@timesinternet.in"};
	public static String subject = "Gaana Web Sanity Automation Results";
	
	public static String messageBody ="Gaana Sanity Automation Results  " ;
	public static String attachmentPath="E:\\reports\\report.html";
	public static String attachmentName="report.html";
	//public static String reportPath = System.getProperty("user.dir")+"//Reports.zip";
	//public static String reportPath = "E:\\reports\\report.html";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/selenium";
	

}
