package UserManagement.MyProfile;

import UserManagement.Auth.Homepage;
import UserManagement.Auth.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Prima on 8/9/2016.
 */
public class ChangePasswordTest {
    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;
    AccountDetailsPage accDetailsPage;
    Boolean loginElm;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        accDetailsPage = PageFactory.initElements(driver, AccountDetailsPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginElm = driver.findElement(By.className("login_menu")) != null;
        if (loginElm) {
            homepage.clickLoginMenu();
            loginPage.doLogin("testing60@bobobobo.com","temanbobo");
            loginPage.clickLoginButton();
            System.out.println("Successfully login");
        }
    }

    @Test
    public void changePassword() {
        homepage.clickUserMenu();
        homepage.clickAccountDetailsMenu();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        accDetailsPage.changeCurrentPassword("temanbobo","temanbobo1","temanbobo1");

        if (accDetailsPage.getEditProfileMsg().contains("Success! Your password")) {
            System.out.println(accDetailsPage.getEditProfileMsg());
        }
        else {
            System.out.println("Other message? Check it manually");
        }
    }

     @After
     public void tearDown() {
         driver.quit();
     }

}
