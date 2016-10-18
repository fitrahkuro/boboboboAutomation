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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
//for dropdown menu
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fitrah on 10/12/2016.
 */
public class PaymentTest_va_chrome {


    WebDriver driver;
    LoginCheckoutPage loginPage;
    CheckoutReviewPage checkoutReviewPage;
    CheckoutPaymentPage checkoutPaymentPage;

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
    String phone = "08111339955";
    String email = "testing60@bobobobo.com";


    String billingfname = "Fitrah";
    String billinglname = "Anshari";
    String billingaddress = "Jalan Gereja Theresia";
    String billingcity = "Jakarta Pusat";
    String billingpostalCode = "99999";
    String billingphone = "08123457890";
    String billingemail = "testing60@bobobobo.com";

    String code = "TESTSELE";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bobobobo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
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
        //for adding shipping address
        checkoutShippingPage.addNewAddress(title, fname, lname, address, city, countryIdx, postalCode, phone, email);
        //for select dropdown country Shipping
        Select droplist = new Select(driver.findElement(By.id("phoenix_frontend_checkout_shipping_shippingAddress_country")));
        droplist.selectByVisibleText("Indonesia");
        //for select dropdown district Shipping
        driver.findElement(By.id("phoenix_frontend_checkout_shipping_shippingAddress_district")).sendKeys("DKI JAKARTA");
        System.out.println("Successfully adding Shipping address");

        //for adding Billing address
        checkoutShippingPage.addNewBilling(billingfname, billinglname, billingaddress, billingcity, billingpostalCode, billingphone, billingemail);
        //for select dropdown country Billing
        driver.findElement(By.id("phoenix_frontend_checkout_shipping_billingAddress_country")).sendKeys("Indonesia");
        //for select dropdown district Billing
        driver.findElement(By.id("phoenix_frontend_checkout_shipping_billingAddress_district")).sendKeys("DEPOK");
        System.out.println("Successfully adding Billing address");

        // this method will click same as shipping address
        //checkoutShippingPage.clickSameAs();

        // this method will click next to review button
        checkoutShippingPage.clickNextReview();


        // REVIEW PAGE
        //for change item quantity
        driver.findElement(By.className("checkout-item-quantity")).sendKeys("1");
        System.out.println("Quantity changed");

        //for adding promo code
        checkoutReviewPage.addNewPromo(code);

        // this method will click apply promo button
        checkoutReviewPage.clickApplyPromo();
        System.out.println("Promo Code Added");

        // this method will click next to payment button
        checkoutReviewPage.clickNextPayment();


        // PAYMENT PAGE

        // this method will click bank transfer
        checkoutPaymentPage.clickVirtualPayment();
        System.out.println("Virtual Payment Selected");


        // this method will click next to payment button
        checkoutPaymentPage.clickPayNow();
        System.out.println("payment succesfully done");
    }

    @After
    public void tearDown () {
    }
}



