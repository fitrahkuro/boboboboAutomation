package UserManagement.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Prima on 8/3/2016.
 */
public class LoginPage {
    WebDriver driver;
    List<WebElement> titleOption;

    @FindBy(name = "_username")
    private WebElement userEmail;

    @FindBy(name = "_password")
    private WebElement userPassword;

    @FindBy(id = "create-an-account")
    private WebElement register;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(id = "phoenix_frontend_user_register_title")
    private WebElement title;

    @FindBy(id = "phoenix_frontend_user_register_firstName")
    private WebElement firstName;

    @FindBy(id = "phoenix_frontend_user_register_lastName")
    private WebElement lastName;

    @FindBy(id = "phoenix_frontend_user_register_email")
    private WebElement newEmail;

    @FindBy(id = "phoenix_frontend_user_register_newPassword_first")
    private WebElement newPass1;

    @FindBy(id = "phoenix_frontend_user_register_newPassword_second")
    private WebElement newPass2;

    @FindBy(css = "input[type='submit'][value='CONTINUE']")
    private WebElement continueRegister;

    @FindBy(className = "forgot-password")
    private WebElement forgotPassElm;

    // This is a constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will add email and password
    public LoginPage doLogin(String email, String password) {
        userEmail.click();
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);

        return this;
    }

    // This method will click log in button
    // return Homepage object
    public Homepage clickLoginButton() {
        loginButton.click();
        return new Homepage(driver);
    }

    // This method will click register radio button
    public LoginPage clickRegister() {
        register.click();
        return this;
    }

    // This method will create a new account
    public LoginPage doRegister(int index, String fname, String lname, String email, String pass1, String pass2) {
        // select title
        Select selectIdx = new Select(title);
        selectIdx.selectByIndex(index);

        // Input first and last name
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);

        // Input email
        newEmail.sendKeys(email);

        // Input password
        newPass1.sendKeys(pass1);
        newPass2.sendKeys(pass2);

        continueRegister.click();
        return this;
    }

    // This method is for clicking a forgot password button
    public LoginPage clickForgotPass() {
        forgotPassElm.click();
        return this;
    }

    // This method will generate index number for title
    // return int
    public int randomTitle() {
        titleOption = driver.findElements(By.cssSelector("#phoenix_frontend_user_register_title>option"));
        int randomIdx = (int) Math.ceil(Math.random()* (titleOption.size() - 1 ));
        return randomIdx;
    }
}
