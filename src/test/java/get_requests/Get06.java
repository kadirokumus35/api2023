package get_requests;

import base_urls.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkuBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/101
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
          {
            "firstname": "GGS",
            "lastname": "FINCH",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            }

        }
     */

    @Test
    public void Get06(){
        //1. Step: Set the Url
        spec.pathParams("first","booking","second",101);

        //2. Set the expected data

        //3. Step: Send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        // 1. yol
        response.then().
                assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("GGS"),
                        "lastname",equalTo("FINCH"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"));

    }
}
