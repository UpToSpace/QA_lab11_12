package test;

import driver.Driver;
import model.User;
import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AuthPage;
import page.CatalogPage;
import page.HomePage;
import service.UserCreator;

public class AddItemToCartTest extends CommonConditions {
    private AuthPage authPage;
    private HomePage homePage;
    private CatalogPage catalogPage;

    private User user;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        authPage = new AuthPage(driver)
                .openPage();
        catalogPage = new CatalogPage(driver);
        user = UserCreator.withCredentialsFromProperty();
    }

    @Test(description = "Add item to cart")
    public void addItem() throws InterruptedException {
        authPage.authorize(user);
        homePage = new HomePage(driver)
                .openPage();
        homePage.enterSearch("гель для душа").clickSearchIcon();
        catalogPage.addToCart();
    }
}
