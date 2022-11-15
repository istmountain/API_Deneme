package stepdefinitions;
import baseUrl.JsonplaceholderBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojos.Jsonplaceholder_pojo;
import testdata.JsonPlaceHolder_TD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JsonPlsceHolder_SD extends JsonplaceholderBaseUrl {
    JsonPath json;
    JsonPlaceHolder_TD obje = new JsonPlaceHolder_TD();


    @Given("kullanici {string} jsonplaceholder anasayfasinda")
    public void kullaniciJsonplaceholderAnasayfasinda(String arg0) {


    }

    @When("endpointi {string} ve {int} olan uzantiyi ekler")
    public void endpointiVeOlanUzantiyiEkler(String uzanti1, int uzanti2) {
        spec.pathParams("1", uzanti1, "2", uzanti2);
    }

    @Then("User send GET Request to the URL")
    public void user_send_get_request_to_the_url() {
        response = given().spec(spec).get("/{1}/{2}");
        response.prettyPrint();
    }

    @And("HTTP Status Code should be {int} olmali jsonplaceholder")
    public void httpStatusCodeShouldBeOlmaliJsonplaceholder(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
        System.out.println(response.statusCode());

    }

    @And("Response format should be {string} olmali jsonplaceholder")
    public void responseFormatShouldBeOlmaliJsonplaceholder(String format) {
        response.then().assertThat().contentType(format);
    }


    @Then("title ise {string} olmali")
    public void title_ise_olmali(String title) {
        response.then().body("title", equalTo(title));

        //burada key value durumu sozkonusu
    }


    @And("userID {int} olmali")
    public void userıdOlmali(int userId) {

        response.then().body("userId", equalTo(userId));
    }

    @And("{string} ise false olmali")
    public void iseFalseOlmali(String gelenDeger) {
        response.then().body(gelenDeger, equalTo(false));

    }

    @And("completed ise {string} olmali")
    public void completedIseOlmali(String booleanDeger) {
        response.then().body("completed", equalTo(booleanDeger));
    }


    @And("titlelerden biri {string} olmali")
    public void titlelerdenBiriOlmali(String title) {
        response.then().body("title", hasItem(title));
        // hasitem contains methodu gibi
    }

    @And("userIds ler  {int}, {int}, and {int} olabilir")
    public void userıdsLerAndOlabilir(int userId1, int userId2, int UserId3) {
        response.then().body("id", hasItems(userId1, userId2, UserId3));
        //hasItems contains methodu ile ayni islemi goruyor

    }

    @And("Accept type is {string}")
    public void acceptTypeIs(String erisimTuru) {
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{1}");

    }

    @When("endpointi {string} a git jsonplaceholder")
    public void endpointiAGitJsonplaceholder(String uzanti1) {
        spec.pathParam("1",uzanti1);
    }

    @And("{int} tane todos olmali")
    public void taneTodosOlmali(int todosSayisi) {
        response.then().body("id", hasSize(todosSayisi));
        // hassize size methodu gibi
    }


    @And("Print all ids greater than {int} on the console")
    public void printAllIdsGreaterThanOnTheConsole(int tumIDSayisi) {

        json = response.jsonPath();

        // buradaki islem Jsonpath icinde liste alma  methodu var ve Groavy language kullaniyoruz yani
        // lambda gibi  lambdada  t kullaniyorduk buradada id kullaniyoruz yani bu classtaki this gibi bu classtaki id
        // gecerli  filtreleme yaptik ve bunu bir listeye koymamiz gerekiyor
        List<Integer> IDListesi = json.getList("findAll{it.id>190}.id");
        List<String> titleListesi = json.getList("findAll{it.id==190}.title"); //id si 190 olan title sini getir
        System.out.println(IDListesi);
        System.out.println(titleListesi);

    }

    @And("Assert that there are {int} ids greater than {int}")
    public void assertThatThereAreIdsGreaterThan(int IdSayisi, int IDSayisii) {


    }


    @And("Print all userIds whose ids are less than {int} on the console")
    public void printAllUserIdsWhoseIdsAreLessThanOnTheConsole(int userIDSayisi) {
        List<Integer> BestenKucukIDListesi = json.getList("findAll{it.id<5}.userId");
        System.out.println(BestenKucukIDListesi);
    }

    @And("Assert that the number of userIds whose ids are less than {int} is {int}")
    public void assertThatTheNumberOfUserIdsWhoseIdsAreLessThanIs(int IDsayisi1, int IDsayisi2) {

        List<Integer> Bestenkucuksayi = json.getList("findAll{it.id<5}.userId");
        assertTrue(5 > Bestenkucuksayi.size());
    }

    @And("Print all titles whose ids are less than {int}")
    public void printAllTitlesWhoseIdsAreLessThan(int idSayisi) {


    }

    @And("Assert that {string} is one of the titles whose id is less than {int}")
    public void assertThatIsOneOfTheTitlesWhoseIdIsLessThan(String title, int titleSayisi) {
        List<String> Bestenkucuksayititle = json.getList("findAll{it.id<5}.title");
        System.out.println(Bestenkucuksayititle);

        assertTrue(Bestenkucuksayititle.contains(title));
    }


    @And("userId is {int} , id is {int} title is {string} olmali completed is {string}")
    public void userıdIsIdIsTitleIsOlmaliCompletedIs(int userId, int idNo, String title, String completed) {

     /* 1. Yontem json=response.jsonPath();
     assertEquals(userId,json.getInt("userId"));
     assertEquals(idNo,json.getInt("id"));
     assertEquals(title,json.getString("title"));
     assertEquals(false,json.getBoolean("completed")); */

      /*2. Yontem
        response.then().assertThat().
                body("userId",equalTo(userId)).
                body("id",equalTo(idNo)).
                body("title",equalTo(title)).
                body("completed",equalTo(false));*/

    /* 3. Yontem simdi farkli bir methodla yapacagiz



        Map<String,Object> expectedMap=new HashMap<>();

        expectedMap.put("USERID",1);
       // expectedMap.put("Id",2); bunu eklemiyoruz cunku bunu sistemin kendisi atiyor
        expectedMap.put("title","quis ut nam facilis et officia qui");
        expectedMap.put("coMpleTed",false); // ilk ucu bizim body de olanlar body disinda olanlardan da ekleme yapabiliriz
        expectedMap.put("STATUSCODE",200); // burada ilk string kisim onemli degil onemli olan bunun bize gonderecegi value
        expectedMap.put("VIA","1.1 vegur");
        expectedMap.put("SERVER","cloudflare");

        // simdi expected datayi olusturacagiz
         response=given().when().spec(spec).when().get("/{1}/{2}"); // simdi bu response yi mapa cevirmek gerekiyor
         response.as(HashMap.class); //simdi artik topluca assert edebiliriz bunuda Mapa atamamiz gerekiyor
        Map<String,Object> actualMap= response.as(HashMap.class);

        assertEquals(expectedMap.get("USERID"), actualMap.get("userId"));
        assertEquals(expectedMap.get("USERID"), response.jsonPath().getInt("userId"));
        assertEquals(expectedMap.get("coMpleTed"), actualMap.get("completed"));
        assertEquals(expectedMap.get("STATUSCODE"),response.getStatusCode());
        assertEquals(expectedMap.get("VIA"), response.getHeader("Via"));
        assertEquals(expectedMap.get("SERVER"),response.getHeader("Server"));
        assertEquals(expectedMap.get("title"),actualMap.get("title"));*/

        // 4. Yontem simdi baska bir methodla yapacagiz
        response = given().when().spec(spec).when().get("/{1}/{2}");
        response.as(HashMap.class);
        HashMap actualMap = response.as(HashMap.class);
        System.out.println(actualMap);
        // {id=2, completed=false, title=quis ut nam facilis et officia qui, userId=1} bu sekilde bir format verdi

        JsonPlaceHolder_TD expectedData = new JsonPlaceHolder_TD();
        HashMap actualDataMap = response.as(HashMap.class);
        expectedData.outerDataMap(1, "quis ut nam facilis et officia qui", false);
        //bu data bize vauleleri veriyor
        Map<String, Object> expectedDataMap = expectedData.
                outerDataMap(1, "quis ut nam facilis et officia qui", false);
        expectedDataMap.put("StatusCode", 200);
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        System.out.println(expectedDataMap);
        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("userId"), response.jsonPath().getInt("userId"));
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("StatusCode"), response.getStatusCode());
        assertEquals(expectedDataMap.get("Via"), response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
    }

    @And("header  Via  is {string}  header Server is {string}")
    public void headerViaIsHeaderServerIs(String via, String server) {
        assertEquals(response.header("Via"), via);
        assertEquals(response.header("Server"), server);
    }


    @Then("User {string} send GET Request to the URL")
    public void userSendGETRequestToTheURL(String uzanti1) {
        response = given().spec(spec).when().get("/{1}");
        //   response.prettyPrint();

    }


    @When("I send POST Request to the Url user Id {int},title{string},completed {string} jsonplaceholder")
    public void ıSendPOSTRequestToTheUrlUserIdTitleCompletedJsonplaceholder(int userid, String title, String completed) {

       Map<String,Object> expecteddata= obje.outerDataMap(userid,title,false);


    }

    @And("Response body is like UserId {int} ,title {string} completed {string}")
    public void responseBodyIsLikeUserIdTitleCompleted(int userid, String title, String completed) {
        Map<String,Object> expecteddata= obje.outerDataMap(userid,title,false);
        response = given().spec(spec).contentType(ContentType.JSON).body(expecteddata).when().post("/{1}");
        response.then().assertThat().statusCode(201);
        response.prettyPrint();
        HashMap actualdata=response.as(HashMap.class);

        assertEquals(expecteddata.get(userid),actualdata.get(userid));
        assertEquals(expecteddata.get(title),actualdata.get(title));
        assertEquals(expecteddata.get(completed),actualdata.get(completed));
        response.then().assertThat().statusCode(201);
        //assertEquals(expecteddata,actualdata); // bu hata verecek cunku sistem kendisi bir id atadi
    }

    @Given("kullanici {string} jsonplaceholder anasayfasinda put")
    public void kullaniciJsonplaceholderAnasayfasindaPut(String arg0) {

   //
    }

    @And("endpointi {string} ve {int}  olan uzantiyi ekler jsonplaceholder put")
    public void endpointiVeOlanUzantiyiEklerJsonplaceholderPut(String uzanti1, int uzanti2) {

     spec.pathParams("1",uzanti1, "2", uzanti2);




     //given().spec(spec).contentType(ContentType.JSON).body(...).when().put();

    }

    @When("userId {int}, title {string}. completed {string} olmali put jsonplaceholder")
    public void userıdTitleCompletedOlmaliPutJsonplaceholder(int userId, String title, String completed) {
        JsonPlaceHolder_TD obje = new JsonPlaceHolder_TD();
      Map<String,Object> expectedData=obje.outerDataMap(userId,title, false);
        System.out.println(expectedData);
      response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{1}/{2}");
      Map actualData=response.as(HashMap.class);
        System.out.println(actualData);
      response.then().assertThat().statusCode(200);
        assertEquals(expectedData.get(userId),actualData.get(userId));
    }




        @When("userId {int}, title {string}. completed {string} olmali patch jsonplaceholder")
        public void userıdTitleCompletedOlmaliPatchJsonplaceholder(Integer userId, String title, String completed) {
            JsonPlaceHolder_TD obje = new JsonPlaceHolder_TD();
            Map<String,Object> expectedData=obje.outerDataMissingMap(null,"yemek yap",false);
            System.out.println(expectedData);

            Map<String,Object> expectedDataasil= obje.outerDataMissingMap(userId,title,false);
            System.out.println(expectedDataasil);

            response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{1}/{2}");
            Map actualData=response.as(HashMap.class);
            System.out.println(actualData);
            response.then().assertThat().statusCode(200);
            response.prettyPrint();


            assertEquals(expectedData.get(null),actualData.get(userId));
            assertEquals(expectedData.get(title),actualData.get(title));
            assertEquals(expectedData.get(null),actualData.get(completed));


        }

    @When("I send DELETE Request to the Url delete")
    public void ıSendDELETERequestToTheUrlDelete() {

      response =given().spec(spec).delete("/{1}/{2}");
      Map<String,Object> actualMap=response.as(HashMap.class);

     Map<String,Object> expectedMap=new HashMap<>();
     assertEquals(expectedMap,actualMap);
     response.then().assertThat().statusCode(200);
     assertTrue(actualMap.size()==0);
     assertTrue(actualMap.isEmpty());


    }

    @Then("Status code is {int} put")
    public void statusCodeIsPut(int arg0) {

    }



    @And("Response body is {string} put")
    public void responseBodyIsPut(String arg0) {
    }


    @Given("kullanici {string} anasayfasinda jsonplaceholder")
    public void kullaniciAnasayfasindaJsonplaceholder(String arg0) {
    //
  
    }

    @And("I send post request  userId {int},title {string},completed false  jsonplaceholder")
    public void ıSendPostRequestUserIdTitleCompletedFalseJsonplaceholder(Integer userId, String title) {

        Jsonplaceholder_pojo pojo=new Jsonplaceholder_pojo(userId,title,false);
        response=given().spec(spec).contentType(ContentType.JSON).body(pojo).when().post("/{1}");
        response.prettyPrint();

         Jsonplaceholder_pojo pojo2=response.as(Jsonplaceholder_pojo.class);
         assertEquals(pojo.toString(),pojo2.toString());
         assertEquals(pojo.getUserId(),pojo2.getUserId());


    }


    @When("I send Get Request to the Url jsonplaceholder objectMapper")
    public void ıSendGetRequestToTheUrlJsonplaceholderObjectMapper() {

    }

    @And("Response body is like UserId {int} , id {int} ,title {string} completed true olmali")
    public void responseBodyIsLikeUserIdIdTitleCompletedTrueOlmali(int userId, int id, String title) {


        response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();
        



    }
}

