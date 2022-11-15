package stepdefinitions;

import baseUrl.GorestBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import testdata.GoRest_TD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Gorest_SD extends GorestBaseUrl {

    @Given("kullanici {string} anasayfasinda")
    public void kullaniciAnasayfasinda(String arg0) {

     //
    }

    @And("endpoint  users {string} ve {int} girmeli")
    public void endpointUsersVeGirmeli(String uzanti1, int uzanti2) {

        spec=spec.pathParams("1","users","2",2965);



    }

    @When("User send GET Request to the URL gorest iki parametreli")
    public void userSendGETRequestToTheURLGorestIkiParametreli() {

        response =given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();

    }

    @Then("HTTP Status Code should be {int} gorest")
    public void HTTP_status_code_should_be_gorest(int statusCode) {

        response.then().assertThat().statusCode(200);
        System.out.println(response.statusCode());

    }

    @Then("Response body should be like meta {string} gorest")
    public void response_body_should_be_like_meta_gorest(String meta) {
    response.then().body(meta,equalTo(null));

    }



    @And("R body gorest data,id {int} name {string}, email {string}, gender {string}, status{string}")
    public void rBodyGorestDataIdNameEmailGenderStatus(int id, String name, String email, String gender, String status) {

         /*
        Map <String,String> innerMap=new HashMap<>();

        innerMap.put("name","Amarnath Dhawan Sr.");
        innerMap.put("email","dhawan_amarnath_sr@johnson-beer.info");
        innerMap.put("gender","female");
        innerMap.put("status","inactive");
        System.out.println(innerMap);

        Map<String,Object>expectedDataMap=new HashMap<>();
        expectedDataMap.put("meta",null);
        expectedDataMap.put("data",innerMap);
        expectedDataMap.put("StatusCode",200);
        System.out.println(expectedDataMap);


        HashMap actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);
        assertEquals(expectedDataMap.get("meta"),actualDataMap.get("meta"));
        assertEquals(expectedDataMap.get("data.name"),actualDataMap.get("data.name"));
        assertEquals(innerMap.get("name"),((Map)actualDataMap.get("data")).get("name"));;
        assertEquals(expectedDataMap.get("StatusCode"),response.getStatusCode());
          */



        GoRest_TD obje=new GoRest_TD();
       // obje.innerMapwithallkeys(name,email,gender,status);
        Map<String, String> innerDataKey=obje.outerDataMap("Mr. Gita Menon","gita_menon_mr@bayer.com","female","inactive");

        Map<String,Object> expectedDataMap=obje.allDataMap(null,innerDataKey);
        HashMap actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);
        System.out.println(expectedDataMap);
        assertEquals(expectedDataMap.get("meta"),actualDataMap.get("meta"));
        assertEquals(expectedDataMap.get("data.name"),actualDataMap.get("data.name"));
        assertEquals(innerDataKey.get(name),((Map)actualDataMap.get("data")).get("name"));




    }

    @And("endpoint  users {string}  girmeli")
    public void endpointUsersGirmeli(String uzanti1) {
        spec=spec.pathParams("1",uzanti1);


    }
    @Then("The value of pagination limit is {int}")
    public void theValueOfPaginationLimitIs(int sayi) {

        response.then().body("meta.pagination.limit",equalTo(sayi));
    }

    @And("The {string} should be {string}")
    public void theShouldBe(String arg0, String arg1) {


    }

    @And("The number of users should  be {int}")
    public void theNumberOfUsersShouldBe(int sayi) {

         response.then().body("data.id",hasSize(sayi));

    }

    @And("We have at least one {string} status")
    public void weHaveAtLeastOneStatus(String status) {

        response.then().body("data.status",hasItem(status));
    }

    @And("{string}, {string}, {string} are among the users")
    public void areAmongTheUsers(String user1, String user2, String user3) {
    response.then().body("data.name",hasItems(user1,user2,user3));

    }

    @And("The female users are less than male users")
    public void theFemaleUsersAreLessThanMaleUsers() {

        JsonPath json = response.jsonPath();
        List<String> genderlist = json.getList("data.gender");
        System.out.println(genderlist);

        int erkeksayisi = 0;
        int kadinsayisi = 0;
        for (int i = 0; i < genderlist.size(); i++) {
            if (genderlist.get(i).contains("male")) {

                erkeksayisi++;

            } else kadinsayisi++;
        }
        assertTrue(kadinsayisi < erkeksayisi);

        // 2. yol
       List<String>kadinlist= json.getList("data.findAll{it.gender=='female'}.gender");
        List<String>erkeklist= json.getList("data.findAll{it.gender=='male'}.gender");
        System.out.println(kadinlist);
        System.out.println(erkeklist);
        assertTrue(kadinlist.size()<erkeklist.size());
    }


    @When("User send GET Request to the URL gorest tek parametreli")
    public void userSendGETRequestToTheURLGorestTekParametreli() {

        response =given().spec(spec).when().get("/{1}");
        response.prettyPrint();


    }


    @And("The current link should be {string}")
    public void theCurrentLinkShouldBe(String currentlink) {
    response.then().
     body("meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"));
        JsonPath json =response.jsonPath();
        json.getString("meta.pagination.links.current");
     assertEquals(currentlink, json.getString("meta.pagination.links.current"));

    }


}
