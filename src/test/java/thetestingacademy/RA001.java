package thetestingacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

@Test
public class RA001 {
    public void postRequest(){
        RestAssured.useRelaxedHTTPSValidation();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .when().body(payload).post()
                .then().log().all().statusCode(200);

    }
}
