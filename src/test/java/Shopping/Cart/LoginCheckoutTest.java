package Shopping.Cart;


import Shopping.Cart.LoginCheckoutPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by fitrah on 9/21/2016.
 */
public class LoginCheckoutTest {
        WebDriver driver;
        LoginCheckoutPage loginPage;

        @Before
        public void setUp() {
            driver = new FirefoxDriver();
            loginPage = PageFactory.initElements(driver, LoginCheckoutPage.class);
        }

        @Test
        public void login() {
            driver.get ("https://www.bobobobo.com/user/login?r=/en/checkout/create");
            loginPage.doLogin("testing60@bobobobo.com", "temanbobo");
            loginPage.clickLoginButton();
            System.out.println("Successfully login");
        }

        @After
        public void tearDown() {
        }

    }