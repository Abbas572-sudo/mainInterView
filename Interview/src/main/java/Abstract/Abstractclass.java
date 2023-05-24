package Abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Abstractclass {
	  WebDriver driver;
		public Abstractclass(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver , this );
			
		}
		


}