package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "basket-item-block-actions")
    private WebElement deleteButton;

    @FindBy(className = "basket-item-amount-btn-minus")
    private WebElement minusButton;

    @FindBy(linkText = "Восстановить")
    private WebElement restoreButton;

    @FindBy(css = "div.bx-green .btn.btn-default")
    private WebElement orderButton;

    @FindBy(className = "pull-right")
    private WebElement furtherButton;

    @FindBy(linkText = "Оформить заказ")
    private WebElement orderButtonOrder;

    public CartPage deleteItemFromCart(){
        minusButton.click();
        Page.waitForVisibilityOfElement(driver, deleteButton);
        deleteButton.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CartPage restoreDeletedItemFromCart(){
        Page.waitForVisibilityOfElement(driver, restoreButton);
        restoreButton.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CartPage clickOrderItems(){
        Page.waitForVisibilityOfElement(driver, orderButton);
        orderButton.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CartPage orderItems(){
        for (int i = 0; i < 5; i++) {
            Page.waitForVisibilityOfElement(driver, furtherButton);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            furtherButton.click();
        }
        Page.waitForVisibilityOfElement(driver, orderButtonOrder);
        orderButtonOrder.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
