package stepdefinitions;

import baseUrl.HerokuappBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import testdata.Heroukapp_TD;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class Herokuapp_SD extends HerokuappBaseUrl {


    @Given("kullanici herokuapp {string} anasayfasinda")
    public void kullaniciHerokuappAnasayfasinda(String arg0) {

    }

    @And("endpointi {string} uzantisini ekler heroukapp")
    public void endpointiUzantisiniEklerHeroukapp(String uzanti1) {
       spec.pathParam("1", uzanti1);

    }

    @When("User send a request to the URL")
    public void userSendARequestToTheURL() {
        response.prettyPrint();
    }



    @When("endpointi {string} olan herokuapp sitesi firstname {string} lastname {string}")
    public void endpointiOlanHerokuappSitesiFirstnameLastname(String uzanti1, String firstname, String lastname) {
        spec.pathParam("1", uzanti1).queryParams("firstname", firstname, "lastname", lastname);
        response = given().spec(spec).when().get("/{1}");
        response.prettyPrint();

    }

    @And("firstname {string} lastname {string} var oldugunu dogrula")
    public void firstnameLastnameVarOldugunuDogrula(String firstname, String lastname) {

        response.asString().contains(firstname);
        response.asString().contains(lastname);
        response.body().asString().contains("6");
        response.then().headers("Connection", "keep-alive");


    }

    @And("HTTP Status Code should be {int} Herokuapp")
    public void httpStatusCodeShouldBeHerokuapp(int statuscode) {

        response.then().statusCode(statuscode);
    }


    @When("endpointi {string} ve {int} olan uzantiyi ekler heroukapp")
    public void endpointiVeOlanUzantiyiEklerHeroukapp(String uzanti1, int uzanti2) {

        spec.pathParams("1", uzanti1, "2", uzanti2);
        response = given().spec(spec).with().get("/{1}/{2}");
        response.prettyPrint();
    }


    @And("Response format should be {string} olmali herokuapp")
    public void responseFormatShouldBeOlmaliHerokuapp(String format) {
        response.then().assertThat().contentType(format);
    }

    @And("Response firstname {string},lastname {string}, totalprice {int} , depositpaid  true")
    public void responseFirstnameLastnameTotalpriceDepositpaidTrue(String firstname, String lastname, int totalprice) {
        response.then().body("firstname", equalTo(firstname), "lastname", equalTo(lastname),
                "totalprice", equalTo(totalprice), "depositpaid", equalTo(true));

        JsonPath json = response.jsonPath();

        json.getString("firstname");  //  bu bize firstnamenin valuesini getirir "Sally"
        json.getBoolean("depositpaid"); //bu bize true yada false dondurur

        assertEquals(firstname, json.getString("firstname"));
        assertEquals(true, json.getBoolean("depositpaid"));
        assertEquals(totalprice, json.getInt("totalprice"));

    }


    @And("bookingdates checkinDate {string},bookingdates checkoutDate {string}")
    public void bookingdatesCheckinDateBookingdatesCheckoutDate(String checkinDate, String checkoutDate) {
        response.then().body("bookingdates.checkin", equalTo(checkinDate), "bookingdates.checkout", equalTo(checkoutDate));

            /*
             json.getString("bookingdates.checkin");
             json.getString("bookingdates.checkout");
             assertEquals(checkinDate,json.getString("bookingdates.checkin"));
             assertEquals(checkoutDate,json.getString("bookingdates.checkout"));*/


    }


    @When("Response body firstname {string}, lastname {string},totalprice {int},depositpaid {string} additionalneeds {string} bookingdates {string}olmali")
    public void responseBodyFirstnameLastnameTotalpriceDepositpaidAdditionalneedsOlmali
            (String firstname, String lastname, Integer totalprice, String booleandepositpaid, String additionalneeds, String Map) {
      /*     {
               "firstname": "Dane",
               "lastname": "Sevilla",
               "totalprice": 111,
               "depositpaid": true,
               "bookingdates": {
                      "checkin": "2018-01-01",
                      "checkout": "2019-01-01"
           },
               "additionalneeds": "Breakfast"
}
        }*/

        // bu tur sorularda ilk yapacagimiz sey nested mepi halletmek
        //ic map
        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");
        // dis map

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("firstname", "Dane");
        expectedMap.put("lastname", "Sevilla");
        expectedMap.put("totalprice", 111);
        expectedMap.put("depositpaid", true);
        expectedMap.put("additionalneeds", "Breakfast");
        expectedMap.put("bookingdates", bookingdatesMap);
        //expectedMap.put("bookingdates.checkin","2018-01-01"); pass
        //expectedMap.put("bookingdates.checkout","2019-01-01"); pass

        System.out.println(expectedMap);

        response = given().spec(spec).when().get("/{1}/{2}");
        Map<String, Object> actualMap = response.as(HashMap.class);
        System.out.println(actualMap);
        assertEquals(expectedMap.get(firstname), actualMap.get(firstname));
        assertEquals(expectedMap.get(lastname), actualMap.get(lastname));
        assertEquals(expectedMap.get(totalprice), actualMap.get(totalprice));
        assertEquals(expectedMap.get(booleandepositpaid), actualMap.get(booleandepositpaid));
        assertEquals(expectedMap.get(additionalneeds), actualMap.get(additionalneeds));

        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualMap.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualMap.get("bookingdates")).get("checkout"));

        //  assertEquals(expectedMap.get("bookingdates.checkin"),actualMap.get("bookingdates.checkin"));
        // assertEquals(expectedMap.get("bookingdates.checkout"),actualMap.get("bookingdates.checkout"));

    }


    @And("Request body ekler firstname {string} lastname {string},totalprice {int}, depositpaid {string}")
    public void requestBodyEklerFirstnameLastnameTotalpriceDepositpaid(String firstname, String  lastname, int totalprice, String depositpaid) {

        Heroukapp_TD obje=new Heroukapp_TD();
        Map<String,String> bookingdates=obje.herokuappInnerData("2021-09-09","2021-09-21");
        Map<String,Object> expectedDataMap=obje.herokuappOuterData(firstname,lastname,totalprice,true,bookingdates);
        System.out.println(expectedDataMap);

        response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{1}");
        response.then().assertThat().statusCode(200);
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectedDataMap.get(firstname),actualDataMap.get(firstname));
        assertEquals(expectedDataMap.get(totalprice),actualDataMap.get(totalprice));
        assertEquals(expectedDataMap.get("bookingdates.checkin"),actualDataMap.get("bookingdates.checkin"));
         assertEquals(bookingdates.get("checkin"),((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        //  obje.herokuappOuterData(firstname,lastname,11111,true);

        //   response=given().spec(spec).contentType(ContentType.JSON).body()
    }


    @And("bookingdates checkin {string}, checkout {string} olmali herokuapp")
    public void bookingdatesCheckinCheckoutOlmaliHerokuapp(String checkin, String checkout) {

    }


}


