package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CreateBugPage {
    public static SelenideElement createBugLink = $x("//a[@id ='create_link']");
    public static SelenideElement topic = $x("//input[@id='summary']");
    public static SelenideElement description = $x("//body[@id='tinymce' and @data-id='mce_0']/child::p");
    public static SelenideElement environment = $x("//body[@id='tinymce' and @data-id='mce_6']/child::p");
    public static SelenideElement createBtn = $x("//input[@id='create-issue-submit']");
    public static SelenideElement business = $x("//span[contains(text(), 'Бизнес-процесс')and @class='dropdown-text']/..");
    public static SelenideElement complete = $x("//span[contains(text(), 'Выполнено')and @class='trigger-label']/..");
    public static SelenideElement message = $x("//a[@class = 'issue-created-key issue-link']");
    public static SelenideElement status = $x("//span[@class='status-view']//preceding-sibling::span");

    public void clickCreateBugLink() {
        createBugLink.click();
    }

    public void inputTopic(){
        topic.click();
        topic.setValue("New Bug");
    }

    public void fillDescription(){
        switchTo().frame($("[id='mce_0_ifr']"));
        description.click();
        description.setValue("Random desc");
        switchTo().defaultContent();
    }

    public void fillEnvironmentField(){
        switchTo().frame($("[id='mce_6_ifr']"));
        environment.click();
        environment.setValue("Random env");
        switchTo().defaultContent();
    }

    public void createBug(){
        createBtn.click();
    }

    public void createDoneTest(){
        message.click();
    }

    public void businessProgress(){
        business.click();
        complete.shouldBe(Condition.visible, Duration.ofSeconds(4)).click();
        sleep(2000);
    }

    public void checkBug(){
        String statusBug = status.getText().toLowerCase();
        Assertions.assertEquals(statusBug,"готово");
    }
}
