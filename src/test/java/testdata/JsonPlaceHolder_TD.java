package testdata;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolder_TD {

    public Map<String, Object> outerDataMap(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("userId", userId);
        expectedMap.put("title", title);
        expectedMap.put("completed", completed);

        return expectedMap;

    }

        public Map<String, Object> outerDataMissingMap(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedMissingMap = new HashMap<>();
        if (userId!= null) {expectedMissingMap.put("userId",userId);}
        if (title!= null) {expectedMissingMap.put("title",title);}
        if (completed!= null) {expectedMissingMap.put("completed",completed); }
        return expectedMissingMap;}


}