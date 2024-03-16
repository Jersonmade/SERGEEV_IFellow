package ru.iFellow.apiSteps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SecondTaskStep {

    public Response createUser(String baseUri, String postUri, String body, int statusCode) {
        Response res = given()
                .header("Content-type","application/json")
                .header("charset","utf-8")
                .baseUri(baseUri)
                .body(body)
                .when()
                .post(postUri)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().response();
        return res;
    }

}
