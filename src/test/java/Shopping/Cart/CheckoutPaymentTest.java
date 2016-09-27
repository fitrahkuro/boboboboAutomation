package Shopping.Cart;


import Shopping.Cart.CheckoutPaymentPage;
import org.apache.bcel.generic.NEW;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * Created by bobobobo on 9/27/2016.
 */
public class CheckoutPaymentTest {

    WebDriver driver;
    CheckoutPaymentPage checkoutPaymentPage;

    String name = "test";
    String number = "1234";
    String ccv = "123";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        checkoutPaymentPage = PageFactory.initElements(driver, CheckoutPaymentPage.class);
    }



    @Test
    public void payment (){


        // this method will click cc option
        checkoutPaymentPage.clickCcOption();

        //for adding CC info
        checkoutPaymentPage.addNewCc(name, number, ccv);

        //for select cc expiry month
        driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_month")).sendKeys("  ");

        //for select cc expiry year
        driver.findElement(By.id("phoenix_frontend_checkout_payment_payment_info_CC_expiry_year")).sendKeys("2020");


        // this method will click next to payment
        checkoutPaymentPage.clickPayNow();

    }


    @After
    public void tearDown(){
    }
}