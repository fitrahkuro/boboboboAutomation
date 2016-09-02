package UserManagement.MyShippingInfo;

import UserManagement.Auth.Homepage;
import UserManagement.Auth.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Prima on 8/9/2016.
 */
public class CreateShippingAddressTest {
    private StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver;
    WebElement countryOption;
    WebElement districtOption;
    Homepage homepage;
    LoginPage loginPage;
    ShippingInfoPage shippingInfoPage;
    Boolean loginElm;
    int districtIdx;
    int rowPrev;
    int columnPrev;
    int rowNext;
    int columnNext;
    String title = "home15";
    String fname = "Testing";
    String lname = "Bobobobo";
    String address = "Jalan Gereja Theresia";
    String city = "Jakarta";
    String country;
    String district;
    String postalCode = "12345";
    String phone = "08123457890";
    String email = "testing60@bobobobo.com";

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
    public void createShippingAddress() throws Exception {
        homepage.clickUserMenu();
        homepage.clickMyShippingMenu();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        rowPrev = shippingInfoPage.rowAddress();
        columnPrev = shippingInfoPage.columnAddress();
        shippingInfoPage.clickAddNewAddress();

        WebElement modal = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("modal-header")));

        int countryIdx = shippingInfoPage.randomCountry();
        shippingInfoPage.addNewAddress(title, fname, lname, address, city, countryIdx, postalCode, phone, email);
        if (countryIdx == 0) {
            districtIdx = shippingInfoPage.randomDistrict();
            shippingInfoPage.addDistrictByIdx(districtIdx);
            district = shippingInfoPage.selectedDistrict;
        }
        else {
            district = "Oklahoma";
            shippingInfoPage.addDistrictByInput(district);
        }
        country = shippingInfoPage.selectedCountry;
        shippingInfoPage.clickSubmitForm();

        // Wait for loading page
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Check if element has been added
        rowNext = shippingInfoPage.rowAddress();
        columnNext = shippingInfoPage.columnAddress();
        try {
            assertTrue(rowNext == rowPrev + 1 || columnNext == columnPrev + 1);
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
        }

        // Assert address title
        try {
            assertEquals(title, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,1));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        // Assert address user's name
        try {
            assertEquals(fname + " " + lname, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,2));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        // Assert address detail
        try {
            assertEquals(address, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,3));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        // Assert address city
        try {
            assertEquals(city + ", " + district, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,4));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        // Assert country
        try {
            assertEquals(country + ", " + postalCode, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,5));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        // Assert user's phone number
        try {
            assertEquals("Phone: " + phone, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,6));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        // Assert user's email
        try {
            assertEquals("Email: " + email, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,7));
        }
        catch (Error e) {
            System.out.println(verificationErrors.append(e.toString()));
            System.exit(1);
        }

        System.out.println("Address added");
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
