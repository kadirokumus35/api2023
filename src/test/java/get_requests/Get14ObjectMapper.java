package get_requests;

import base_urls.JsonBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonTestData;
import utils.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper extends JsonBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void Get14() {

        //1.step set the url
        spec.pathParams("first", "todos", "second", 198);

        //2.step set the expected data
        JsonTestData jsonTestData =new JsonTestData();
        String expectedData = jsonTestData.expectedDataInString(10,"quis eius est sint explicabo",true);
/*


        String expectedData = "{\n" +
                "  \"userId\": 10,\n" +
                "  \"id\": 198,\n" +
                "  \"title\": \"quis eius est sint explicabo\",\n" +
                "  \"completed\": true\n" +
                " }";


 */
        HashMap<String, Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        //3.step send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();
        //4step Do Assertion
        HashMap<String, Object> actualDataMap = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("id"), actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));

    }

    //en iyi yontem
    @Test
    public void Get02(){
        //1.step set the url
        spec.pathParams("first", "todos", "second", 198);

        //2.step set the expected data

        String expectedData = "{\n" +
                "  \"userId\": 10,\n" +
                "  \"id\": 198,\n" +
                "  \"title\": \"quis eius est sint explicabo\",\n" +
                "  \"completed\": true\n" +
                " }";

       JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);

        //3.step send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4step Do Assertion
        JsonPlaceHolderPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), JsonPlaceHolderPojo.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedDataPojo.getUserId(), expectedDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(), expectedDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(), expectedDataPojo.getCompleted());

    }

}
