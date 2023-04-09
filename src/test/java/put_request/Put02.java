package put_request;

public class Put02 {
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
}
