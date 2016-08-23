package Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Prima on 8/11/2016.
 */
public class EventsPage {
    WebDriver driver;

    // This is a constructor
    public EventsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
