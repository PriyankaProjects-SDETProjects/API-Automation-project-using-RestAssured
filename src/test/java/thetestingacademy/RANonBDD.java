package thetestingacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RANonBDD {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public void  prePostRequestMethod(){
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
    }

    @Test
    public void postRequest(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        response = requestSpecification.when().post();

        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
