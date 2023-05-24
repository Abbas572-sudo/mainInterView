package TestComponents;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest{

	public WebDriver driver;
	public WebDriver intializeDriverNew() throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//objectModle//GlobalData.properties");
		pro.load(fis);
		String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") :pro.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome")) {
	    	
	    	System.setProperty("webdriver.chrome.driver", "/Users/muhammadabbas/Downloads/chromedriver");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
	    
		      
	    }
		else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "/Users/muhammadabbas/Downloads/geckodriver");

			driver = new FirefoxDriver();
		}
	    
	    return driver;

	}




	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = null;
		if (ts != null) {
			source = ts.getScreenshotAs(OutputType.FILE);
		} else {
			// Handle the case where ts is null
			throw new NullPointerException("TakesScreenshot object is null");
		}
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}


	@BeforeMethod
	public void launchSite() throws IOException {
		driver = intializeDriverNew();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		}
	

}
