package testdata;

import java.util.HashMap;
import java.util.Map;

public class Heroukapp_TD {

       public Map<String,Object> herokuappOuterData(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates){

    Map<String,Object> herokuapppost=new HashMap<>();

           herokuapppost.put("firstname",firstname);
           herokuapppost.put("lastname",lastname);
           herokuapppost.put("totalprice",totalprice);
           herokuapppost.put("depositpaid",depositpaid);
           herokuapppost.put("bookingdates",bookingdates);

           return  herokuapppost;
       }

     public Map<String,String> herokuappInnerData(String checkin,String checkout){

           Map<String,String> bookingdates=new HashMap<>();

           bookingdates.put("checkin",checkin);
           bookingdates.put("checkout",checkout);


         return bookingdates;
   }

}
