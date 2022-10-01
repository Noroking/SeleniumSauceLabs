import model.Product;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsListPage;
import pages.ShoppingCartPage;

import static com.codeborne.selenide.Selenide.open;

public class SauceLabsTest {

    LoginPage loginPage = new LoginPage();
    ProductsListPage productsListPage = new ProductsListPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    private final String BASE_URL = "https://www.saucedemo.com";

    @Test
    public void goToHomePage() {
        open(BASE_URL);
        loginPage.login("standard_user", "secret_sauce");
        productsListPage.titleShouldBeVisible();
    }
    @Test
    public void buyItem() {
        open(BASE_URL);
        loginPage.login("standard_user", "secret_sauce");
        productsListPage.titleShouldBeVisible();
        Product fleeceJacket = new Product("Sauce Labs Fleece Jacket", 49.99);
        Product bikeLight = new Product("Sauce Labs Bike Light", 9.99);
        productsListPage.addItemToCart(fleeceJacket.GetName());
        productsListPage.addItemToCart(bikeLight.GetName());
        productsListPage.goToShoppingCart();
        shoppingCartPage.titleShouldBeVisible();

        Product[] products = {fleeceJacket, bikeLight};
        shoppingCartPage.CheckItemsVisible(products);
    }
}
