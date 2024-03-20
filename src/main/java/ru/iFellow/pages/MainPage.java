package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static SelenideElement projectsTab = $x("//a[@id='browse_link']");
    public static SelenideElement testProjects = $x("//a[@id='admin_main_proj_link_lnk']");
    public static SelenideElement quantity = $x("//div[@class='showing']");
    public static SelenideElement allTasks = $x("//div[@class='showing']");

    @Step("Переход в раздел \"Задачи\" и сбор кол-ва задач")
    public void clickProjects() {
        projectsTab.click();
        testProjects.click();
    }

    @Step("Проверка соотвествия кол-ва задач")
    public void checkTasks(){
        String howMany = quantity.getText();
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(howMany);
        matcher.find();
        clickProjects();
        String HWTask = allTasks.getText();
        Pattern patterns = Pattern.compile("\\d+$");
        Matcher matchers = patterns.matcher(HWTask);
        matchers.find();
        String a1 = matchers.group();
        String a2 = matcher.group();
        Assertions.assertEquals(a1,a2);
    }
}
