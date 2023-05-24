package frameWorkPageObjectModel;

import Abstract.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin extends Abstractclass {
    WebDriver driver;
    public Signin(WebDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver , this );


    }
    @FindBy(css = "#user-name")
    WebElement usernameField;
    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#login-button")
    WebElement loinBtn;

    public void loign(String username , String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loinBtn.click();

    }


}
