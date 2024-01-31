package thetestingacademy;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RATestNG {

    @Test
public void getRequest(){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().statusCode(201);

    }
}
