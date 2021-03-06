package Shopping.Cart;



import Shopping.NonEventPage;
import UserManagement.Auth.Homepage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Prima on 8/11/2016.
 */
public class AddCartShopTest {
    WebDriver driver;
    Homepage homepage;
    NonEventPage searching;
    ItemDetailsPage item;
    int categoryIdx;
    String brand;
    String product;
    int price;
    LoginCheckoutPage loginPage;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        homepage = PageFactory.initElements(driver, Homepage.class);
        searching = PageFactory.initElements(driver, NonEventPage.class);
        item = PageFactory.initElements(driver, ItemDetailsPage.class);
        loginPage = PageFactory.initElements(driver, LoginCheckoutPage.class);

        ArrayList<String> arrCategory = new ArrayList(Arrays.asList("women"));
        categoryIdx = (int) Math.floor(Math.random() * arrCategory.size());

        // Check to redirect page to selected category
        if (arrCategory.get(categoryIdx).equalsIgnoreCase("women")) {
            homepage.clickWomenCategory();
        }
        //else if (arrCategory.get(categoryIdx).equalsIgnoreCase("men")) {
            //homepage.clickMenCategory();
        //}
        //else if (arrCategory.get(categoryIdx).equalsIgnoreCase("living")) {
            //homepage.clickLivingCategory();
        //}

        searching.saleMenu();
    }

    @Test
    public void addCartShop() throws Exception {
        // save product info
        int opt;
        int totalPrice;
        int property;
        int total = searching.getTotalResult();
        ArrayList<String> temp;

        // Looping for clicking an available item
        for (int i = 1; i <= total; i++) {
            temp = searching.getProductInfo(i);
            brand = temp.get(0);
            product = temp.get(1);
            price = Integer.parseInt(temp.get(2).replaceFirst(".*?(\\d+)", "$1").replaceAll(",",""));
            searching.clickItem(i);

            try {
                assertTrue(driver.getTitle().contains("Sorry"));
                continue;
            }
            catch (Error e) {
                System.out.println("Page is valid");
                break;
            }
        }

        // check item
        try {
            item.isItemMatched(brand, product, price);
        }
        catch (Error e) {
            System.out.println("Item's details are not matched");
            System.exit(1);
        }
        property = item.productProperty();

        // looping for property in each variety or property
        for (int j = 1; j <= property; j++) {
            item.propertyOption(j);
        }
        opt = item.optionAmount();

        // get array size
        item.getPropertyArr(property, opt);

        // select index recursively
        item.findProperty(0, 0);

        // check if total price has been shown up
        totalPrice = item.getTotalPrice();

        //check if total price is matched
        try {
            if (item.getQuantity() * price == totalPrice) {
                System.out.println("Price is matched");
            }
        }
        catch (Error e) {
            System.out.println("Price is not matched");
            System.exit(1);
        }

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


    }

    @After
    public void tearDown() {

    }
}
