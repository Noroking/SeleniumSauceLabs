package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckOutComplete extends MyPage {

    SelenideElement thankYouMessage = $("h2.complete-header");
    public CheckOutComplete() {
        title = "Checkout: Complete!";
    }

    public void ValidateComplete() {
        thankYouMessage.shouldBe(Condition.visible).
                shouldHave(text("THANK YOU FOR YOUR ORDER"));
    }
}
