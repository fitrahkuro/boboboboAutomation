package Shopping.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prima on 8/12/2016.
 */
public class ItemDetailsPage {
    WebDriver driver;
    List<WebElement> propertyOpt = new ArrayList<WebElement>();
    boolean[][] selected;

    @FindBy(css = ".content-title-text>a")
    private WebElement brandName;

    @FindBy(className = "product-name")
    private WebElement productName;

    @FindBy(css = ".attribute-content")
    private WebElement normalPrice;

    @FindBy(xpath = ".//*[@class='attribute-content']//*[@class='specials']")
    private WebElement discountPrice;

    @FindBy(id = "stockQuantity")
    private WebElement stockQty;

    @FindBy(css = ".product-total-price")
    private WebElement totalPrice;

    @FindBy(css = ".add-to-cart-button")
    private WebElement cartButton;

    @FindBy(css = ".add-to-cart-button.disabled")
    private WebElement cartDisableButton;

    @FindBy(id = "desk_cart-menu")
    private WebElement deskCartMenu;

    @FindBy(xpath = "html/body/script[1]")
    private WebElement script;

    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will select option in each property
    public ItemDetailsPage findProperty(int property , int option) throws Exception {
        try {
            selected[property][option] = true;
            if(isAvailable(property, option) && isValid(property, option) && !isCartDisabled()) {
                selectDropdownIndex(property, option);
                findProperty(property+1, 0);
                return this;
            }
            try{
                // Check next option
                if(!isSelected(property, option+1) && isAvailable(property, option+1) && isValid(property, option+1)) {
                    selectDropdownIndex(property, option+1);
                    findProperty(property, option+1);
                }
                // Check next property / variety
                if(!isSelected(property+1, option) && isAvailable(property+1, option) && isValid(property+1, option)) {
                    selectDropdownIndex(property+1, option);
                    findProperty(property+1, option);
                }
                // Check previous option
                if(!isSelected(property, option-1) && isAvailable(property, option-1) && isValid(property, option-1)) {
                    selectDropdownIndex(property, option-1);
                    findProperty(property, option-1);
                }
                // Check previous property / variety
                if(!isSelected(property-1, option) && isAvailable(property-1, option) && isValid(property-1, option)) {
                    selectDropdownIndex(property-1, option);
                    findProperty(property-1, option);
                }
            }
            catch (NoSuchElementException e) {
                System.out.println("No such element exception");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return this;
        }
        return this;
    }

    // This method for selecting index
    public void propertyOption(int idx) {
        WebElement var = driver.findElement(By.xpath(".//*[@name='varieties[" + idx +"]']"));
        propertyOpt.addAll(driver.findElements(By.xpath(".//*[@name='varieties[" + idx +"]']/option")));
    }

    // This method will select a dropdown
    public void selectDropdownIndex(int property, int option) {
        int var = property + 1;
        String selectedVar;

        WebElement prop = driver.findElement(By.xpath(".//*[@name='varieties[" + var +"]']"));
        Select selectVar = new Select(prop);
        selectVar.selectByIndex(option);
        selectedVar = selectVar.getFirstSelectedOption().getText();
        System.out.println(selectedVar);
    }

    // This method will click add to cart button
    public void clickCartButton() {
        cartButton.click();
    }

    // This method will get total price
    public int getTotalPrice(){
        String total = totalPrice.getText();
        return Integer.parseInt(total.replaceFirst(".*?(\\d+)", "$1").replaceAll(",",""));
    }

    // This method will automatically get quantity
    public int getQuantity() {
        Select selectQty = new Select(stockQty);
        String qty = selectQty.getFirstSelectedOption().getText();
        return Integer.parseInt(qty);
    }

    // This method will return amount of options
    public int optionAmount() {
        return propertyOpt.size();
    }

    // This method will return total properties
    public int productProperty() {
        List<WebElement> property = driver.findElements(By.xpath(".//*[@class='product-property'][1]/ul/li"));
        return property.size() - 1;
    }

    // This method will set new array size
    public boolean[][] getPropertyArr(int property, int option) {
        selected = new boolean[property][option];
        return selected;
    }

    // This method will check if the property and option has ever been selected
    public boolean isSelected(int property, int option) {
        return selected[property][option];
    }

    // This method will check if the dropdown can not be click because of out of stock
    public boolean isAvailable(int property, int option) throws Exception {
        boolean result = true;
        property = property + 1;
        option = option + 1;
        WebElement elm = driver.findElement(By.xpath(".//*[@name='varieties[" + property +
                "]']/option[" + option + "]"));
        try {
            if(!elm.isEnabled()) {
                result = false;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("No such element on method isAvailable");
        }
        return result;
    }

    // This method will check if the dropdown has a value
    public boolean isValid(int property, int option) throws Exception {
        boolean result = true;
        property = property + 1;
        option = option + 1;
        try {
            WebElement elm = driver.findElement(By.xpath(".//*[@name='varieties[" + property +
                    "]']/option[" + option + "][@value=\"\"]"));
            result = false;
        }
        catch (NoSuchElementException e) {
            result = true;
        }
        return result;
    }

    // This method will check add to cart button
    public boolean isCartDisabled() throws Exception {
        // Wait for loading page
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        boolean result = true;
        try {
            WebElement cart = driver.findElement(By.cssSelector(".add-to-cart-button.disabled"));
        }
        catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }

    // This method will check if the item clicked before is matched with the details
    public boolean isItemMatched(String brand, String product, int price) throws Exception {
        if (brandName.getText().equalsIgnoreCase(brand)) {
            if (productName.getText().equalsIgnoreCase(product)) {
                try {
                    String temp = discountPrice.getText();
                    if (Integer.parseInt(temp.replaceFirst(".*?(\\d+)", "$1").replaceAll(",","")) == price) {
                        return true;
                    }
                    else {
                        System.out.println("This product costs" + price + ". Supposed to be " + discountPrice.getText());
                        return false;
                    }
                }
                catch (NoSuchElementException e) {
                    String temp = normalPrice.getText();
                    if (Integer.parseInt(temp.replaceFirst(".*?(\\d+)", "$1").replaceAll(",","")) == price) {
                        return true;
                    }
                    else {
                        System.out.println("This product costs" + price + ". Supposed to be " + normalPrice.getText());
                        return false;
                    }
                }
            }
            else {
                System.out.println("This product's name is" + product + ". Supposed to be " + productName.getText());
                return false;
            }
        }
        else {
            System.out.println("This brand's name is" + brand + ". Supposed to be " + brandName.getText());
            return false;
        }
    }

    // This method will wait for desk cart menu to show up and verify it
    public boolean isDeskCartMenuShown() throws Exception {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return deskCartMenu.isDisplayed();
    }

    public void getScript() {
        System.out.println(script.getCssValue("id"));
    }
}
