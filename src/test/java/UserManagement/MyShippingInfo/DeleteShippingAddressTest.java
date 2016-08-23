package UserManagement.MyShippingInfo;

import UserManagement.Auth.Homepage;
import UserManagement.Auth.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

/**
 * Created by Prima on 8/10/2016.
 */
public class DeleteShippingAddressTest {
    private StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;
    ShippingInfoPage shippingInfoPage;
    Boolean loginElm;
    int rowPrev;
    int columnPrev;
    int rowNext;
    int columnNext;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        shippingInfoPage = PageFactory.initElements(driver, ShippingInfoPage.class);
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
    public void deleteShippingAddress() throws Exception {
        homepage.clickUserMenu();
        homepage.clickMyShippingMenu();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        rowPrev = shippingInfoPage.rowAddress();
        columnPrev = shippingInfoPage.columnAddress();

        // Check if delete button is present
        try {
            assertTrue(shippingInfoPage.deleteAddressButton.isDisplayed());
        }
        catch (NoSuchElementException e) {
            System.out.println("Please add a new address");
            System.exit(1);
        }
        shippingInfoPage.clickDeteleButton();

        // Wait for loading page
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Check if element has been deleted
        rowNext = shippingInfoPage.rowAddress();
        columnNext = shippingInfoPage.columnAddress();
        try {
            assertTrue(rowNext == rowPrev - 1 || columnNext == columnPrev - 1);
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
        }

        System.out.println("Address deleted");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
