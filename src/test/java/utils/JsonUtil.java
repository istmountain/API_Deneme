package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

     static {

         mapper =new ObjectMapper();

     }
     public static int hakan(int sayi1, int sayi2){

         int sayi3=sayi2*sayi1;
         // asagidaki ile kiyasladigimizda buradaki int ile sagidaki <T> aynisi yanindaki T ise bizim konteynir
      // parametreler ise buradaki iki integer parametre almis asagidaki ise bir String parametre almis
      // burada yapmamiz gereken jason formati oncelikle Stringe cevirip ilk parametre olara almak gideri ise degisken
      // bu string olabilir Integer olabilir sonucta bunun bos datasi null dur Object kullanmadik cunku object
      // bizi kisitliyor cok az sekilde o classtan yararlanabiliyoruz. yani asagidaki methodda amacimiz Json u
      // once stringe cevirip onu deserialize etmek fakat bu istedigimiz sekilde datayai bize gonderecek
      // asagidaki Class<T> bizim istedigimiz herhangi bir data turu map pojo gibi
      // bastaki static block bu method her calistiginda ObjectMapper classi icin hazir bir sekilde bekliyor demektir
      // yani bu method calismadan once mapper hazir hale geliyor  ve readvalue ile jsonu istenen classa ceviriyor
         // asagidaki methot turune jeneric method denir data tip sonradan belirleniyor
      return sayi3;
     }

    public static <T> T convertJsontoJava(String json,Class<T> cls )  {

       T javaResult=null;
        try {
          javaResult=  mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

       return javaResult;
    }
         // 2. method serialization javayi Jsona cevirme

        public static String convertJavaToJson(Object obj){
        // burada ise java yi map pojo .. jsona ceviriyoruz. bize bir string olarak yazdirmasi gerekiyor
            // bu yuzden methodumuz String donduruyor.   bos bir String veriable olusturuyoruz
            // mapper objesi bu defa obj() bizim verecegimiz obj pojo map ... onu string olarak okuyacak
            // boylece Objecti jsona cevirmis olacagiz
         String jsonResult=null;
            try {
                jsonResult=mapper.writeValueAsString(obj);
            } catch (IOException e) {
                e.printStackTrace();
            }

         return jsonResult;
        }

}
