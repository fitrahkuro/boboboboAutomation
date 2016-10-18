package Shopping.Cart;


import Shopping.NonEventPage;
import UserManagement.Auth.Homepage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import Shopping.Cart.ItemDetailsPage;

/**
 * Created by bobobobo on 10/3/2016.
 */
public class CheckoutCartTest_prod_chrome {
    WebDriver driver;
    ItemDetailsPage item;
    NonEventPage searching;
    int categoryIdx;
    String brand;
    String product;
    int price;
    LoginCheckoutPage loginPage;


    @Before
    public void setUp() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bobobobo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.bobobobo.com/product/riris-testing/testing-riris");
        searching = PageFactory.initElements(driver, NonEventPage.class);

    }

    @Test
    public void addCartShop() throws Exception {
        int totalPrice;
        driver.findElement(By.name("varieties[1]")).sendKeys("S");
        driver.findElement(By.name("varieties[2]")).sendKeys("Butter");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // This method will automatically get quantity
        //public int getQuantity() {
            //Select selectQty = new Select(stockQty);
            //String qty = selectQty.getFirstSelectedOption().getText();
            //return Integer.parseInt(qty);


        driver.findElement(By.className("stock-quantity-select")).sendKeys("2");



        // click add to cart button
        try {
            item.clickCartButton();
        }
        catch (Error e) {
            System.out.println("Add to Cart button can not be clicked");
            System.exit(1);
        }

        item.getScript();

        System.out.println("Done");


        // click cart button
        driver.findElement(By.id("cart-counter")).click();

        //click proceed to checkout
        driver.findElement(By.id("cart-checkout-button")).click();

        // for login
        loginPage.doLogin("testing60@bobobobo.com", "temanbobo");
        loginPage.clickLoginButton();
        System.out.println("Successfully login");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
    }
}



