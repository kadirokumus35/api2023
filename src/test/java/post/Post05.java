package post;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05 extends DummyRestApiBaseUrl {
     /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
       Test Case: Type by using Gherkin Language
       Assert:
                    {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                     }
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/create
         {
         "employee_name": "Tom Hanks",
         "employee_salary": 111111,
         "employee_age": 23,
         "profile_image": "Perfect image",
         "id": 4891
         }
    When
        User sends the POST Request
    Then
        Status code is 200
    And
         {
           "status": "success",
           "data": {
                    "employee_name": "Tom Hanks",
                     "employee_salary": 111111,
                     "employee_age": 23,
                      "profile_image": "Perfect image",
                      "id": 4891
                     },
            "message": "Successfully! Record has been added."
          }

     */

    @Test
    public void Post05(){
        //set the url
        spec.pathParam("first","create");
        //set the expected data
        DummyDataPojo dummyDataPojo = new DummyDataPojo("Tom Hanks",111111,23,"Perfect image");
        DummyPojo expectedData = new DummyPojo("success",dummyDataPojo,"Successfully! Record has been added.");
        //send the post request and get response
       Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyDataPojo).when().post("/{first}");
    response.prettyPrint();

    //Do Assertion
       DummyPojo actualPojo = JsonUtil.convertJsonToJavaObject(response.asString(),DummyPojo.class);
        System.out.println(actualPojo);

        assertEquals(expectedData.getStatus(),actualPojo.getStatus());
        assertEquals(expectedData.getMessage(),actualPojo.getMessage());

        assertEquals(dummyDataPojo.getEmployee_name(),expectedData.getData().getEmployee_name());
        assertEquals(dummyDataPojo.getEmployee_age(),expectedData.getData().getEmployee_age());
        assertEquals(dummyDataPojo.getEmployee_salary(),expectedData.getData().getEmployee_salary());
        assertEquals(dummyDataPojo.getProfile_image(),expectedData.getData().getProfile_image());
    }

}
