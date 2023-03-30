
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get02 {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

        @Test
        public void get02() {

            // set the url
            String url = "https://restful-booker.herokuapp.com/booking/422";

            // set the expected data (POST-PUT-PATCH)

            // type code to send request

            Response response=given().when().get(url);

            // response print
            response.prettyPrint();
            // do assertion
            response.then().assertThat().statusCode(404).
                    contentType("application/json").statusLine("HTTP/1.1 404 Not Found");
            // response body de bulunan spesifik bir veri nasil assert edilir
            assertTrue(response.asString().contains("Not Found"));
            // asString olarak almamiz gerekiyor.

            // response body de spesifik bir verinin bulunmadigini nasil asserrt ederiz
            // assertFalse() methodu parantez icindeki deger false ise testi gecirir

            Assert.assertFalse(response.asString().contains("kadir"));

            // header icinde server kismini ariyoruz
            assertEquals("cowboy",response.header("Server"));

        }
}
