package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends Page {

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "USER_LOGIN")
    private WebElement fieldForEmail;

    @FindBy(name = "USER_PASSWORD")
    private WebElement fieldForPassword;

    @FindBy(name = "Login")
    private WebElement submitLogInButton;

    private static final String AUTHPAGE_URL = "https://belita-shop.by/auth/";

    public AuthPage openPage(){
        driver.get(AUTHPAGE_URL);
        return this;
    }

    public AuthPage enterEmail(String email) {
        Page.waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(email);
        return this;
    }

    public AuthPage enterPassword(String password) {
        Page.waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(password);
        return this;
    }

    public HomePage signIn() {
        Page.waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new HomePage(driver);
    }

    public HomePage authorize(User user) {
        this.enterEmail(user.getUsername())
                .enterPassword(user.getPassword())
                .signIn();
        return new HomePage(driver);
    }
}
