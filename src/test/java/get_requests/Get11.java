package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
       /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Aalok Acharya DDS", "Agastya Somayaji", "Acharyasuta Chattopadhyay DC" are among the users
        And
            The female users are more than or equals to male users
     */

    @Test
    public void get11(){
        //set the Url
        spec.pathParam("first","users");

        //2. Step: Set the expected data

        //3. Step: Send the Request get the Response
       Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. STep: Do Assertion

        response.then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                      "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data.id",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Adhrit Dutta", "Gopi Kakkar", "Aamod Kaniyar"));

        JsonPath json=response.jsonPath();
        List<String> genders = json.getList("data.gender");
        System.out.println(genders); // 7 male 3 female  var


        int numOfFemales=0;
        for (String w: genders) {
            if (w.equalsIgnoreCase("female")){
                numOfFemales++;
            }
        }
        System.out.println(numOfFemales); // 3

        assertTrue(numOfFemales<genders.size()-numOfFemales); // tum gender dan bayanlari cikarip erkekleri bulduk


// 2. Yol: Tum bayan ve baylari ayri ayri Grovy ile cekelim
        List<String>femaleList = json.getList("data.findAll{it.gender='female'}.gender"); // hepsini assign ederek female yazdirdik
        List<String>femaleList1 = json.getList("data.findAll{it.gender=='female'}.gender");// female olanlari getirdi

        System.out.println(femaleList);
        System.out.println(femaleList1);

        List<String>maleList = json.getList("data.findAll{it.gender=='male'}.gender");// female olanlari getirdi
        System.out.println(maleList);

        assertTrue(femaleList.size()<maleList.size());



    }


}
