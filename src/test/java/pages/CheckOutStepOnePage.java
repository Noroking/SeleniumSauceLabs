package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckOutStepOnePage extends MyPage {
    SelenideElement continueButton = $("input#continue");
    SelenideElement firstNameTextField = $("input#first-name");
    SelenideElement lastNameTextField = $("input#last-name");
    SelenideElement postalCodeTextField = $("input#postal-code");
    public CheckOutStepOnePage() {
        title = "Checkout: Your Information";
    }

    public void FillInDetails(String firstName, String lastName, String postalCode) {
        firstNameTextField.sendKeys(firstName);
        lastNameTextField.sendKeys(lastName);
        postalCodeTextField.sendKeys(postalCode);
    }

    public void ClickContinue() {
        continueButton.click();
    }
}
