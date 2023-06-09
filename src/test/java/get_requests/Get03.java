package get_requests;

import base_urls.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.*;

public class Get03 extends HerOkuBaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */
    @Test
    public void get03(){
        //1. Step: Set the Url
        // String url = "https://jsonplaceholder.typicode.com/todos/23"; //Önerilmiyor.
        // biz extends ile child classimizdan ataya ulasip objeyi kullanabiliyoruz.
        spec.pathParams("first","todos","second",23);

        //2. Step: Set the expected data

        //3. Step: Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        //1. Yol
        response.then().statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        //2. Yol:
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
        "completed",equalTo(false),"userId",equalTo(2));

         /*
        Assertion yaparken Java çalimayi durdurdugunda hata sonrasi kodlar çalişmaz .
        hata sonrasi assertionlar hakkinda bilgi sahibi olunmaz
        fakat hata öncesi assertionlar gecmiştir

        eger kodumuzu hata noktasına kadar duracak sekilde yazarsak "hard assert" yapmis oluruz
        eger kodumuzu hata noktasına kadar durmayacak sekilde yazarsak "soft assert" yapmis oluruz

        eger coklu body() methodu icinde assert yaparsak "hard assert",
        eger tek body() methodu icinde assert yaparsak "soft assert" yapmis oluyoruz
         */
    }
}
