package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    Api otomasyonu icin Rest-Assured Library kullaniyoruz
    a) gereksinimleri anlama
    b) test case'i yazma
        i)Gherkin Language kullaniyoruz
            x)Given : On kosullar
            y)When : Aksiyonlar => Get,Put,Post ...
            z)Then : Assert ..
            t)And : Coklu islemler
    c) Testing kodunun yazimi

         i) Set the Url
        ii) Set the expected data(POST-PUT-PATCH)
       iii) Type code to send request
        iv) Do Assertion
     */

    /*
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

   @Test
    public void get01(){
      // i) Set the Url
      String url = "https://restful-booker.herokuapp.com/booking/33";
       // ii) Set the expected data(POST-PUT-PATCH)
      // iii) Type code to send request
       Response response = given().when().get(url);
        response.prettyPrint();
      // iv) Do Assertion
        response.then().assertThat()
                .statusCode(200).contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");

        // status code nasil yazdirilir
       System.out.println("Status Code : "+response.statusCode());

       // Content Type nasil yazdirilir
       System.out.println("Content Type : "+response.contentType());


       // Time
       System.out.println(response.getTime());

   }
}
