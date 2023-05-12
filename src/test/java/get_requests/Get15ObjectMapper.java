package get_requests;

import base_urls.HerOkuBaseUrl;
import org.junit.Test;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;

public class Get15ObjectMapper extends HerOkuBaseUrl {

        /*
            Given
                    https://restful-booker.herokuapp.com/booking/22
            When
                     I send GET Request to the URL
            Then
                     Status code is 200
             {
                    "firstname": "Josh",
                    "lastname": "Allen",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                                        "checkin": "2018-01-01",
                                            "checkout": "2019-01-01"
                                     },
                     "additionalneeds": "super bowls"
                }
         */

    @Test
    public void Get01(){
        //1.step set the urk
        spec.pathParams("first","booking","second",22);

        //2.step set the expected data
        String expectedData="";
        JsonUtil.convertJsonToJavaObject()
    }


}
