package test;

import model.Search;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AuthPage;
import page.CartPage;
import page.CatalogPage;
import page.HomePage;
import service.SearchCreator;
import service.UserCreator;

public class AllInOneTest extends CommonConditions { // add addseveralitems, line
    private AuthPage authPage;
    private HomePage homePage;
    private CatalogPage catalogPage;
    private CartPage cartPage;

    private User user;
    private Search search;
    private Search emptySearch;


    @BeforeMethod(alwaysRun = true)
    public void addToCart() throws InterruptedException {
        authPage = new AuthPage(driver)
                .openPage();
        catalogPage = new CatalogPage(driver);
        user = UserCreator.withCredentialsFromProperty();
        emptySearch = SearchCreator.emptySearch();
        search = SearchCreator.withTextSearch("шампунь");
        cartPage = new CartPage(driver);
        authPage.authorize(user);
        homePage = new HomePage(driver)
                .openPage();
        homePage.enterSearch(emptySearch.getSearchText()).clickSearchIcon();
        homePage.enterSearch(search.getSearchText()).clickSearchIcon();
        catalogPage.addToCart();
        cartPage.deleteItemFromCart();
        cartPage.restoreDeletedItemFromCart();
    }

    @Test(description = "Delete item from cart")
    public void deleteItem() throws InterruptedException {
        cartPage.clickOrderItems();
        cartPage.orderItems();
    }
}
