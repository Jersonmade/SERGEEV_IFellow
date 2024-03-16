package ru.iFellow.apiSteps;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public void getCharacter(String baseUri, String getUri, int statusCode) {
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

    public void getIdLastCharacterFromLastEpisode(String baseUri, int statusCode) {
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

    public void getLocationAndSpeciesLastCharacter(String baseUri, int statusCode) {
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
}