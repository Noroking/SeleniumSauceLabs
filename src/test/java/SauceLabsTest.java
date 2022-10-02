import com.codeborne.selenide.Configuration;
import model.Product;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class SauceLabsTest {

    LoginPage loginPage = new LoginPage();
    ProductsListPage productsListPage = new ProductsListPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutStepOnePage checkOutStepOnePage = new CheckOutStepOnePage();
    CheckOutStepTwoPage checkOutStepTwoPage = new CheckOutStepTwoPage();
    CheckOutComplete checkOutComplete = new CheckOutComplete();

    @BeforeSuite
    public void BeforeSuite() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }
    @Test(dataProvider = "credentials")
    public void goToHomePage(String username, String password)  {
        open("/");
        loginPage.login(username, password);
        productsListPage.titleShouldBeVisible();
    }
    @Test(dataProvider = "credentials")
    public void buyItem(String username, String password)  {

        open("/");
        loginPage.login(username, password);
        productsListPage.titleShouldBeVisible();
        Product fleeceJacket = new Product("Sauce Labs Fleece Jacket", 49.99);
        Product bikeLight = new Product("Sauce Labs Bike Light", 9.99);
        productsListPage.addItemToCart(fleeceJacket.GetName());
        productsListPage.addItemToCart(bikeLight.GetName());
        productsListPage.goToShoppingCart();
        shoppingCartPage.titleShouldBeVisible();

        Product[] products = {fleeceJacket, bikeLight};
        shoppingCartPage.CheckItemsVisible(products);
        shoppingCartPage.ClickCheckout();

        checkOutStepOnePage.titleShouldBeVisible();
        checkOutStepOnePage.FillInDetails("Awesome", "Dude", "2022");
        checkOutStepOnePage.ClickContinue();

        checkOutStepTwoPage.titleShouldBeVisible();
        checkOutStepTwoPage.ClickFinish();

        checkOutComplete.titleShouldBeVisible();
        checkOutComplete.ValidateComplete();
    }

    @DataProvider(name="credentials")
    public Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "standard_user", "secret_sauce" },
        };
    }
}
