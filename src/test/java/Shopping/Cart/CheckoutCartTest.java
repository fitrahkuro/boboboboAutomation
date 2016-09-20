package Shopping.Cart;


import Shopping.NonEventPage;
import UserManagement.Auth.Homepage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fitrah on 9/20/2016.
 */


public class CheckoutCartTest {
    WebDriver driver;
    Homepage homepage;
    NonEventPage searching;
    ItemDetailsPage item;
    int categoryIdx;
    String brand;
    String product;
    int price;

}
