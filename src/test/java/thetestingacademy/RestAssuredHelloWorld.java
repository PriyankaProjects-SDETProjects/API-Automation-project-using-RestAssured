package thetestingacademy;

import io.restassured.RestAssured;

public class RestAssuredHelloWorld {
    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get().then().log().all().statusCode(201);
    }
}
