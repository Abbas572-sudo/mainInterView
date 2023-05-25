package frameWorkPageObjectModel;

import Abstract.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PriceSelect extends Abstractclass {
    WebDriver driver;
    public PriceSelect(WebDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this );


    }

    @FindBy(css = ".select_container")
    WebElement dropdown;

    @FindBy(css = ".product_sort_container")
    WebElement dropdownElement;



    public  void dropDown() throws InterruptedException {
        dropdown.click();
        Thread.sleep(3000);
        WebElement dropdownForSelect = dropdownElement;
        Thread.sleep(3000);
        Select select = new Select(dropdownForSelect);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(3000);

    }





}
