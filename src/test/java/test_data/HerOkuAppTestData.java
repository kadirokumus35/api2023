package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String,String > bookingDatesSetUp(String checkin,String checkout){
        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);

        return bookingDatesMap;
    }

    public Map<String , Object> expectedDateSetUp(String firstname,String lastname,int totalprice,boolean depositpaid,Map<String,String>bookingdates){
        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);

        return expectedDataMap;

    }
    /*
    {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
     */
    public String expectedDataBookingDates(String checkin,String checkout){
        String expectedDataBooking ="\"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"";
        return expectedDataBooking;
    }

    public String expectedDataInBooking(String firstname,String lastname,String totalprice,
                                        String depositpaid, String bookingdates, String additionalneeds){
        String expectedData = " {\n" +
                "    \"firstname\":"+firstname+",  \n" +
                "    \"lastname\": "+lastname+",\n" +
                "    \"totalprice\": "+totalprice+", \n" +
                "    \"depositpaid\": "+depositpaid+", \n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": "+additionalneeds+"\n" +
                "}";
        return expectedData;
    }

}
