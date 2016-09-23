package Shopping.Cart;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by bobobobo on 9/23/2016.
 */

public class CheckoutReviewPage {

    WebDriver driver;

    @FindBy(className = "checkout-review-shop-item")
    private WebElement itemList;

    @FindBy(className = "checkout-item-quantity")
    private WebElement itemQty;

    @FindBy(className = "subtotal-checkout-review text-right pr24")
    private WebElement itemSub;

    @FindBy(id = "checkout_promo_code")
    private WebElement promoCode;

    @FindBy(className = "checkout-apply-promocode pull-right pr24")
    private WebElement applyPromo;

    @FindBy(className = "text-right pr24")
    private WebElement itemTotal;

    @FindBy(id = "checkout-review-button")
    private WebElement nextPayment;


    //This is constructor
    public CheckoutReviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
