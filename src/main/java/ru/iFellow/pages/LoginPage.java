package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static SelenideElement inputLogin = $x("//input[@name='os_username']");
    public static SelenideElement inputPassword = $x("//input[@name='os_password']");
    public static SelenideElement loginBtn = $x("//input[@id='login']");

    @Step("Ввод логина")
    public void inputLog (String login){
        inputLogin.setValue(login);
    }

    @Step("Ввод пароля")
    public void inputPass (String password){
        inputPassword.setValue(password);
    }

    @Step("Нажатие на кнопку \"Войти\"")
    public void clickBtn (){
        loginBtn.click();
    }
}
