package UserManagement.MyProfile;

import UserManagement.MyShippingInfo.ShippingInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.SystemClock;

import java.util.List;

/**
 * Created by Prima on 8/7/2016.
 */
public class AccountDetailsPage {
    WebDriver driver;
    int randomIdx;

    @FindBy(css = "a[href*='profile']")
    private WebElement myProfileMenu;

    @FindBy(css = "a[href*='shipping']")
    private WebElement myShippingInfoMenu;

    @FindBy(css = "a[href*='orders']")
    private WebElement myOrdersMenu;

    @FindBy(css = "a[href*='returns']")
    private WebElement myReturnsMenu;

    @FindBy(css = "a[href*='wishlist']")
    private WebElement myWishlistMenu;

    @FindBy(xpath = ".//*[@id='phoenix_frontend_user_profile_title']")
    private WebElement userTitle;

    @FindBy(id = "phoenix_frontend_user_profile_firstName")
    private WebElement userFname;

    @FindBy(id = "phoenix_frontend_user_profile_lastName")
    private WebElement userLname;

    @FindBy(id = "phoenix_frontend_user_profile_email")
    private WebElement userEmail;

    @FindBy(id = "phoenix_frontend_user_profile_phoneNumber")
    private WebElement userPhoneNumber;

    @FindBy(id = "phoenix_frontend_user_profile_birthdate_day")
    private WebElement userBdateDay;

    @FindBy(id = "phoenix_frontend_user_profile_birthdate_month")
    private WebElement userBdateMonth;

    @FindBy(id = "phoenix_frontend_user_profile_birthdate_year")
    private WebElement userBdateYear;

    @FindBy(id = "phoenix_frontend_user_profile_country")
    private WebElement userCountry;

    @FindBy(id = "phoenix_frontend_user_profile_indonesian")
    private WebElement userIndonesian;

    @FindBy(xpath = ".//*[@id='myaccount-profile']/form[2]/div[1]/font")
    private WebElement editProfileMsg;

    @FindBy(id = "phoenix_frontend_user_change_password_oldPassword")
    private WebElement userOldPassword;

    @FindBy(id = "phoenix_frontend_user_change_password_newPassword_first")
    private WebElement userNewPasswordFisrt;

    @FindBy(id = "phoenix_frontend_user_change_password_newPassword_second")
    private WebElement userNewPasswordSecond;

    @FindBy(xpath = ".//*[@id='myaccount-profile']/form[1]/ul/li/input")
    private WebElement saveEditProfileButton;

    @FindBy(xpath = ".//*[@id='myaccount-profile']/form[2]/ul/li/input")
    private WebElement saveChangePassButton;

    // This is a constructor
    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will click My Profile menu
    public AccountDetailsPage clickMyProfile() {
        myProfileMenu.click();
        return this;
    }

    // This method will click My Shipping Info menu
    public ShippingInfoPage clickMyShippingInfo() {
        myShippingInfoMenu.click();
        return new ShippingInfoPage(driver);
    }

    // This method will click My Orders menu
    public AccountDetailsPage clickMyOrders() {
        myOrdersMenu.click();
        return this;
    }

    // This method will click My Returns menu
    public AccountDetailsPage clickMyReturns() {
        myReturnsMenu.click();
        return this;
    }

    // This method will click My Wishlist menu
    public AccountDetailsPage clickMyWishlist() {
        myWishlistMenu.click();
        return this;
    }

    // This method will edit your current profile
    public AccountDetailsPage editCurentProfile(int titleIdx, String fname, String lname, String email,
                                                String telephone, int bddateIdx, int bdmonthIdx, int bdyearIdx,
                                                int countryIdx, int indonesianIdx) {
        // select title
        Select selectTitleIdx = new Select(userTitle);
        selectTitleIdx.selectByIndex(titleIdx);
        // Input first name
        userFname.clear();
        userFname.sendKeys(fname);
        // Input last name
        userLname.clear();
        userLname.sendKeys(lname);
        // Input email
        userEmail.clear();
        userEmail.sendKeys(email);
        // Input phone number
        userPhoneNumber.clear();
        userPhoneNumber.sendKeys(telephone);
        // select birth date day
        Select selectDayIdx = new Select(userBdateDay);
        selectDayIdx.selectByIndex(bddateIdx);
        // select birth date month
        Select selectMonthIdx = new Select(userBdateMonth);
        selectMonthIdx.selectByIndex(bdmonthIdx);
        // select birth date year
        Select selectYearIdx = new Select(userBdateYear);
        selectYearIdx.selectByIndex(bdyearIdx);
        // select country
        Select selectCountryIdx = new Select(userCountry);
        selectCountryIdx.selectByIndex(countryIdx);
        // select Indonesian or not option
        Select selectIndIdx = new Select(userIndonesian);
        selectIndIdx.selectByIndex(indonesianIdx);

        saveEditProfileButton.click();

        return this;
    }

    // This method will get text after saving from edit profil
    public String getEditProfileMsg() {
        return editProfileMsg.getText();
    }

    // This method will change your current password
    public AccountDetailsPage changeCurrentPassword(String oldPass, String fNewPass, String sNewPass) {
        userOldPassword.sendKeys(oldPass);
        userNewPasswordFisrt.sendKeys(fNewPass);
        userNewPasswordSecond.sendKeys(sNewPass);

        saveChangePassButton.click();
        return this;
    }

    // This method will generate index number for title
    // return int
    public int randomTitle() {
        List<WebElement> userTitleOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_profile_title>option"));
        randomIdx = (int) Math.ceil(Math.random()* (userTitleOption.size() - 1 ));
        return randomIdx;
    }

    // This method will generate index number for birth date day
    // return int
    public int randomDay() {
        List<WebElement> dayOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_profile_birthdate_day>option"));
        randomIdx = (int) Math.ceil(Math.random()* (dayOption.size() - 1 ));
        return randomIdx;
    }

    // This method will generate index number for birth date month
    // return int
    public int randomMonth() {
        List<WebElement> monthOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_profile_birthdate_month>option"));
        randomIdx = (int) Math.ceil(Math.random()* (monthOption.size() - 1 ));
        return randomIdx;
    }

    // This method will generate index number for birth date year
    // return int
    public int randomYear() {
        List<WebElement> yearOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_profile_birthdate_year>option"));
        randomIdx = (int) Math.ceil(Math.random()* (yearOption.size() - 1 ));
        return randomIdx;
    }

    // This method will generate index number for country
    // return int
    public int randomCountry() {
        List<WebElement> countryOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_profile_country>option"));
        randomIdx = (int) Math.ceil(Math.random()* (countryOption.size() - 1 ));
        if (randomIdx == 2) {
            randomIdx++;
        }
        return randomIdx;
    }

    // This method will generate index number for Indonesia citizen
    // return int
    public int randomInd() {
        List<WebElement> indOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_profile_indonesian>option"));
        randomIdx = (int) Math.ceil(Math.random()* (indOption.size() - 1 ));
        return randomIdx;
    }
}
