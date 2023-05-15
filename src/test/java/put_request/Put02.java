package put_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
      /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
        */
        /*
          Given

                https://dummy.restapiexample.com/api/v1/update/21
                {
                 "employee_name": "Tom Hanks",
                 "employee_salary": 111111,
                 "employee_age": 23,
                 "profile_image": "Perfect image"
                }

           When
                   User send the PUT request
           Then
                   Status code is 200
           And
                  Response body should be like the following
                 {
                    "status": "success",
                    "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                             },
                     "message": "Successfully! Record has been updated."
                    }

     */
    @Test
    public void put02(){
        //set the url
        spec.pathParams("first","update","second",21);
        DummyDataPojo dummyDataPojo = new DummyDataPojo("Ali Can",111111,23,"Perfect image");
        DummyPojo expectedData = new DummyPojo("success",dummyDataPojo,"Successfully! Record has been updated.");

    Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyDataPojo).when().put("/{first}/{second}");
    response.prettyPrint();

      DummyPojo actualPojoData =  JsonUtil.convertJsonToJavaObject(response.asString(),DummyPojo.class);

      assertEquals(200,response.getStatusCode());
      assertEquals(expectedData.getStatus(),actualPojoData.getStatus());
      assertEquals(expectedData.getMessage(),actualPojoData.getMessage());

      assertEquals(dummyDataPojo.getEmployee_name(),actualPojoData.getData().getEmployee_name());
      assertEquals(dummyDataPojo.getEmployee_age(),actualPojoData.getData().getEmployee_age());
      assertEquals(dummyDataPojo.getEmployee_salary(),actualPojoData.getData().getEmployee_salary());
      assertEquals(dummyDataPojo.getProfile_image(),actualPojoData.getData().getProfile_image());
    }

}
