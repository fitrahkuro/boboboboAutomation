package Shopping;

import Shopping.Cart.ItemDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;

/**
 * Created by Prima on 8/11/2016.
 */
public class NonEventPage {
    WebDriver driver;

    @FindBy(className = "category_menu_search_icon")
    private WebElement searchIcon;

    @FindBy(css = "#search>input")
    private WebElement searchField;

    @FindBy(css = ".text-uppercase.actived_breadcrumb")
    private WebElement resultField;

    @FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[1]")
    private WebElement whatsNewMenu;

    @FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[8]")
    private WebElement saleMenu;

    @FindBy(css = ".collapsed.sortby-expand")
    private WebElement collapseSortBy;

    @FindBy(className = "shop-brand")
    private WebElement shopBrand;

    @FindBy(className = "shop-name")
    private WebElement shopName;

    @FindBy(className = "shop-price>span")
    private WebElement shopPrice;

    @FindBy(className = "special")
    private WebElement shopPriceDisc;

    // This is a constructor
    public NonEventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will click search icon
    public NonEventPage clickSearchIcon() {
        searchIcon.click();
        return this;
    }

    // This method will put query or keyword to search
    public NonEventPage inputKeyword(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
        searchField.submit();
        return this;
    }

    // This method will click whats new menu
    public NonEventPage whatsNewMenu() {
        whatsNewMenu.click();
        return this;
    }

    // This method will click whats sale menu
    public NonEventPage saleMenu() {
        saleMenu.click();
        return this;
    }

    // This method will click sorting dropdown
    public NonEventPage clickSortingDropdown() {
        collapseSortBy.click();
        return this;
    }

    // This method will click an item to see the details
    public ItemDetailsPage clickItem(int idx) {
        driver.findElement(By.xpath
                (".//*[@class='col-md-9 col-sm-12 prl0 filter_content catalog catalog-shop-list paginated']/div["
                        + idx + "]//*[@class='catalog-info'][2]")).click();
        return new ItemDetailsPage(driver);
    }

    // This method will display searching result
    public String getResultText() {
        return resultField.getText();
    }

    // This method will count xpath for total images in one page
    public int getTotalResult() {
        return driver.findElements(By.xpath(".//*[@id='content']/div/div/div[2]/div[2]/div[2]/script")).size();
    }

    // This method will put product info into array
    public ArrayList getProductInfo(int idx) throws Exception {
        ArrayList arrProduct = new ArrayList();
        String brand = driver.findElement(By.xpath
                (".//*[@class='col-md-9 col-sm-12 prl0 filter_content catalog catalog-shop-list paginated']/div["
                        + idx + "]//*[@class='shop-brand']")).getText();
        String product = driver.findElement(By.xpath
                (".//*[@class='col-md-9 col-sm-12 prl0 filter_content catalog catalog-shop-list paginated']/div["
                        + idx + "]//*[@class='shop-name']")).getText();
        String price;

        try {
            price = driver.findElement(By.xpath
                    (".//*[@class='col-md-9 col-sm-12 prl0 filter_content catalog catalog-shop-list paginated']/div["
                            + idx + "]//*[@class='special'][1]")).getText();
        }
        catch (NoSuchElementException e) {
            price = driver.findElement(By.xpath
                    (".//*[@class='col-md-9 col-sm-12 prl0 filter_content catalog catalog-shop-list paginated']/div["
                            + idx + "]//*[@class='shop-price']")).getText();
        }

        arrProduct.add(brand);
        arrProduct.add(product);
        arrProduct.add(price);

        return arrProduct;
    }

}
