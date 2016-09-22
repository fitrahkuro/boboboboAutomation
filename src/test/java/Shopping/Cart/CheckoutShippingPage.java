package Shopping.Cart;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Fitrah on 9/22/2016.
 */

public class CheckoutShippingPage {
    WebDriver driver;
    int randomIdx;
    public String selectedCountry;
    public String selectedDistrict;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_title")
    private WebElement addressTitle;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_firstName")
    private WebElement addressFName;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_lastName")
    private WebElement addressLName;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_address")
    private WebElement addressDetail;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_city")
    private WebElement addressCity;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_country")
    private WebElement addressCountry;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_postalCode")
    private WebElement addressPostalCode;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_district")
    private WebElement addressDistrict;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_districtInternational")
    private WebElement addressDistrictInt;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_phoneNumber")
    private WebElement addressPhone;

    @FindBy(id = "phoenix_frontend_checkout_shipping_shippingAddress_email")
    private WebElement addressEmail;

    @FindBy(id = "phoenix_frontend_checkout_shipping_same_shipping")
    private WebElement sameAs;

    @FindBy(css = "input[type='submit']")
    private WebElement nextReview;

    //This is constructor
    public CheckoutShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // This method will put data to new address form
    public CheckoutShippingPage addNewAddress(String title, String fname, String lname, String address, String city,
                                              int country, String postalCode, String phone, String email) {

        // input address title, first name, last name, and detail
        addressTitle.clear();
        addressTitle.sendKeys(title);
        addressFName.clear();
        addressFName.sendKeys(fname);
        addressLName.clear();
        addressLName.sendKeys(lname);
        addressDetail.clear();
        addressDetail.sendKeys(address);
        addressCity.clear();
        addressCity.sendKeys(city);
        // select country
        Select selectCountryIdx = new Select(addressCountry);
        selectCountryIdx.selectByIndex(country);
        selectedCountry = selectCountryIdx.getFirstSelectedOption().getText();
        // input postal code
        addressPostalCode.clear();
        addressPostalCode.sendKeys(postalCode);
        // input phone number and email address
        addressPhone.clear();
        addressPhone.sendKeys(phone);
        addressEmail.clear();
        addressEmail.sendKeys(email);
        return this;
    }

    // This method will add district if the country selected is Indonesia
    // masih salah
    public CheckoutShippingPage addDistrictByIdx(int district) {
        // select district
        Select selectDistrictIdx = new Select(addressDistrict);
        selectDistrictIdx.selectByIndex(district);
        selectedDistrict = selectDistrictIdx.getFirstSelectedOption().getText();
        return this;
    }

    // This method will add district if the country selected is non-Indonesia
    //masih salah
    public CheckoutShippingPage addDistrictByInput(String district) {
        addressDistrictInt.clear();
        addressDistrictInt.sendKeys(district);
        return this;
    }

    // This method will click Same as Shipping Address
    public CheckoutShippingPage clickSameAs() {
        sameAs.click();
        return this;
    }

    // This method will click Next To Review
    public CheckoutShippingPage clickNextReview() {
        nextReview.click();
        return this;
    }

    // This method will generate index number for country
    // return int
    public int randomCountry() {
        List<WebElement> countryOption = driver.findElements(By.cssSelector("#phoenix_frontend_checkout_shipping_ShippingAddress_country>option"));
        randomIdx = (int) Math.ceil(Math.random()* (countryOption.size() - 1 ));
        if (randomIdx == 1) {
            randomIdx++;
        }
        return randomIdx;
    }

    // This method will generate index number for district
    // return int
    public int randomDistrict() {
        List<WebElement> districtOption = driver.findElements(By.cssSelector("#phoenix_frontend_checkout_shipping_ShippingAddress_district>option"));
        randomIdx = (int) Math.ceil(Math.random()* (districtOption.size() - 1 ));
        return randomIdx;
    }
}