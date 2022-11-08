package stepdefinitions;

import baseUrl.RsflBookBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get04_SD extends RsflBookBaseUrl {

     @When("endpointi {string} olan herokuapp sitesi")
     public void endpointiOlanHerokuappSitesi(String uzanti1) {

     }
      @When("User send a request to the URL")
     public void userSendARequestToTheURL() {
        response.prettyPrint();
    }

    @When("endpointi {string} olan herokuapp sitesi firstname {string} lastname {string}")
    public void endpointiOlanHerokuappSitesiFirstnameLastname(String uzanti1, String firstname, String lastname) {
        spec.pathParam("1", uzanti1).queryParams("firstname",firstname,"lastname",lastname);
        response= given().spec(spec).when().get("/{1}");
        response.prettyPrint();

     }

    @And("firstname {string} lastname {string} var oldugunu dogrula")
    public void firstnameLastnameVarOldugunuDogrula(String firstname , String lastname) {

         response.asString().contains(firstname);
         response.asString().contains(lastname);
         response.then().body("bookingId",equalTo(6));

    }
}
