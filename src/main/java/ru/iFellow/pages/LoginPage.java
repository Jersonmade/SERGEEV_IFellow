package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static SelenideElement inputLogin = $x("//input[@name='os_username']");
    public static SelenideElement inputPassword = $x("//input[@name='os_password']");
    public static SelenideElement loginBtn = $x("//input[@id='login']");

    public void inputLog (String login){
        inputLogin.setValue(login);
    }

    public void inputPass (String password){
        inputPassword.setValue(password);
    }

    public void clickBtn (){
        loginBtn.click();
    }
}
