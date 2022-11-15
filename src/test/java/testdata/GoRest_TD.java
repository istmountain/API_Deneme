package testdata;

import java.util.HashMap;
import java.util.Map;

public class GoRest_TD {

    public Map<String,String> outerDataMap(String name,String email,String gender,String status ){

  Map<String,String> dataMap=new HashMap<>();
  dataMap.put("name",name);
  dataMap.put("email",email);
  dataMap.put("gender",gender);
  dataMap.put("status",status);

   return dataMap;
    }


 public Map <String,Object>allDataMap(Object meta, Map<String, String> data){

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("meta",meta);
        expectedData.put("data",data);

return  expectedData;
 }

}
