package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonTestData {

    public Map<String,Object> expectedDataWithAllKeys(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",userId);
        expectedData.put("title", title);
        expectedData.put("completed",completed);

        return expectedData;
    }

    public Map<String,Object> missDataKeys(Integer userId, String title, Boolean completed){
        Map<String,Object> missData=new HashMap<>();
        if (userId != null){
            missData.put("userId",userId);
        }
        if (title != null){
    missData.put("title",title);
        }
        if (completed != null){
    missData.put("completed",completed);
        }
        return  missData;
    }
}
