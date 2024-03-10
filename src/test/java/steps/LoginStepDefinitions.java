package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import ru.iFellow.pages.LoginPage;

public class LoginStepDefinitions {
    private final LoginPage loginPage = new LoginPage();

    @Когда("пользователь вводит логин")
    public void enterLogin() {
        loginPage.inputLog();
    }

    @И("пользователь вводит пароль")
    public void enterPass() {
        loginPage.inputPass();
    }

    @И("пользователь нажимает кнопку \"Войти\"")
    public void pressButton() {
        loginPage.clickBtn();
    }
}
