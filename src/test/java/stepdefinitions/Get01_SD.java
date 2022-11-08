package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Get01_SD {


     Response response;

     @Given("kullanici  {string} adresine gider")
    public void kullaniciAdresineGider(String verilenUrl) {

        response = given().when().get(verilenUrl);
        response.prettyPrint();

        // bu aslinda bizim gonderdigimiz talebe bir yanit verecek

    }



    @When("User sends a GET Request to the url")  //actionlar get put post delete patch
    public void user_sends_a_get_request_to_the_url() {
        // 3. adim bu adimi simdilik atliyoruz
     }

    @Then("HTTP Status Code should be {int} olmali")
    public void httpStatusCodeShouldBeOlmali(int statusCode) {

        response.then().assertThat().statusCode(statusCode);
        System.out.println("Status Code :" + response.statusCode());
    }

    @Then("Content Type should be JSON") // icerik json mu
    public void content_type_should_be_json() {
        response.then().assertThat().contentType(ContentType.JSON);
        System.out.println("Content Type :" + response.contentType());
        System.out.println("Headers : \n" + response.headers());
        System.out.println();
        System.out.println(response.header("Via"));
        System.out.println("Get Time: " + response.getTime());
    }

    @And("Status Line should be {string}  olmali") // basarili mi son iki kisim then e ait  yani dogrulama
    public void statusLineShouldBeOlmali(String statusLine) {
        response.then().assertThat().statusLine(statusLine);
        System.out.println("Status Line :" + response.statusLine());

    }


}





