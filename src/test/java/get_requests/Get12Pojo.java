package get_requests;

import base_urls.HerOkuBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends HerOkuBaseUrl {
       /*
            Given
                https://restful-booker.herokuapp.com/booking/18
            When
                 I send GET Request to the URL
             Then
                 Status code is 200
             And
                 Response body is like {
                           {
                                 "firstname": "Jone",
                                 "lastname": "Doe",
                                 "totalprice": 111,
                                  "depositpaid": true,
                                "bookingdates": {
                                               "checkin": "2018-01-01",
                                                  "checkout": "2019-01-01"
                                               },
                                "additionalneeds": "Extra pillows please"
                            }
         */
    @Test
    public void Get12Pojo(){
        //1.step set the url
        spec.pathParams("first","booking","second",18);

        //2.step set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo bookingPojo = new BookingPojo("Jane","Doe",111,true,bookingDatesPojo,"Extra pillows please");

        //3.step send the request and get the response
      Response response =  given().spec(spec).when().get("/{first}/{second}");

      //4.step Do Assertion
       BookingPojo actualPojo = response.as(BookingPojo.class);
       assertEquals(200,response.getStatusCode());

       assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
       assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());
       assertEquals(bookingPojo.getTotalprice(),actualPojo.getTotalprice());
       assertEquals(bookingPojo.getDepositpaid(),actualPojo.getDepositpaid());
       assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
       assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());
       assertEquals(bookingPojo.getAdditionalneeds(),actualPojo.getAdditionalneeds());

       assertEquals(bookingDatesPojo.getCheckin(),bookingDatesPojo.getCheckin());
       assertEquals(bookingDatesPojo.getCheckout(),bookingDatesPojo.getCheckout());

    }

}
