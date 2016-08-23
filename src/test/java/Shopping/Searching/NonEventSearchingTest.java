package Shopping.Searching;

import Shopping.NonEventPage;
import UserManagement.Auth.Homepage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Prima on 8/11/2016.
 */
public class NonEventSearchingTest {
    WebDriver driver;
    Homepage homepage;
    NonEventPage searching;
    int categoryIdx;
    String keyword;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        searching = PageFactory.initElements(driver, NonEventPage.class);
    }

    @Test
    public void nonEventSearching() throws Exception {
        ArrayList<String> arrCategory = new ArrayList(Arrays.asList("women","men","living","eats","travel"));
        categoryIdx = (int) Math.floor(Math.random() * arrCategory.size());
        keyword = "white";

        // Check to redirect page to selected category
        if (arrCategory.get(categoryIdx).equalsIgnoreCase("women")) {
            homepage.clickWomenCategory();
        }
        else if (arrCategory.get(categoryIdx).equalsIgnoreCase("men")) {
            homepage.clickMenCategory();
        }
        else if (arrCategory.get(categoryIdx).equalsIgnoreCase("living")) {
            homepage.clickLivingCategory();
        }
        else if (arrCategory.get(categoryIdx).equalsIgnoreCase("eats")) {
            homepage.clickEatsCategory();
        }
        else if (arrCategory.get(categoryIdx).equalsIgnoreCase("travel")) {
            homepage.clickTravelCategory();
            keyword = "day";
        }

        searching.clickSearchIcon();
        searching.inputKeyword(keyword);

        // Wait for loading page
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        try {
            searching.getResultText().contains(keyword);
            System.out.println(searching.getResultText());
        }
        catch (Error e) {
            System.out.println("The result does not contain expected keyword");
            System.exit(1);
        }
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
