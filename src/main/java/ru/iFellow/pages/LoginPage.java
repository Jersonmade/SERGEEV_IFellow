package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import ru.iFellow.utils.ConfProperties;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public static SelenideElement inputLogin = $x("//input[@name='os_username']");
    public static SelenideElement inputPassword = $x("//input[@name='os_password']");
    public static SelenideElement loginBtn = $x("//input[@id='login']");

    public void inputLog (){
        inputLogin.setValue(ConfProperties.getProperty("login"));
    }

    public void inputPass (){
        inputPassword.setValue(ConfProperties.getProperty("password"));
    }

    public void clickBtn (){
        loginBtn.click();
    }
}
