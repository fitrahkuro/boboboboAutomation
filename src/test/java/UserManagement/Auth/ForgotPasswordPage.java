package UserManagement.Auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.SystemClock;

/**
 * Created by Prima on 8/5/2016.
 */
public class ForgotPasswordPage {
    WebDriver driver;
    String errorMsg;

    @FindBy(id = "phoenix_frontend_user_forgot_password_email")
    private WebElement forgotPassEmail;

    @FindBy(css = "input[type='submit'][value='Reset My Password']")
    private WebElement resetPassButton;

    @FindBy(css = "a[href*='login']")
    private WebElement loginButton;

    @FindBy(id = "user-form-error")
    private WebElement userFormError;

    // This is a constructor
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method will reset user's password by email
    public ForgotPasswordPage resetPass(String email) {
        forgotPassEmail.click();
        forgotPassEmail.sendKeys(email);
        resetPassButton.click();
        return this;
    }

    // This method will click log in button instead of reset password button
    public LoginPage clickLoginInstead() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public String getErrorMsg() {
        errorMsg = userFormError.getText();
        return errorMsg;
    }
}
