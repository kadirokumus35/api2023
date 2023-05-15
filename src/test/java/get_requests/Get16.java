package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get16 extends DummyRestApiBaseUrl {
          /*
              URL: https://dummy.restapiexample.com/api/v1/employees
              HTTP Request Method: GET Request
              Test Case: Type by using Gherkin Language

              Assert:  i) Status code is 200
                      ii) There are 24 employees
                     iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                      iv) The greatest age is 66
                       v) The name of the lowest age is "Tatyana Fitzpatrick"
                      vi) Total salary of all employees is 6,644,770
       */
    /*
    Given
         https://dummy.restapiexample.com/api/v1/employees
    When
        user send GET request to URL
    Then
        Status code is 200
    AND
         There are 24 employees
    AND
        "Tiger Nixon" and "Garrett Winters" are among the employees
    AND
        The greatest age is 66
    AND
        The name of the lowest age is "Tatyana Fitzpatrick"
    AND
        Total salary of all employees is 6,644,770


     */

    @Test
    public void get01(){
        // 1.step: set the url
        spec.pathParam("first","employees");
        //set the expected data

        //send the Get request and get the response
        Response response = given().spec(spec).when().get("{first}");
       // response.prettyPrint();

        // Do Assertion
        response.then().
                assertThat().
                statusCode(200).
                body("data.id",hasSize(24),
                        "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));

        // The greatest age is 66
        JsonPath json = response.jsonPath();
        List<Integer> ageList = json.getList("data.findAll{it.id>0}.employee_age");
        System.out.println(ageList);
        Collections.sort(ageList);
        System.out.println(ageList);
        System.out.println( ageList.get(ageList.size()-1));
        assertEquals(66,(int)ageList.get(ageList.size()-1));

    //   The name of the lowest age is "Tatyana Fitzpatrick"
        String grovvyString = "data.findAll{it.employee_age=="+ ageList.get(0)+"}.employee_name";
      String minEmployeeName =  json.getString(grovvyString);
       // String minEmployeeName =  json.getString("data.findAll{it.employee_age==19}.employee_name");
        System.out.println(minEmployeeName);

        assertEquals("[Tatyana Fitzpatrick]",minEmployeeName);


        //Total salary of all employees is 6,644,770
          List<Integer> salaryList = json.getList("data.findAll{it.id}.employee_salary");
        System.out.println(salaryList);


        //1.yol
        int sum = 0;
        for (int w:salaryList) {
            sum+=w;
        }
        System.out.println("total sum :"+sum);
        assertEquals(6644770,sum);

       //int sumLambda = salaryList.stream().reduce(0,(t,u)->t+u);
       int sumLambda = salaryList.stream().reduce(0,Math::addExact);
        assertEquals(6644770,sumLambda);
    }

}
