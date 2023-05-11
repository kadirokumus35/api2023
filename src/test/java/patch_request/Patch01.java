package patch_request;

import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.JsonTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Patch01 extends JsonBaseUrl {
       /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/19
	        2) {
                 "title": "okumus"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    {
                                            "completed": false,
                                            "title": "kadir",
                                            "userId": 21,
                                             "id": 19
}
									   }
     */

    @Test
    public void Patch01(){
        // Set the url
        spec.pathParams("first","todos","second",19);
        // Set the Request Body
        JsonTestData json = new JsonTestData();
        Map<String,Object> request=json.missDataKeys(null,"okumus",null);
        // Send the Patch Request get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(request).when().patch("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion
        Map<String,Object> a = json.expectedDataWithAllKeys(21,"okumus",false);
        response.then().assertThat().statusCode(200).body("title",equalTo(a.get("title")),"userId",equalTo(a.get("userId")),"completed",equalTo(a.get("completed")));
    }
}
