package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MyPage {
    String title;
    SelenideElement titleElement = $("span.title");

    public void titleShouldBeVisible() {

        titleElement.shouldBe(Condition.visible)
                .shouldHave(text(title));
    }
}
