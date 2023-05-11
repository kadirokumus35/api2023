package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
         /*
            Given

            When
                User send GET Request to the URL
            Then
                Status Code should be 200
            And
            https://gorest.co.in/public/v1/users/560415
                Response body should be like
               {
                    "meta": null,
                     "data": {
                                    "id": 1560415,
                                    "name": "Ujjawal Banerjee CPA",
                                    "email": "banerjee_cpa_ujjawal@fahey.test",
                                     "gender": "female",
                                    "status": "active"
                                }
                }
        */

    @Test
    public void Get13Pojo(){
        //1.step set the url
        spec.pathParams("first","users","second",560415);

        //2.step set the expected data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(1560415,"Ujjawal Banerjee CPA","banerjee_cpa_ujjawal@fahey.test","female","active");
        GoRestResponseBodyPojo goRestResponseBodyPojo = new GoRestResponseBodyPojo(null,goRestDataPojo);

        //3.step send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

        //4.step Do Assertion
        GoRestResponseBodyPojo actualBody = response.as(GoRestResponseBodyPojo.class);

        assertEquals(200,response.getStatusCode());


        assertEquals(goRestResponseBodyPojo.getMeta(),actualBody.getMeta());
        assertEquals(goRestResponseBodyPojo.getData().getId(),actualBody.getData().getId());
        assertEquals(goRestResponseBodyPojo.getData().getName(),actualBody.getData().getName());
        assertEquals(goRestResponseBodyPojo.getData().getEmail(),actualBody.getData().getEmail());
        assertEquals(goRestResponseBodyPojo.getData().getGender(),actualBody.getData().getName());
        assertEquals(goRestResponseBodyPojo.getData().getStatus(),actualBody.getData().getStatus());
    }

}
