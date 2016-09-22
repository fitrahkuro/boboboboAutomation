package Shopping.Cart;

import Shopping.Cart.CheckoutShippingPage;
import Shopping.Cart.LoginCheckoutPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


/**
 * Created by fitrah on 9/21/2016.
 */
public class LoginCheckoutTest {
    WebDriver driver;
    LoginCheckoutPage loginPage;


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
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginCheckoutPage.class);
        checkoutShippingPage = PageFactory.initElements(driver, CheckoutShippingPage.class);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void login() {
        driver.get("https://www.bobobobo.com/user/login?r=/en/checkout/create");
        loginPage.doLogin("testing60@bobobobo.com", "temanbobo");
        loginPage.clickLoginButton();
        System.out.println("Successfully login");

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

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // this method will click same as shipping address
        checkoutShippingPage.clickSameAs();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // this method will click next to review
        checkoutShippingPage.clickNextReview();
    }

    @After
    public void tearDown(){
    }
}