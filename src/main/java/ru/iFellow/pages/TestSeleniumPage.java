package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import ru.iFellow.utils.ConfProperties;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumPage {
    public static SelenideElement taskStatus = $x("//span[@class='status-view']//preceding-sibling::span");
    public static SelenideElement taskVersion = $x("//span[@id='fixfor-val']");
    public static SelenideElement inputText = $x("//input[@id='quickSearchInput']");

    public void searchTestSelenium(){
        inputText.click();
        inputText.setValue(ConfProperties.getProperty("taskname"));
        inputText.sendKeys(Keys.ENTER);
    }

    public void collectionStatus(){
        String inProgress = taskStatus.getText().toLowerCase();
        Assertions.assertEquals(inProgress,"готово");
    }

    public void collectionVersion(){
        String version = taskVersion.getText();
        Assertions.assertEquals(version,"Version 2.0");
    }
}
