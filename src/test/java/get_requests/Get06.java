package get_requests;


import base_urls.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

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
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice": 111,
                "depositpaid": true,
                        "bookingdates": {
                  "checkin": "2018-01-01",
                   "checkout": "2019-01-01"
                 },
                    "additionalneeds": "Extra pillows please"
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
                body("firstname",equalTo("Jane"),
                        "lastname",equalTo("Doe"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Extra pillows please"));

        //2.yol JSonPath class kullanilir
        JsonPath json=response.jsonPath();
        assertEquals("Jane",json.getString("firstname"));
        assertEquals("Doe", json.getString("lastname"));
        assertEquals(111, json.getInt("totalprice"));
        assertEquals(true, json.getBoolean("depositpaid"));
        assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", json.getString("bookingdates.checkout"));
        assertEquals("Extra pillows please", json.getString("additionalneeds"));


        //3. yol: soft assert
        // soft assert icin 3 adim izlenir

        //1) sofassert objesi olusturulur
        SoftAssert softAssert=new SoftAssert();

        //2) obje araciligiyla assert yapilir
        softAssert.assertEquals(json.getString("firstname"),"Jane","firstname uyusmadi");
        softAssert.assertEquals(json.getString("lastname"), "Doe", "lastname uyusmadi");
        softAssert.assertEquals(json.getInt("totalprice"), 111, "totalprice uyusmadi");
        softAssert.assertEquals(json.getBoolean("depositpaid"), true, "depositpaid uyusmadi");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2018-01-01", "checkin uyusmadi");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2019-01-01", "checkout uyusmadi");
        softAssert.assertEquals(json.getString("additionalneeds"),"Extra pillows please");


        //3) assertAll() methodu kullanılır. Aksi takdirde kod her zaman pass olur
        softAssert.assertAll();
    }
}
