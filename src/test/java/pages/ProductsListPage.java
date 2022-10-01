package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductsListPage extends MyPage{
    public ProductsListPage() {
        title = "PRODUCTS";
    }
    final String ADDTOCARTSTRING = "add-to-cart-";
    SelenideElement shoppingCartLink = $("a.shopping_cart_link");
    Integer productCount = 0;

    public void addItemToCart(String itemName) {
        String newItemName = itemName.replaceAll(" ", "-").toLowerCase();
        newItemName = ADDTOCARTSTRING + newItemName;
        $("button#" + newItemName).click();
        productCount++;

        //Shopping cart number should go up
        shoppingCartLink.$("span.shopping_cart_badge").shouldHave(text(productCount.toString()));
    }
    public void goToShoppingCart() {
        shoppingCartLink.click();
    }
}
