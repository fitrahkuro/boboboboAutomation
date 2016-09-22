package Shopping.Cart;

import Shopping.Cart.CheckoutShippingPage;
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
 * Created by Fitrah on 9/22/2016.
 */
public class CheckoutShippingTest {
    private StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver;
    WebElement countryOption;
    WebElement districtOption;
    CheckoutShippingPage checkoutShippingPage;
    Boolean loginElm;
    int districtIdx;
    int rowPrev;
    int columnPrev;
    int rowNext;
    int columnNext;
    String title = "Testing";
    String fname = "Fitrah";
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
        checkoutShippingPage = PageFactory.initElements(driver, CheckoutShippingPage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //loginElm = driver.findElement(By.className("login_menu")) != null;
        //if (loginElm) {
            //homepage.clickLoginMenu();
            //loginPage.doLogin("testing60@bobobobo.com","temanbobo");
            //loginPage.clickLoginButton();
            //System.out.println("Successfully login");
        }


    @Test
    public void checkoutShipping() throws Exception {
        driver.get ("https://www.bobobobo.com/checkout/shipping");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //rowPrev = checkoutShippingPage.rowAddress();
        //columnPrev = checkoutShippingPage.columnAddress();
        //shippingInfoPage.clickAddNewAddress();

        //WebElement modal = (new WebDriverWait(driver, 5))
                //.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-header")));

        int countryIdx = checkoutShippingPage.randomCountry();
        checkoutShippingPage.addNewAddress(title, fname, lname, address, city, countryIdx, postalCode, phone, email);
        if (countryIdx == 0) {
            districtIdx = checkoutShippingPage.randomDistrict();
            checkoutShippingPage.addDistrictByIdx(districtIdx);
            district = checkoutShippingPage.selectedDistrict;
        }
        else {
            district = "Oklahoma";
            checkoutShippingPage.addDistrictByInput(district);
        }
        country = checkoutShippingPage.selectedCountry;
        checkoutShippingPage.clickNextReview();

        // Wait for loading page
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Check if element has been added
        //rowNext = checkoutShippingPage.rowAddress();
        //columnNext = shippingInfoPage.columnAddress();
        //try {
            //assertTrue(rowNext == rowPrev + 1 || columnNext == columnPrev + 1);
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
        //}

        // Assert address title
        //try {
            //assertEquals(title, checkoutShippingPage.checkExistingAddress(rowPrev,columnPrev,1));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        // Assert address user's name
        //try {
            //assertEquals(fname + " " + lname, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,2));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        // Assert address detail
        //try {
            //assertEquals(address, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,3));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        // Assert address city
        //try {
            //assertEquals(city + ", " + district, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,4));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        //// Assert country
        //try {
            //assertEquals(country + ", " + postalCode, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,5));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        // Assert user's phone number
        //try {
            //assertEquals("Phone: " + phone, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,6));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        // Assert user's email
        //try {
            //assertEquals("Email: " + email, shippingInfoPage.checkExistingAddress(rowPrev,columnPrev,7));
        //}
        //catch (Error e) {
            //System.out.println(verificationErrors.append(e.toString()));
            //System.exit(1);
        //}

        //System.out.println("Address added");
    }
    @After
    public void tearDown(){
}
}