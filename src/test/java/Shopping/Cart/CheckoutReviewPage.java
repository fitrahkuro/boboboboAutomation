package Shopping.Cart;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Fitrah on 9/23/2016.
 */

public class CheckoutReviewPage {

    WebDriver driver;

    @FindBy(className = "checkout-review-shop-item")
    private WebElement itemList;

    @FindBy(className = "checkout-item-quantity")
    private WebElement itemQty;

    @FindBy(className = "subtotal-checkout-review")
    private WebElement itemSub;

    // promo code box
    @FindBy(id = "checkout_promo_code")
    private WebElement promoCode;

    //promo code apply button
    @FindBy(className = "checkout-apply-promo-code")
    private WebElement applyPromo;

    //@FindBy(className = "checkout")
    //private WebElement itemTotal;

    @FindBy(id = "checkout-review-button")
    private WebElement nextPayment;


    //This is constructor
    public CheckoutReviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will add promo code
    public CheckoutReviewPage addNewPromo(String code) {
        promoCode.clear();
        promoCode.sendKeys(code);
        return this;
    }

    // This method will click Apply promo
    public CheckoutReviewPage clickApplyPromo() {
        applyPromo.click();
        return this;
    }

    // This method will click Next to payment
    public CheckoutReviewPage clickNextPayment() {
        nextPayment.click();
        return this;
    }
}
