package webhooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import ru.iFellow.utils.ConfProperties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHook {
    @BeforeAll
    public static void initBrowser() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );

        open(ConfProperties.getProperty("url"));
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 10000;
    }
}
