package ru.iFellow.apiSteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.utils.ConfProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class SecondTaskStep {

    private static JSONObject body;
    private Response res;

    @Дано("Создание пользователя")
    public void create() throws IOException {
        body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/body.json"))));
    }

    @Затем("Отправка POST-запроса")
    public Response createUser() {
        res = given()
                .header("Content-type","application/json")
                .header("charset","utf-8")
                .baseUri(ConfProperties.getProperty("create.user.base.uri"))
                .body(body.toString())
                .when()
                .post(ConfProperties.getProperty("create.user.post.uri"))
                .then()
                .log().all()
                .statusCode(Integer.parseInt(ConfProperties.getProperty("post.status.code")))
                .extract().response();
        return res;
    }

    @Тогда("Проверка данных тела запроса и ответа")
    public void verifyData() {
        JSONObject responseBody = new JSONObject(res.getBody().asString());
        Assertions.assertEquals(body.get("name"), responseBody.get("name"));
        Assertions.assertEquals(body.get("job"), responseBody.get("job"));
    }

}
