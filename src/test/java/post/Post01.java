package post;

import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonBaseUrl {
         /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)
        When
            I send POST Request to the Url
        Then
            Status code is 201 {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01(){
        //Set the URL
        spec.pathParam("first","todos");

        //Set the expected Data
        JsonTestData expectedData = new JsonTestData();
       Map<String,Object> expectedDataMap = expectedData.expectedDataWithAllKeys(55,"Tidy your room",false);

       //sen Post request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();

        //assertion
        Map<String,Object> actualMap = response.as(HashMap.class);
        assertEquals(expectedDataMap.get("userId"),actualMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualMap.get("completed"));

    }

}
