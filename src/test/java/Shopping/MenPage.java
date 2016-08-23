package Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Prima on 8/11/2016.
 */
public class MenPage extends NonEventPage {
    WebDriver driver;

    // This is a constructor
    public MenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
