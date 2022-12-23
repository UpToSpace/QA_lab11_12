package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CatalogPage extends Page {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "buy-btn-wrap")
    WebElement addToCartIcon;

    @FindBy(how=How.XPATH, using = "//div[starts-with(@id, 'bx_1543241675_40398')]")
    WebElement secondItemIcon;

    @FindBy(className = "product-quantity")
    WebElement inputValue;

    @FindBy(className = "btn-wrap")
    WebElement addToCartSecondItemButton;

    @FindBy(how=How.XPATH, using = "//a[starts-with(@title, 'Линия')]")
    WebElement lineButton;

    public CatalogPage addToCart() {
        waitForVisibilityOfElement(driver, addToCartIcon);
        addToCartIcon.click();
        return this;
    }

    public CatalogPage goToSecondItem() {
        waitForVisibilityOfElement(driver, secondItemIcon);
        secondItemIcon.click();
        return this;
    }

    public CatalogPage goToLine() {
        waitForVisibilityOfElement(driver, lineButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lineButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CatalogPage addSeveralItemsToCart() {
        goToSecondItem();

        waitForVisibilityOfElement(driver, inputValue);
        inputValue.clear();
        inputValue.sendKeys("2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addToCartSecondItemButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
