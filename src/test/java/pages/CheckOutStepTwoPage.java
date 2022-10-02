package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CheckOutStepTwoPage extends MyPage {
    public CheckOutStepTwoPage() {
        title = "Checkout: Overview";
    }

    SelenideElement itemTotalTextField = $("div.summary_subtotal_label");
    SelenideElement taxTextField = $("div.summary_tax_label");
    SelenideElement grandTotalTextField = $("div.summary_total_label");
    SelenideElement finishButton = $("button#finish");

//    public void CheckItemsVisible(Product[] items) {
//        for (Product item:items) {
//            String stringPrice = String.valueOf(item.GetPrice());
//            $(byText(item.GetName())).shouldBe(visible);
//            $(byText(item.GetName())).parent().parent()
//                    .$(priceElementString)
//                    .shouldHave(text(stringPrice));
//        }
//    }
    public void CheckPricesAreValid(double taxPercent, double[] prices) {
        double totalItemPrice = 0;
        double taxAmount = 0;
        for (double price: prices) {
            totalItemPrice+=price;
        }
        taxAmount =taxPercent * totalItemPrice;
        taxAmount = Math.round(taxAmount * 100)/100.0;
        double grandTotalPrice = totalItemPrice + taxAmount;

    }
    public void ClickFinish() {
        finishButton.click();
    }
}
