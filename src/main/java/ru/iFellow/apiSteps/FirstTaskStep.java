package ru.iFellow.apiSteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.utils.ConfProperties;

import static io.restassured.RestAssured.given;

public class FirstTaskStep {
    public static String characterId;
    public static String speciesMorty;
    public static String speciesLastCharacter;
    public static String locationNameMorty;
    public static String locationNameLastCharacter;
    public static int lastEpisodeMortyIndex;
    public static String lastCharacterFromLastEpisode;
    public static int lastCharacterFromLastEpisodeIndex;
    String baseUri = ConfProperties.getProperty("morty.base.uri");
    String getUri = ConfProperties.getProperty("morty.get.morty.uri");
    int statusCode = Integer.parseInt(ConfProperties.getProperty("get.status.code"));

    @Дано("Получение информации о рассе и локации Морти")
    public void getCharacter() {

        Response response = given()
                .baseUri(baseUri)
                .when()
                .get(getUri)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().response();

        characterId = new JSONObject(response.getBody().asString()).get("id").toString();
        speciesMorty = new JSONObject(response.getBody().asString()).get("species").toString();
        JSONObject locationMorty = new JSONObject(response.getBody().asString()).getJSONObject("location");
        locationNameMorty = locationMorty.get("name").toString();

        JSONArray episodesArray = new JSONObject(response.getBody().asString()).getJSONArray("episode");
        lastEpisodeMortyIndex = episodesArray.length();
    }

    @Затем("Получение id последнего персонажа")
    public void getIdLastCharacterFromLastEpisode() {

        Response response = given()
                .baseUri(baseUri)
                .when()
                .get("/episode/" + lastEpisodeMortyIndex)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().response();

        JSONArray charactersArray = new JSONObject(response.getBody().asString()).getJSONArray("characters");
        lastCharacterFromLastEpisode = charactersArray.getString(charactersArray.length() - 1);
        String[] parts = lastCharacterFromLastEpisode.split("/");
        lastCharacterFromLastEpisodeIndex = Integer.parseInt(parts[parts.length - 1]);
    }

    @Затем("Получение информации и рассе и локации последнего персонажа")
    public void getLocationAndSpeciesLastCharacter() {

        Response response = given()
                .baseUri(baseUri)
                .when()
                .get("/character/" + lastCharacterFromLastEpisodeIndex)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().response();

        speciesLastCharacter = new JSONObject(response.getBody().asString()).get("species").toString();
        JSONObject locationLastCharacter = new JSONObject(response.getBody().asString()).getJSONObject("location");
        locationNameLastCharacter = locationLastCharacter.get("name").toString();
    }

    @Тогда("Проверка рассы")
    public void verifySpecies() {
        Assertions.assertEquals(speciesMorty, speciesLastCharacter);
    }

    @Тогда("Проверка локации")
    public void verifyLocation() {
        Assertions.assertFalse(Boolean.parseBoolean(locationNameMorty), locationNameLastCharacter);
    }
}