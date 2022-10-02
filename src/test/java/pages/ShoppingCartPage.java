package pages;

import com.codeborne.selenide.SelenideElement;
import model.Product;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage extends MyPage {
    String priceElementString  = "div.inventory_item_price";
    public ShoppingCartPage() {
        title = "YOUR CART";
    }
    SelenideElement checkOutButton = $("button#checkout");

    public void CheckItemsVisible(Product[] items) {
        for (Product item:items) {
            String stringPrice = String.valueOf(item.GetPrice());
            $(byText(item.GetName())).shouldBe(visible);
            $(byText(item.GetName())).parent().parent()
                    .$(priceElementString)
                    .shouldHave(text(stringPrice));
        }
    }
    public void ClickCheckout() {
        checkOutButton.click();
    }
}
