package Shopping.Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fitrah on 9/26/2016.
 */
public class CheckoutPaymentPage {
    WebDriver driver;


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

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_info_CC_expiry_month")
    private WebElement ccMonth;

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_info_CC_expiry_year")
    private WebElement ccYear;

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_info_CC_security_code")
    private WebElement ccCcv;


    @FindBy(id = "phoenix_frontend_checkout_payment_payment_identifier_0")
    private WebElement ccOption;

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_identifier_1")
    private WebElement virtualPayment;

    @FindBy (id = "phoenix_frontend_checkout_payment_payment_identifier_2")
    private WebElement bankTransfer;

    @FindBy(css = "input[type='submit']")
    private WebElement payNow;

    //@FindBy(id = "PaRes")
    //private WebElement payPass;

    //@FindBy(className = "test")
    //private WebElement payOk;


    //This is constructor
    public CheckoutPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    // This method will click Credit Card Option
    public CheckoutPaymentPage clickCcOption() {
        ccOption.click();
        return this;
    }

    // This method will put data Credit card info
    public CheckoutPaymentPage addNewCc(String name, String number, String ccv ) {

        // input address Credit card name , number and Ccv
        ccName.clear();
        ccName.sendKeys(name);
        ccNumber.clear();
        ccNumber.sendKeys(number);
        ccCcv.clear();
        ccCcv.sendKeys(ccv);
        return this;
    }

    // This method will click Virtual Payment Option
    public CheckoutPaymentPage clickVirtualPayment () {
        virtualPayment.click();
        return this;
    }

    // This method will click Bank Transfer Option
    public CheckoutPaymentPage clickBankTransfer() {
        bankTransfer.click();
        return this;
    }

    // This method will click Pay Now
    public CheckoutPaymentPage clickPayNow() {
        payNow.click();
        return this;
    }

    // This method will put 3ds data
    //public CheckoutPaymentPage addNewPay(String pass) {
        //payPass.clear();
        //payPass.sendKeys(pass);
        //return this;
    //}

    // This method will click OK in 3ds screen
    //public CheckoutPaymentPage clickPayOk() {
        //payOk.click();
        //return this;
    //}
}
