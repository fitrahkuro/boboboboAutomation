package Shopping.Cart;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import java.net.URL;

/**
 * Created by fitrah on 9/22/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({

        CheckoutCartTest.class,
        LoginCheckoutTest.class,
        CheckoutCartTest_chrome.class,
        LoginCheckoutTest_chrome.class
        })
public class CartTestSuite {}
