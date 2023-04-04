package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {
    /*
          Given
              https://gorest.co.in/public/v1/users/2986
          When
              User send GET Request to the URL
          Then
              Status Code should be 200
          And
              Response body should be like
          {
                   https://gorest.co.in/public/v1/users/674956
          "meta": null,
          "data": {
            "id": 674956,
            "name": "Vaishnavi Agarwal Sr.",
            "email": "agarwal_vaishnavi_sr@west.io",
            "gender": "male",
            "status": "active"
                    },
           }
       */

    @Test
    public void Get10(){
        //1. Step: Set the Url
        spec.pathParams("first","users","second",674956);

        //2. Step: Set the expected data
      /*  Map<String,String> dataKeyMap=new HashMap<>();
        dataKeyMap.put("name","Brahmanandam Nambeesan");
        dataKeyMap.put("email","brahmanandam_nambeesan@murray-weissnat.co");
        dataKeyMap.put("gender","male");
        dataKeyMap.put("status","active");
        System.out.println(dataKeyMap);
        */

        GoRestData goRestData=new GoRestData();//gerekli methodun cagrilmasi icin obj olusturduk
        Map<String,String> dataKeyMap=goRestData.dataKeyMap("Vaishnavi Agarwal Sr.",
                "agarwal_vaishnavi_sr@west.io",  "male","active");// ic Map olusturdum
        System.out.println(dataKeyMap);

        Map<String,Object> expectedData=goRestData.expectedDataMap(null,dataKeyMap);// ust Map olusturan method


        //3. Step: Send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
Map<String,Object> actualDataMap=response.as(HashMap.class);// De-Serilization=> JSondan Java objesine

        //4. Step: Do Assertion

        assertEquals(expectedData.get("name"),actualDataMap.get("meta"));
        assertEquals(expectedData.get("name"),((Map)actualDataMap.get("data")).get("name"));//once data elementine ulasip aldigim objeyi Map formatina cast ediyorum
        assertEquals(dataKeyMap.get("email"),((Map)actualDataMap.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"),((Map)actualDataMap.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"),((Map)actualDataMap.get("data")).get("status"));



    }


}
