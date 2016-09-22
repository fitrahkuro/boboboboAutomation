package Shopping.Cart;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


/**
 * Created by fitrah on 9/22/2016.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
        //CheckoutCartTest.class,
        LoginCheckoutTest.class,
        CheckoutShippingTest.class
        })
public class CartTestSuite {}
