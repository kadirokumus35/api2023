package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

  private static ObjectMapper mapper;

  static {
      mapper=new ObjectMapper();
  }


  //1.method : Json datasini Java objesine ceviriir (De-Serilazition)

    public static <T> T convertJsonToJavaObject(String json,Class<T> cls){//Generic Method=>Her turlu data turuyle calisan methoda denir
      T javaresult = null;

        try {
            javaresult = mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaresult;

    }


    //2.method : Java datasini Json objesine ceviriir (Serilazition)




}
