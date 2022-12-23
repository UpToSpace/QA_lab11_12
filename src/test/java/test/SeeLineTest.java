package test;

import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AuthPage;
import page.CatalogPage;
import page.HomePage;
import service.UserCreator;

public class SeeLineTest extends CommonConditions {
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

    @Test(description = "See all line")
    public void addItem() throws InterruptedException {
        authPage.authorize(user);
        homePage = new HomePage(driver)
                .openPage();
        homePage.enterSearch("гель для душа").clickSearchIcon();
        catalogPage.goToSecondItem();
        catalogPage.goToLine();

    }
}
