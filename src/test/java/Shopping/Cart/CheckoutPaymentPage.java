package Shopping.Cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Fitrah on 9/26/2016.
 */
public class CheckoutPaymentPage {
    @FindBy(id = "phoenix_frontend_checkout_payment_payment_identifier_0")
    private WebElement ccOption;

    @FindBy (name = "phoenix_frontend_checkout_payment")
    private WebElement orderSummary;

    @FindBy (className = "checkout_review_button")
    private WebElement subTotal;

    @FindBy (className = "checkout-review-button-total")
    private WebElement totalPrice;

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_info_CC_name")
    private WebElement ccName;

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_info_CC_number")
    private WebElement ccNumber;


}
