package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CreateBugPage {
    public static SelenideElement createBugLink = $x("//a[@id ='create_link']").as("Кнопка создания \"Бага\"");
    public static SelenideElement topic = $x("//input[@id='summary']").as("Поле тема");
    public static SelenideElement description = $x("//body[@id='tinymce' and @data-id='mce_0']/child::p").as("Поле описание");
    public static SelenideElement environment = $x("//body[@id='tinymce' and @data-id='mce_6']/child::p").as("Поле окружение");
    public static SelenideElement createBtn = $x("//input[@id='create-issue-submit']").as("Кнопка создания \"Бага\"");
    public static SelenideElement business = $x("//span[contains(text(), 'Бизнес-процесс')and @class='dropdown-text']/..").as("Бизнес-процесс");
    public static SelenideElement complete = $x("//span[contains(text(), 'Выполнено')and @class='trigger-label']/..").as("Выполнено");
    public static SelenideElement message = $x("//a[@class = 'issue-created-key issue-link']").as("Всплывающее сообщение создания бага");
    public static SelenideElement status = $x("//span[@class='status-view']//preceding-sibling::span").as("Статус \"Бага\"");

    @Step("Нажатие на кнопку \"Создать\"")
    public void clickCreateBugLink() {
        createBugLink.click();
    }

    @Step("Заполнение графы \"Тема\"")
    public void inputTopic(){
        topic.click();
        topic.setValue("New Bug");
    }

    @Step("Заполнение графы \"Описание\"")
    public void fillDescription(){
        switchTo().frame($("[id='mce_0_ifr']"));
        description.click();
        description.setValue("Random desc");
        switchTo().defaultContent();
    }

    @Step("Заполнение графы \"Окружение\"")
    public void fillEnvironmentField(){
        switchTo().frame($("[id='mce_6_ifr']"));
        environment.click();
        environment.setValue("Random env");
        switchTo().defaultContent();
    }

    @Step("Создание бага")
    public void createBug(){
        createBtn.click();
    }

    @Step("Переход на раздел содержащий созданный баг")
    public void createDoneTest(){
        message.click();
    }

    @Step("Перевод бага в статус \"Выполнено\"")
    public void businessProgress(){
        business.click();
        complete.shouldBe(Condition.visible, Duration.ofSeconds(4)).click();
        sleep(2000);
    }

    @Step("Проверка статуса бага")
    public void checkBug(){
        String statusBug = status.getText().toLowerCase();
        Assertions.assertEquals(statusBug,"готово");
    }
}
