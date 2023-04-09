package post;

import base_urls.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends HerOkuBaseUrl {
         /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test
    public  void post02(){
        //1. Step: Set the Url
        spec.pathParam("first","booking");

        //2. Step: Set the expected Data
        HerOkuAppTestData herOkuApp=new HerOkuAppTestData();
        Map<String,String>bookingMap=herOkuApp.bookingDatesSetUp("2021-09-09", "2021-09-21");
        Map<String,Object>expectedMap=herOkuApp.expectedDateSetUp("John", "Doe", 11111, true, bookingMap);

        //3. Step: Send the Post Request get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedMap).when().post("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion
        Map<String,Object> actualMap = response.as(HashMap.class);
        assertEquals(200,response.statusCode());

        assertEquals(expectedMap.get("firstname"),((Map)actualMap.get("booking")).get("firstname"));
        assertEquals(expectedMap.get("lastname"), ((Map) actualMap.get("booking")).get("lastname"));
        assertEquals(expectedMap.get("totalprice"), ((Map) actualMap.get("booking")).get("totalprice"));
        assertEquals(expectedMap.get("depositpaid"), ((Map) actualMap.get("booking")).get("depositpaid"));
        assertEquals(expectedMap.get("depositpaid"), ((Map) actualMap.get("booking")).get("depositpaid"));

        assertEquals(bookingMap.get("checkin"), ((Map) ((Map) actualMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingMap.get("checkout"), ((Map) ((Map) actualMap.get("booking")).get("bookingdates")).get("checkout"));


    }


}
