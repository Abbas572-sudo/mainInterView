package frameWorkPageObjectModel;

import Abstract.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends Abstractclass {
    WebDriver driver;
    public Cart(WebDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this );


    }

    @FindBy(css = "#add-to-cart-sauce-labs-onesie")
    WebElement firstItem;

    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    WebElement secondtItem;

    @FindBy(css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement thirdtItem;

    @FindBy(css = "#remove-sauce-labs-onesie")
    WebElement itemRemove;

    public  void cartAdd(){
        firstItem.click();
        secondtItem.click();
        thirdtItem.click();
    }

    public  void cartRemove(){
       itemRemove.click();
    }










}
