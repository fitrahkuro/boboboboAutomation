package Shopping.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Shopping.Cart.CheckoutReviewPage;





/**
 * Created by bobobobo on 9/23/2016.
 */
public class CheckoutReviewTest {

    WebDriver driver;

    CheckoutReviewPage checkoutReviewPage;


    String code = "TESTSELE";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        checkoutReviewPage = PageFactory.initElements(driver, CheckoutReviewPage.class);
    }

    @Test
    public void checkoutReview() {

        driver.get("https://www.bobobobo.com/en/checkout/review");


        //for change item quantity
        driver.findElement(By.className("checkout-item-quantity")).sendKeys("2");
        System.out.println("Quantity changed");

        //for adding promo
        checkoutReviewPage.addNewPromo(code);

        // this method will click apply promo
        checkoutReviewPage.clickApplyPromo();

        // this method will click next to payment
        checkoutReviewPage.clickNextPayment();
    }
}