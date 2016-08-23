package UserManagement.Auth;

import Shopping.*;
import UserManagement.MyProfile.AccountDetailsPage;
import UserManagement.MyShippingInfo.ShippingInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Prima on 7/20/2016.
 */

public class Homepage {
    WebDriver driver;

    @FindBy(className = "login_menu")
    private WebElement loginMenu;

    @FindBy(id = "profile_menu")
    private WebElement userProfileDropdown;

    @FindBy(css = "a[href*='logout']")
    private WebElement logoutMenu;

    @FindBy(css = ".user_profile>li>a[href*='/user/profile']")
    private WebElement myProfileMenu;

    @FindBy(css = "a[href*='shipping']")
    private WebElement myShippingInfoMenu;

    @FindBy(css = "a[href*='orders']")
    private WebElement myOrdersMenu;

    @FindBy(css = "a[href*='returns']")
    private WebElement myReturnsMenu;

    @FindBy(css = "a[href*='wishlist']")
    private WebElement myWishlistMenu;

    @FindBy(id = "womens_category")
    private WebElement womenCategory;

    @FindBy(id = "mens_category")
    private WebElement menCategory;

    @FindBy(id = "living_category")
    private WebElement livingCategory;

    @FindBy(id = "dining_category")
    private WebElement eatsCategory;

    @FindBy(id = "travel_category")
    private WebElement travelCategory;

    @FindBy(id = "events_category")
    private WebElement eventsCategory;

    @FindBy(id = "desk_cart-menu")
    private WebElement deskCartMenu;

    // This is a constructor
    public Homepage(WebDriver driver) {
        this.driver = driver;
        //driver.get("https://pre-release.bobobobo.com");
        driver.get("http://www.bobobobo.com/");
        PageFactory.initElements(driver, this);
    }

    // This method will click log in menu
    public Homepage clickLoginMenu() {
        loginMenu.click();
        return this;
    }

    // This method will click user menu dropdown
    public Homepage clickUserMenu() {
        userProfileDropdown.click();
        return this;
    }

    // This method will click log out menu from dropdown
    public Homepage clickLogoutMenu() {
        logoutMenu.click();
        System.out.println("Log out. Bye!");
        return this;
    }

    // This method will click Account Details menu from dropdown
    public AccountDetailsPage clickAccountDetailsMenu() {
        myProfileMenu.click();
        System.out.println("Go to account details page");
        return new AccountDetailsPage(driver);
    }

    // This method will click My Shipping menu from dropdown
    public ShippingInfoPage clickMyShippingMenu() {
        myShippingInfoMenu.click();
        return new ShippingInfoPage(driver);
    }

    // This method will click My Orders menu from dropdown
    public AccountDetailsPage clickMyOrdersMenu() {
        myOrdersMenu.click();
        return new AccountDetailsPage(driver);
    }

    // This method will click My Wishlist menu
    public AccountDetailsPage clickWishlistMenu() {
        myWishlistMenu.click();
        return new AccountDetailsPage(driver);
    }

    // This method will click women category page
    public WomenPage clickWomenCategory() {
        womenCategory.click();
        return new WomenPage(driver);
    }

    // This method will click men category page
    public MenPage clickMenCategory() {
        menCategory.click();
        return new MenPage(driver);
    }

    // This method will click living category page
    public LivingPage clickLivingCategory() {
        livingCategory.click();
        return new LivingPage(driver);
    }

    // This method will click eats category page
    public EatsPage clickEatsCategory() {
        eatsCategory.click();
        return new EatsPage(driver);
    }

    // This method will click travel category page
    public TravelPage clickTravelCategory() {
        travelCategory.click();
        return new TravelPage(driver);
    }

    // This method will click women category page
    public EventsPage clickEventsCategory() {
        eventsCategory.click();
        return new EventsPage(driver);
    }

}
