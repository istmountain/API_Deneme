package stepdefinitions;
import baseUrl.JphBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get03_SD  extends  JphBaseUrl{

    @Given("kullanici {string} anasayfasinda")
    public void kullanici_anasayfasinda(String string) {
        //
    }

    @When("endpointi {string} ve {int} olan uzantiyi ekler")
    public void endpointiVeOlanUzantiyiEkler(String uzanti1, int uzanti2) {
         spec.pathParams("1",uzanti1,"2",uzanti2);
    }

    @Then("User send GET Request to the URL")
    public void user_send_get_request_to_the_url() {
        response =given().spec(spec).get("/{1}/{2}");
        response.prettyPrint();
    }

    @Then("HTTP Status Code should be {int}")
    public void http_status_code_should_be(int statusCode) {

        response.then().assertThat().statusCode(statusCode);
        System.out.println(response.statusCode());
    }

    @Then("Response format should be {string} olmali")
    public void response_format_should_be_olmali(String format) {
        response.then().assertThat().contentType(format);

    }

    @Then("title ise {string} olmali")
    public void title_ise_olmali(String title) {
        response.then().body("title",equalTo(title));

        //burada key value durumu sozkonusu
    }


    @And("userID {int} olmali")
    public void userıdOlmali(int userId) {

        response.then().body("userId",equalTo(userId));

    }

    @And("{string} ise false olmali")
    public void iseFalseOlmali(String gelenDeger) {
    response.then().body(gelenDeger,equalTo(false));

    }

    @And("completed ise {string} olmali")

    public void completedIseOlmali(String booleanDeger) {
        response.then().body("completed",equalTo(booleanDeger));
    }

        @When("endpointi {string} a git")
        public void endpointiAGit(String uzanti1) {

            spec.pathParam("1",uzanti1);
        }

        @And("titlelerden biri {string} olmali")
        public void titlelerdenBiriOlmali(String title) {
        response.then().body("title",hasItem(title));
         // hasitem contains methodu gibi
    }

        @And("userIds ler  {int}, {int}, and {int} olabilir")
        public void userıdsLerAndOlabilir(int userId1, int userId2, int UserId3) {
         response.then().body("id",hasItems(userId1,userId2,UserId3));
         //hasItems contains methodu ile ayni islemi goruyor


        }

        @And("Accept type is {string}")
        public void acceptTypeIs(String erisimTuru) {
            response =given().spec(spec).accept(ContentType.JSON).when().get("/{1}");

    }

        @Then("User tek uzantili send GET Request to the URL")
        public void userTekUzantiliSendGETRequestToTheURL() {
            response =given().spec(spec).when().get("/{1}");
            response.prettyPrint();
        }

        @And("{int} tane todos olmali")
        public void taneTodosOlmali(int todosSayisi) {
        response.then().body("id",hasSize(todosSayisi));
            // hassize size methodu gibi
    }
    }
