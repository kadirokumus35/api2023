package delete_request;

import base_urls.JsonBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonBaseUrl {

        /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //1.step set the url
        spec.pathParams("first","todos","second",198);

        //2.Step set he expected data
        Map<String,Object> bosMap=new HashMap<>();

        //3.step send delete request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");//silme talebi gonderip response attik
        response.prettyPrint();

        // 4.step Do Assertion
        response.then().assertThat().statusCode(200);
        //bos map ile delete ile gelen bos Json assert edilmeli
        Map<String,Object> asilMap = response.as(HashMap.class);
        assertEquals(bosMap,asilMap);

        //2.yol
        assertTrue(asilMap.size()==0);
        assertTrue(asilMap.isEmpty());// tavsiye edilen

        //Delete request yapmadan önce "Post Request" yapıp o datayı silmeliyiz.
    }


}
