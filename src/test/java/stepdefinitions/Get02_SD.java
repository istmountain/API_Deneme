package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Get02_SD {

          Response response;
          @Given("kullanici herokuapp {string} adresine gider")
          public void kullaniciHerokuappAdresineGider(String url) {
              String Url="https://restful-booker.herokuapp.com/booking/1";
              response=given().when().get(Url);
              response.prettyPrint();
         }

        @When("User sends a GET Request to the url herokuapp")
         public void userSendsAGETRequestToTheUrlHerokuapp() {

         }

       @Then("HTTP Status Code should be {int} olmali herokuapp")
       public void httpStatusCodeShouldBeOlmaliHerokuapp(int statusCode) {


          }

    @And("Status Line should be {string}  olmali herokuapp")
    public void statusLineShouldBeOlmaliHerokuapp(String statusLine) {
        response.then().assertThat().statusLine(statusLine);}


    @And("Response body {string}  icermeli herokuapp")
    public void responseBodyIcermeliHerokuapp(String responseBody) {
      assertTrue(response.asString().contains(responseBody));

     }

    @And("Response body {string} icermemeli heroukapp")
    public void responseBodyIcermemeliHeroukapp(String responseBody) {
     assertFalse(response.asString().contains(responseBody));

          }


       @And("Server {string} olmali herokuapp")
       public void serverOlmaliHerokuapp(String server) {
     assertTrue(response.asString().contains(server));

          }


}



