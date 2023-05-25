package objectModle;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
public static ExtentReports getReportObject()
{
String path = System.getProperty("user.dir")+"//reports//index.html";
ExtentSparkReporter reporter = new ExtentSparkReporter(path);

reporter.config().setReportName("Functional Testing");
reporter.config().setDocumentTitle("INNOVENT");

ExtentReports extent =new ExtentReports();
extent.attachReporter(reporter);
extent.setSystemInfo("Tester", "M.Abbas");
extent.setSystemInfo("Version" , "V-1.1");
extent.setSystemInfo("Browser" , "Google Chrome");
extent.setSystemInfo("Branch" , "Live");
extent.setSystemInfo("Link" , "https://www.saucedemo.com/");
extent.setSystemInfo("Testing" , "Functional");
extent.setSystemInfo("Modules" , "Sing-In ");

extent.getTestSubject();

return extent;
}
}





//public class ExtentReporterNG {
//	
//	
////	public static  ExtentReports  getReportObject() {
//////		String path = System.getProperty("user.dir")+"//reports//index.html";
//////		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//////		reporter.config().setReportName("AskSophieAutomatedTestResult");
//////		reporter.config().setDocumentTitle("TestResults");
//////	
//////		ExtentReports extent =  new ExtentReports();
//////		extent.attachReporter(reporter);
//////		extent.setSystemInfo("Tester", "M.Abbas");
////		
////		String path = System.getProperty("user.dir")+"//reports//index.html";
////		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
////		reporter.config().setReportName("We Automation Result");
////		reporter.config().setDocumentTitle("Test Results");
////		ExtentReports extent =  new ExtentReports();
////		extent.attachReporter(reporter);
////		extent.setSystemInfo("Tester", "Ramesh K");
////		return extent;
////	}
//	
//	public static ExtentReports getReportObject()
//	{
//	String path =System.getProperty("user.dir")+"//reports//index.html";
//	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//	reporter.config().setReportName("Web Automation Results");
//	reporter.config().setDocumentTitle("Test Results");
//	ExtentReports extent =new ExtentReports();
//	extent.attachReporter(reporter);
//	extent.setSystemInfo("Tester", "Rahul Shetty");
//	return extent;
//	}
//	
//	
//	
//	
//}
