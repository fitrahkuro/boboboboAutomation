package Shopping.Cart;

import Shopping.Cart.CheckoutPaymentPage;
import Shopping.Cart.CheckoutShippingPage;
import Shopping.Cart.LoginCheckoutPage;
import Shopping.Cart.CheckoutReviewPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

//for dropdown menu
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


/**
 * Created by fitrah on 9/21/2016.
 */
public class LoginCheckoutTest {
    WebDriver driver;
    LoginCheckoutPage loginPage;
    CheckoutReviewPage checkoutReviewPage;


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


    String code = "TESTSELE";

    String name = "Mochammad Sudharmono";
    String number = "4556330029912707";
    String ccv = "123";
    CheckoutPaymentPage checkoutPaymentPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginCheckoutPage.class);
        checkoutShippingPage = PageFactory.initElements(driver, CheckoutShippingPage.class);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        checkoutReviewPage = PageFactory.initElements(driver, CheckoutReviewPage.class);
        checkoutPaymentPage = PageFactory.initElements(driver, CheckoutPaymentPage.class);

    }

    @Test
    public void login() {
        driver.get("https://www.bobobobo.com/user/login?r=/en/checkout/create");
        loginPage.doLogin("testing60@bobobobo.com", "temanbobo");
        loginPage.clickLoginButton();
        System.out.println("Successfully login");

        int countryIdx = checkoutShippingPage.randomCountry();

        //for adding address
        checkoutShippingPage.addNewAddress(title, fname, lname, address, city, countryIdx, postalCode, phone, email);

        country = checkoutShippingPage.selectedCountry;




        //for select dropdown country
        Select droplist = new Select(driver.findElement(By.id("phoenix_frontend_checkout_shipping_shippingAddress_country")));
        droplist.selectByVisibleText("Indonesia");



        //for select dropdown country
        driver.findElement(By.id("phoenix_frontend_checkout_shipping_shippingAddress_district")).sendKeys("DKI JAKARTA");


        // this method will click same as shipping address
        checkoutShippingPage.clickSameAs();



        // this method will click next to review
        checkoutShippingPage.clickNextReview();

        //for adding promo
        checkoutReviewPage.addNewPromo(code);

        // this method will click apply promo
        checkoutReviewPage.clickApplyPromo();

        // this method will click next to payment
        checkoutReviewPage.clickNextPayment();



        // this method will click cc option
        checkoutPaymentPage.clickCcOption();

        //for adding CC info
        checkoutPaymentPage.addNewCc(name, number, ccv);

        //for select cc expiry month
        driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_month")).sendKeys("5");

        //for select cc expiry year
        driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_year")).sendKeys("2017");


        // this method will click next to payment
        checkoutPaymentPage.clickPayNow();

    }

    @After
    public void tearDown(){
    }
}