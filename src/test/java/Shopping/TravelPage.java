package Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Prima on 8/11/2016.
 */
public class TravelPage extends NonEventPage {
    WebDriver driver;

    // This is a constructor
    public TravelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
