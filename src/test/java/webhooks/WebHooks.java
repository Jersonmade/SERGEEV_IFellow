package webhooks;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {
    @BeforeEach
    public void beforeEach() {
        RestAssured.filters(new AllureRestAssured());
    }
}
