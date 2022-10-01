package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    SelenideElement usernameTextField = $("input#user-name");
    SelenideElement passwordTextField =  $("input#password");
    SelenideElement submitButton = $("input#login-button");


    public void login(String username, String password) {
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        submitButton.click();;
    }

}
