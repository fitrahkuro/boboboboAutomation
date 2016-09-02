package UserManagement.MyShippingInfo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Prima on 8/9/2016.
 */
public class ShippingInfoPage {
    WebDriver driver;
    int randomIdx;
    public String selectedCountry;
    public String selectedDistrict;

    @FindBy(id = "user-address-create")
    private WebElement createAddressButton;

    @FindBy(className = "user-address-delete")
    public WebElement deleteAddressButton;

    @FindBy(className = "user-address-edit")
    public WebElement editAddressButton;

    @FindBy(id = "phoenix_frontend_user_address_title")
    private WebElement addressTitle;

    @FindBy(id = "phoenix_frontend_user_address_firstName")
    private WebElement addressFName;

    @FindBy(id = "phoenix_frontend_user_address_lastName")
    private WebElement addressLName;

    @FindBy(id = "phoenix_frontend_user_address_address")
    private WebElement addressDetail;

    @FindBy(id = "phoenix_frontend_user_address_city")
    private WebElement addressCity;

    @FindBy(id = "phoenix_frontend_user_address_country")
    private WebElement addressCountry;

    @FindBy(id = "phoenix_frontend_user_address_postalCode")
    private WebElement addressPostalCode;

    @FindBy(id = "phoenix_frontend_user_address_district")
    private WebElement addressDistrict;

    @FindBy(id = "phoenix_frontend_user_address_districtInternational")
    private WebElement addressDistrictInt;

    @FindBy(id = "phoenix_frontend_user_address_phoneNumber")
    private WebElement addressPhone;

    @FindBy(id = "phoenix_frontend_user_address_email")
    private WebElement addressEmail;

    @FindBy(className = "create-shipping-form-submit")
    private WebElement saveFormButton;

    @FindBy(className = "edit-shipping-form-submit")
    private WebElement editFormButton;

    // This is a constructor
    public ShippingInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will click add new address button
    public ShippingInfoPage clickAddNewAddress() {
        createAddressButton.click();
        return this;
    }

    // This method will put data to new address form
    public ShippingInfoPage addNewAddress(String title, String fname, String lname, String address, String city,
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
    public ShippingInfoPage addDistrictByIdx(int district) {
        // select district
        Select selectDistrictIdx = new Select(addressDistrict);
        selectDistrictIdx.selectByIndex(district);
        selectedDistrict = selectDistrictIdx.getFirstSelectedOption().getText();
        return this;
    }

    // This method will add district if the country selected is non-Indonesia
    public ShippingInfoPage addDistrictByInput(String district) {
        addressDistrictInt.clear();
        addressDistrictInt.sendKeys(district);
        return this;
    }

    // This method will click save button to add a new address
    public ShippingInfoPage clickSubmitForm() {
        saveFormButton.click();
        return this;
    }

    // This method will click delete button
    public ShippingInfoPage clickDeteleButton() {
        deleteAddressButton.click();
        return this;
    }

    // This method will click edit button
    public ShippingInfoPage clickEditButton() {
        editAddressButton.click();
        return this;
    }

    // This method will click save button on editing form
    public ShippingInfoPage clickSubmitFormEdit() {
        editFormButton.click();
        return this;
    }

    // This method will check for the last row and column after adding an address
    public String checkExistingAddress(int row, int column, int content) {
        WebElement element = driver.findElement(By.xpath(".//*[@class='myaccount-column']/ul[" + row + "]/li["
                + column + "]/p[" + content + "]"));
        return element.getText();
    }

    // This method will generate index number for country
    // return int
    public int randomCountry() {
        List<WebElement> countryOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_address_country>option"));
        randomIdx = (int) Math.ceil(Math.random()* (countryOption.size() - 1 ));
        if (randomIdx == 1) {
            randomIdx++;
        }
        return randomIdx;
    }

    // This method will generate index number for district
    // return int
    public int randomDistrict() {
        List<WebElement> districtOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_address_district>option"));
        randomIdx = (int) Math.ceil(Math.random()* (districtOption.size() - 1 ));
        return randomIdx;
    }

    // This method will count rows of existing address
    public int rowAddress() {
        List<WebElement> row = driver.findElements(By.cssSelector(".myaccount-column>ul"));
        return row.size();
    }

    // This method will count columns of existing address
    public int columnAddress() {
        int row = rowAddress();
        List<WebElement> column = driver.findElements(By.xpath(".//*[@class='myaccount-column']/ul[" + row + "]/li"));
        return column.size();
    }
}
