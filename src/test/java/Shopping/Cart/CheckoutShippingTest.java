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
    WebDriver driver;

    private StringBuffer verificationErrors = new StringBuffer();
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
        //driver = new FirefoxDriver();
        checkoutShippingPage = PageFactory.initElements(driver, CheckoutShippingPage.class);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void checkoutShipping() throws Exception {
        //driver.get("https://www.bobobobo.com/checkout/shipping");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //int countryIdx = checkoutShippingPage.randomCountry();
        int countryIdx = 10;
        checkoutShippingPage.addNewAddress(title, fname, lname, address, city, countryIdx, postalCode, phone, email);
        if (countryIdx == 0) {
            districtIdx = checkoutShippingPage.randomDistrict();
            checkoutShippingPage.addDistrictByIdx(districtIdx);
            district = checkoutShippingPage.selectedDistrict;
        } else {
            district = "Oklahoma";
            checkoutShippingPage.addDistrictByInput(district);
        }
        country = checkoutShippingPage.selectedCountry;
        checkoutShippingPage.clickNextReview();

        // Wait for loading page
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
        @After
            public void tearDown (){
        }
    }