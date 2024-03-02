package webhooks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import utils.ConfProperties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHook {
    @BeforeAll
    public static void initBrowser() {
        open(ConfProperties.getProperty("url"));
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 10000;
    }
}
