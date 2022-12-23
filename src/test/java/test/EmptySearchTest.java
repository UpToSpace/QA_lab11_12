package test;

import model.Search;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import service.SearchCreator;

public class EmptySearchTest extends CommonConditions {

    private HomePage homePage;
    private Search search;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        homePage = new HomePage(driver)
                .openPage();
        search = SearchCreator.emptySearch();
    }

    @Test(description = "Search items")
    public void searchItems() throws InterruptedException {
        homePage.enterSearch(search.getSearchText()).clickSearchIcon();
    }
}
