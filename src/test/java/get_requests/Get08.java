package get_requests;

import base_urls.JsonBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonBaseUrl {
    // de -serialization : JSON formatından Java obejesine cevirme
    //serilazation : Java objesini  JSON formatina cevirme
    //2 turlu yapılır bunlar
    // Gson: Goole tarafindan üretilmistir
    //Object Mapper daha popüler**

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void Get08() {
        // set the url
        spec.pathParams("first", "todos", "second", 2);

        // 2. step : set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        expectedData.put("StatusCode", 200);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");

        //3.step. send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData = response.as(HashMap.class);

        //4.step do assertion
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        assertEquals(expectedData.get("StatusCode"), response.getStatusCode());
        assertEquals(expectedData.get("Via"), response.getHeader("Via"));
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));
    }


    @Test
    public void get02() {
        // set the url
        spec.pathParams("first","todos",
                "second",2);

        //2.step: set the expected data
        JsonTestData expectedData=new JsonTestData();
        Map<String,Object>expectedDataMap=expectedData.expectedDataWithAllKeys(1,"quis ut nam facilis et officia qui",false);
        expectedDataMap.put("StatusCode",200);
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server","cloudflare");
        System.out.println(expectedDataMap);

        //3.step. send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println(actualData);


        //4.step do assertion
        assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));

        assertEquals(expectedDataMap.get("StatusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));
    }

}
