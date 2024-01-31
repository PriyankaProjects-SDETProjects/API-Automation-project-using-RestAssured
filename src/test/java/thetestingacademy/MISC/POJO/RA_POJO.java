package thetestingacademy.MISC.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RA_POJO {
@Test
    public void postAuth(){

        Auth auth = new Auth();
        auth.setUsername("admin"); ;
        auth.setPassword("password123");
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(auth);
        Response response = r.when().post();
        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

    }
}
