package UserManagement.Auth;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Prima on 8/5/2016.
 */
public class ForgotPasswordTest {
    static WebDriver driver;
    static Homepage homepage;
    static LoginPage loginPage;
    static ForgotPasswordPage forgotPasswordPage;
    String errorMsg;
    String email;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
    }

    @Test
    public void forgotPassword() {
        homepage.clickLoginMenu();
        loginPage.clickForgotPass();
        email = "testing60@bobobobo.com";
        forgotPasswordPage.resetPass(email);
        errorMsg = forgotPasswordPage.getErrorMsg();
        if (errorMsg.equalsIgnoreCase("We sent email to " + email)) {
            System.out.println("Your password has been reset, check your email");
        }
    }

    @Test
    public void loginInstead() {
        forgotPasswordPage.clickLoginInstead();
        System.out.println("Go to login page");
        loginPage.doLogin("testing60@bobobobo.com","temanbobo");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
