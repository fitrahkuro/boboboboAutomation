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

    //for production
    //String name = "Mochammad Sudharmono";
    //String number = "4556330029912707";
    //String ccv = "123";

    //for pre-release
    String name = "Test Fitrah";
    String number = "4811111111111114";
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
        driver.get("https://pre-release.bobobobo.com/user/login?r=/en/checkout/create");
        //driver.get("https://bobobobo.com/user/login?r=/en/checkout/create");
        loginPage.doLogin("testing60@bobobobo.com", "temanbobo");
        loginPage.clickLoginButton();
        System.out.println("Successfully login");

        int countryIdx = checkoutShippingPage.randomCountry();


        // SHIPPING PAGE
        //for adding address
        checkoutShippingPage.addNewAddress(title, fname, lname, address, city, countryIdx, postalCode, phone, email);
        System.out.println("Successfully adding shipping address");

        //for select dropdown country
        Select droplist = new Select(driver.findElement(By.id("phoenix_frontend_checkout_shipping_shippingAddress_country")));
        droplist.selectByVisibleText("Indonesia");

        //for select dropdown country
        driver.findElement(By.id("phoenix_frontend_checkout_shipping_shippingAddress_district")).sendKeys("DKI JAKARTA");

        // this method will click same as shipping address
        checkoutShippingPage.clickSameAs();

        // this method will click next to review button
        checkoutShippingPage.clickNextReview();


        // REVIEW PAGE
        //for change item quantity
        driver.findElement(By.className("checkout-item-quantity")).sendKeys("2");
        System.out.println("Quantity changed");

        //for adding promo code
        checkoutReviewPage.addNewPromo(code);

        // this method will click apply promo button
        checkoutReviewPage.clickApplyPromo();
        System.out.println("Promo Code Added");

        // this method will click next to payment button
        checkoutReviewPage.clickNextPayment();


        // PAYMENT PAGE
        // this method will click cc option
        checkoutPaymentPage.clickCcOption();

        //for adding CC info
        checkoutPaymentPage.addNewCc(name, number, ccv);
        System.out.println("CC info add succesfully");

        //for select cc expiry month
        //driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_month")).sendKeys("5");

        // pre-release veritrans cc expiry month
        driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_month")).sendKeys("1");

        //for select cc expiry year
        //driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_year")).sendKeys("2017");

        //pre-release veritrans cc expiry month
        driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_year")).sendKeys("2020");

        // this method will click next to payment button
        checkoutPaymentPage.clickPayNow();
        System.out.println("payment succesfully done");
    }

    @After
    public void tearDown(){
    }
}