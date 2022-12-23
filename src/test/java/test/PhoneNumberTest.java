package test;

import model.Search;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import service.SearchCreator;

public class PhoneNumberTest extends CommonConditions {

    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        homePage = new HomePage(driver)
                .openPage();
    }

    @Test(description = "Search items")
    public void searchItems() throws InterruptedException {
        homePage.clickPhoneNumber();
    }
}
