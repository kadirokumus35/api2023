package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get17 extends DummyRestApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/employee/1
       HTTP Request Method: GET Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "employee_name" is "Tiger Nixon"
              iii) "employee_salary" is 320800
               iv)  "employee_age" is 61
                v) "status" is "success"
               vi)  "message" is "Successfully! Record has been fetched."
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employee/1
    When
        user sends the get request
    Then
        Status code should be 200
    And
        "employee_name" should be "Tiger Nixon"
    And
        "employee_salary" should be 320800
    And
        "employee_age" should be 61
    And
        "status" should be "success"
    And
        "message" should be "Successfully! Record has been fetched."
     */

    @Test
    public void get17(){
        //set the url
        spec.pathParams("first","employee","second",1);

        //set the expected data
        //en iyi yontem  Objectmapper ile pojo classa dondurecegiz Responsemizi
        //boylelikle karsilastirma yapabilecegiz
        //oncelikle gerkhin language ile yazip Pojolarimizi olusturuyoruz. Once inner pojo ile basliyoruz
        DummyDataPojo dataPojo = new DummyDataPojo("Tiger Nixon", 320800, 61, "");
        DummyPojo expectedData = new DummyPojo("success",dataPojo,"Successfully! Record has been fetched.");

        //send the get request and get response
       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

       //do assertion
        response.then().assertThat().statusCode(200);

       DummyPojo actualData = JsonUtil.convertJsonToJavaObject(response.asString(),DummyPojo.class);
        System.out.println(actualData);


        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

        assertEquals(expectedData.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getData().getProfile_image(),actualData.getData().getProfile_image());


    }


}
