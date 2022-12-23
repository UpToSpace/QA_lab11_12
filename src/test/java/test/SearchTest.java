package test;

import model.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import service.SearchCreator;

public class SearchTest extends CommonConditions {
    private HomePage homePage;
    private Search search;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        homePage = new HomePage(driver)
                .openPage();
        search = SearchCreator.withTextSearch("гель для душа");
    }

    @Test(description = "Search items")
    public void searchItems() throws InterruptedException {
        homePage.enterSearch(search.getSearchText()).clickSearchIcon();
    }
}
