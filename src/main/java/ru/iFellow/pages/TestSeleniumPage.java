package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import ru.iFellow.utils.ConfProperties;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumPage {
    public static SelenideElement taskStatus = $x("//span[@class='status-view']//preceding-sibling::span").as("Статус задачи");
    public static SelenideElement taskVersion = $x("//span[@class='shorten']").as("Версия задачи");
    public static SelenideElement inputText = $x("//input[@id='quickSearchInput']").as("Поле для ввода");

    @Step("Поиск задачи")
    public void searchTestSelenium(){
        inputText.click();
        inputText.setValue(ConfProperties.getProperty("taskname"));

        inputText.sendKeys(Keys.ENTER);
    }

    @Step("Проверка версии задачи")
    public void collectionVersion(){
        String version = taskVersion.getText();
        Assertions.assertEquals(version,"Version 2.0");
    }

    @Step("Проверка статуса задачи")
    public void collectionStatus(){
        String inProgress = taskStatus.getText().toLowerCase();
        Assertions.assertEquals(inProgress,"готово");
    }
}
