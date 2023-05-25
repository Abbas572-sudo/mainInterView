package interView;

import TestComponents.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import frameWorkPageObjectModel.Cart;
import frameWorkPageObjectModel.PriceSelect;
import frameWorkPageObjectModel.Signin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main extends BaseTest{
	ExtentReports extent;
   
	String username = "standard_user";
	String password = "secret_sauce";

    @Test(priority = 1, description = "Verify that user able to login with valid Email and Pasword and perfrom")
    public void functionOne() throws IOException, InterruptedException {

        Signin signin = new Signin(driver);
        signin.loign(username , password);
        Thread.sleep(3000);
        String forAssertion = driver.findElement(By.cssSelector(".title")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(forAssertion , "Products");
		driver.close();

    }
	@Test(priority = 2, description = "assert that the first item has the lowest price and that the last item has the highest price.if user select price low to high")
	public void functionTwo() throws IOException, InterruptedException {

		Signin signin = new Signin(driver);
		signin.loign(username , password);
		Thread.sleep(3000);
		PriceSelect price = new PriceSelect(driver);
		price.dropDown();
        Thread.sleep(3000);
		List<WebElement> priceElements = driver.findElements(By.cssSelector(".inventory_item_price"));
		List<Double> prices = new ArrayList<>();
		for (WebElement element : priceElements) {
			String priceText = element.getText().replace("$", "");
			double priceofElement = Double.parseDouble(priceText);
			prices.add(priceofElement );
		}
		Assert.assertTrue(prices.get(0) < prices.get(prices.size() - 1));
		driver.close();

	}

	@Test(priority = 3, description = "Cart Assertion")
	public void functionThree() throws IOException, InterruptedException {
		Signin signin = new Signin(driver);
		signin.loign(username , password);
		Cart cart = new Cart(driver);
		cart.cartAdd();
		String forAssertion = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
		Assert.assertEquals(forAssertion , "3");
		cart.cartRemove();
		String forAssertionSecond = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
		Assert.assertEquals(forAssertionSecond , "2");
		driver.close();

	}







}
