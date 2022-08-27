package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final String EMAIL_INPUT_SELECTOR = "#inputEmail";
    private final String PASSWORD_INPUT_SELECTOR = "#inputPassword";
    private final String LOGIN_BUTTON_SELECTOR = "#btnLogin";
    private final static String URL = "https://app.qase.io/login";

    @Override
    public void waitForPageLoaded() {
        $(EMAIL_INPUT_SELECTOR).should(Condition.visible);
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
    }
    public void open() {
        Selenide.open(URL);
    }

    private void setEmail(String email) {
        $(EMAIL_INPUT_SELECTOR).setValue(email);

    }

    private void setPassword(String password) {
        $(PASSWORD_INPUT_SELECTOR).setValue(password);
    }

    private void clickLogin() {
        $(LOGIN_BUTTON_SELECTOR).click();
    }
}
