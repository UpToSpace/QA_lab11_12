package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    private static final String HOMEPAGE_URL = "https://belita-shop.by/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    @FindBy(xpath ="//div[@class='b-page']/div/div/div/div/div/div/div/form/fieldset/button[@class='submit']" )
    WebElement searchIcon;

    @FindBy(xpath ="//div[@class='b-page']/div/div/div/div/div/div/div/form/fieldset/input[@class='form-control']" )
    WebElement searchInputElement;

    @FindBy(linkText = "+375-29-612-27-27")
    WebElement phoneNumber;

    public HomePage enterSearch(String searchText) {
        waitForVisibilityOfElement(driver, searchInputElement);
        searchInputElement.sendKeys(searchText);
        return this;
    }

    public HomePage enterEmptySearch() {
        waitForVisibilityOfElement(driver, searchInputElement);
        searchInputElement.sendKeys();
        return this;
    }

    public HomePage clickSearchIcon() {
        waitForVisibilityOfElement(driver, searchIcon);
        searchIcon.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomePage clickPhoneNumber() {
        waitForVisibilityOfElement(driver, phoneNumber);
        phoneNumber.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
