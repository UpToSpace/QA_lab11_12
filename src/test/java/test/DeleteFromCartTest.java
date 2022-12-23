package test;

import model.User;
import org.apache.logging.log4j.core.config.Order;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AuthPage;
import page.CartPage;
import page.CatalogPage;
import page.HomePage;
import service.UserCreator;

@Order(2)
public class DeleteFromCartTest extends CommonConditions {

    private AuthPage authPage;
    private HomePage homePage;
    private CatalogPage catalogPage;

    private User user;
    private CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void addToCart() throws InterruptedException {
            authPage = new AuthPage(driver)
                    .openPage();
            catalogPage = new CatalogPage(driver);
            user = UserCreator.withCredentialsFromProperty();
        cartPage = new CartPage(driver);
    }

    @Test(description = "Delete item from cart")
    public void deleteItem() throws InterruptedException {
        authPage.authorize(user);
        homePage = new HomePage(driver)
                .openPage();
        homePage.enterSearch("шампунь").clickSearchIcon();
        catalogPage.addToCart();
        cartPage.deleteItemFromCart();
    }
}
