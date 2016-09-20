package Shopping.Cart;

import Shopping.NonEventPage;
import UserManagement.Auth.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




/**
 * Created by fitrah on 9/20/2016.
 */



public class CheckoutCart {
    WebDriver driver;
    Homepage homepage;
    NonEventPage searching;
    ItemDetailsPage item;
    int categoryIdx;
    String brand;
    String product;
    int price;

}
