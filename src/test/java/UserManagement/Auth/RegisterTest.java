package UserManagement.Auth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Prima on 8/3/2016.
 */
public class RegisterTest {
    WebDriver driver;
    List<WebElement> title;
    Homepage homepage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void register() {
        homepage.clickLoginMenu();
        loginPage.clickRegister();

        int idxTitle = loginPage.randomTitle();
        int randomEmail = (int) Math.floor(Math.random() * 1001);
        String generateEmail = "testing" + randomEmail + "@bobobobo.com";

        loginPage.doRegister(idxTitle, "Test", "Bobobobo", generateEmail, "temanbobo", "temanbobo");
        System.out.println("Account created");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
