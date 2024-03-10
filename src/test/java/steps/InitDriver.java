package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Дано;
import utils.ConfProperties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class InitDriver {
    @Дано("Открываем сайт {string}")
    public void initBrowser(String url) {
        open(ConfProperties.getProperty("url"));
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 10000;
    }
}
