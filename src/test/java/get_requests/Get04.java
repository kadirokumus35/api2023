package get_requests;


import base_urls.JsonBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;


public class Get04 extends JsonBaseUrl {
  /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url
       And
           Accept type is "application/json"
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           There should be 200 todos
       And
           "quis eius est sint explicabo" should be one of the todos title
       And
           2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04(){
        //1. Step: Set the Url

        spec.pathParam("tek ekleme var zaten","todos");

        //2. Step: Set the expected data

        //3. Step: Set the request and get response

        Response resp=given().spec(spec).accept(ContentType.JSON).when().get("/{tek ekleme var zaten}");
        resp.prettyPrint();

        //4. Step: Do Assertion
        resp.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasItem(200),
                        "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2, 7, 9));
    }
}
