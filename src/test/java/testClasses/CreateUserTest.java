package testClasses;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.apiSteps.SecondTaskStep;
import utils.ConfProperties;
import webhooks.WebHooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateUserTest extends WebHooks {

    @Test
    public void createUserTest() throws IOException {
        SecondTaskStep secondTaskStep = new SecondTaskStep();
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/body.json"))));

        Response response = secondTaskStep.createUser(
                ConfProperties.getProperty("create.user.base.uri"),
                ConfProperties.getProperty("create.user.post.uri"),
                body.toString(),
                Integer.parseInt(ConfProperties.getProperty("post.status.code"))
        );

        JSONObject responseBody = new JSONObject(response.getBody().asString());
        Assertions.assertEquals(body.get("name"), responseBody.get("name"));
        Assertions.assertEquals(body.get("job"), responseBody.get("job"));
    }

}
