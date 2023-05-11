package post;

import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class Post03Pojo extends JsonBaseUrl {
  /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

@Test
    public void postPojo01(){
    //1.Step set the Url
    spec.pathParam("first","todos");

    //2.Step set the expected data
    JsonPlaceHolderPojo requestJsonPojo = new JsonPlaceHolderPojo(55,"Tidy your room",false);


    //3.Step send post request and get response
    Response response = given().spec(spec).contentType(ContentType.JSON).body(requestJsonPojo).when().post("/{first}");

    //4.Step Do assertion
    JsonPlaceHolderPojo actualBody = response.as(JsonPlaceHolderPojo.class);

    assertEquals(requestJsonPojo.getUserId(),actualBody.getUserId());
    assertEquals(requestJsonPojo.getTitle(),actualBody.getTitle());
    assertEquals(requestJsonPojo.getCompleted(),actualBody.getCompleted());




}
}
