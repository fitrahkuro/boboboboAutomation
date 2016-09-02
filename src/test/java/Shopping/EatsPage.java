package Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Prima on 8/11/2016.
 */
public class EatsPage extends NonEventPage {
    WebDriver driver;

    // This is a constructor
    public EatsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
