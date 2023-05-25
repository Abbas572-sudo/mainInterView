package interView;

import TestComponents.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MyProfile extends BaseTest{
	ExtentReports extent;



	@Test(priority=1 , description = "Verify that user able to login with valid Email and Pasword and perfrom all calculations)")
	public void functionOne() throws IOException, InterruptedException {
		String partNumber = "";
           Thread.sleep(3000);
		   driver.findElement(By.xpath("//input[@placeholder='Enter Username or Email']")).sendKeys("abbas.310@gmail.com");
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//button[@id='submit']")).click();
		   Thread.sleep(10000);
		JavascriptExecutor ns = (JavascriptExecutor) driver;
		ns.executeScript("window.scrollTo(0, 200);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[6]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();
		String originalHandle = iter.next(); // the original tab's window handle
		String newHandle = iter.next(); // the new tab's window handle
		driver.switchTo().window(newHandle);
		   Thread.sleep(10000);
		  driver.findElement(By.cssSelector("img[src='./assets/assets/dist/images/multi_tyres_icon.png']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//span[@id='select2-model_id-container']")).click();
		  Thread.sleep(3000);
		 List<WebElement> modelNumber = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
          System.out.println(modelNumber);
		  Thread.sleep(3000);
		if (modelNumber.size() > 0) {
			modelNumber.get(0).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='select2-year_id-container']")).click();
		Thread.sleep(3000);
		List<WebElement> date= driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		System.out.println(modelNumber);
		Thread.sleep(3000);
		if (date.size() > 0) {
			date.get(0).click();
		}
         Thread.sleep(3000);
		driver.findElement(By.cssSelector("#select2-trim_id-container")).click();
		List<WebElement> Allother= driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		System.out.println(modelNumber);
		Thread.sleep(3000);
		if (Allother.size() > 0) {
			Allother.get(0).click();
		}
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[@id='submit_btn']")).click();
		  Thread.sleep(3000);
		JavascriptExecutor ms = (JavascriptExecutor) driver;
		ms.executeScript("window.scrollTo(0, 100);");
		  Thread.sleep(3000);
	     List<WebElement> images = driver.findElements(By.xpath("//div[@aria-live='polite']"));
		  Thread.sleep(4000);
		  System.out.println(images);
		Thread.sleep(30000);
		for (int i = 0; i < images.size(); i++) {
			if (i == 0) {
				WebElement img = images.get(i);
				Actions actions = new Actions(driver);
				actions.moveToElement(img).build().perform();
				Thread.sleep(4000);
				img.click();
				break;
			}
		}
		String valueString = driver.findElement(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > form:nth-child(2) > div:nth-child(4) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)")).getText();
		Thread.sleep(3000);
		int value = Integer.parseInt(valueString.replaceAll("[^0-25]+", ""));
        Thread.sleep(3000);
// Store the value in a variable
		int storedValue = value;
		Thread.sleep(3000);
// Loop until the numeric value is greater than 0
		while (value <= 25) {
			// Click on the next button
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='tireslider tireslider_0 slick-initialized slick-slider']//button[@aria-label='Next'][normalize-space()='Next']")).click();
			Thread.sleep(3000);
			// Re-find the element to get the updated value
			WebElement valueElement = driver.findElement(By.cssSelector("body > div:nth-child(12) > div:nth-child(1) > form:nth-child(2) > div:nth-child(4) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)"));
			Thread.sleep(3000);
			valueString = valueElement.getText();
			Thread.sleep(3000);
			value = Integer.parseInt(valueString.replaceAll("[^0-25]+", ""));
			Thread.sleep(3000);
			// Store the updated value in the variable
			storedValue = value;
			if(storedValue == 25){
				String partnumber = driver.findElement(By.cssSelector("div[class='panel panel-default carshowpanel carshowpanel_0'] div[class='panel-body'] div[class='col-lg-4 col-md-4 col-sm-4 col-xs-12'] div p[class='part_number']")).getText();
				System.out.println(partnumber);
				partNumber = partnumber;
				break;
			}
		}
		System.out.println(storedValue);
		Thread.sleep(3000);
		driver.switchTo().window(originalHandle);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@class='page-container']/div[@class='page-content']/div[@class='sidebar sidebar-main']/div[@class='sidebar-content']/div[contains(@class,'sidebar-category sidebar-category-visible')]/div[@class='category-content no-padding']/ul[@class='navigation navigation-main navigation-accordion']/li[4]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Distributors & DMS']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[src='https://d1gtiet8v4nxan.cloudfront.net/uploads/distributors/Groupe_Touchette_1635753371/1680878949.png']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//table[@class='table datatable-basic-details dataTable no-footer DTFC_Cloned']//thead//tr[@role='row']//th//input[@id='search-col-0']")).sendKeys(partNumber);
		Thread.sleep(10000);
       String forMatching =  driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(8)")).getText();
		int valueTwo = Integer.parseInt(forMatching.replaceAll("[^0-25]+", ""));
		int storedValueTwo = valueTwo;
		Assert.assertEquals(storedValue , storedValueTwo);
		driver.close();

	}




}
