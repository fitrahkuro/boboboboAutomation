package UserManagement.Auth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Prima on 8/3/2016.
 */
public class LoginTest {
    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void login() {
        homepage.clickLoginMenu();
        loginPage.doLogin("testing60@bobobobo.com", "temanbobo");
        loginPage.clickLoginButton();
        System.out.println("Successfully login");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
