package thetestingacademy.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PUT_Request {
    //get a token - POST
    //create a booking and get ID-POST
    //Pass ID & Toke in PUT request
    // verify PUT request

    //Step 1: generate auth token

    @Test
    public void putRequest(){
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        String payloadAuth = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        r.body(payloadAuth);

        Response response = r.when().post();
        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

        //Extract token
        String token = response.then().extract().path("token");

        //Step - 2 : Post request to create booking

        String payloadPost = "{\n" +
                "    \"firstname\" : \"Priyanka\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("/booking");
        r.body(payloadPost);
        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);

        Integer bookingid = response.then().extract().path("bookingid");

        //Step 3: Token & ID are available
        //Change the name in payload & PUT

        String payloadPut = "{\n" +
                "    \"firstname\" : \"Amit\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("/booking/"+bookingid);
       r.body(payloadPut);
       r.cookie("token",token);
        response = r.when().put()   ;
        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Amit"));
    }
}
