package get_requests;

import base_urls.HerOkuBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05  extends HerOkuBaseUrl {
         /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Adamz" and last name is "Dear"
     */

    @Test
    public void get05(){
        //1. Step: Set the Url

        //https://restful-booker.herokuapp.com/booking?firstname=Aaron&lastname=Chen
        spec.pathParam("first","booking").
                queryParams("firstname","Mark",
        "lastname","Jones");


        //2. Step: Set the expected data

        //3. Step: Send the request and get the response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4.step : do assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains(": 6"));


    }
}
