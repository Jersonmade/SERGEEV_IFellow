package webhooks;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.ConfProperties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    @BeforeEach
    public void beforeEach() {
        RestAssured.filters(new AllureRestAssured());
    }
}
