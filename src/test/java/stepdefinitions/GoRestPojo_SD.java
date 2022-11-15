package stepdefinitions;

import baseUrl.GorestBaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pojos.GoRestPojo;
import pojos.GorestDataPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GoRestPojo_SD extends GorestBaseUrl {
    @Given("kullanici {string} anasayfasinda pojo")
    public void kullanici_anasayfasinda_pojo(String string) {
       //
    }
    @Given("endpointi {string} ve {int}  olan uzantiyi ekler goRest pojo")
    public void endpointi_ve_olan_uzantiyi_ekler_go_rest_pojo(String uzanti1, Integer uzanti2) {
       spec.pathParams("1",uzanti1,"2",uzanti2);
    }
    @When("HTTP Status Code should be {int} goRest pojo")
    public void http_status_code_should_be_go_rest_pojo(Integer statusCode) {


    }
    @When("Response data meta null id {int},name {string}, email {string} gender {string}, status {string}")
    public void response_meta_data_id_name_email_gender_status(Integer id, String name, String email, String gender, String status) {
        GorestDataPojo datapojo= new GorestDataPojo(id,name,email,gender,status);
        GoRestPojo expectedpojo= new GoRestPojo(null,datapojo);
        System.out.println(expectedpojo);

       response=given().spec(spec).when().get("/{1}/{2}");
       response.prettyPrint();

       GoRestPojo actualPojo=response.as(GoRestPojo.class);
        System.out.println(actualPojo);
        assertEquals(datapojo.getGender(),actualPojo.getData().getGender());
        assertEquals(200,response.getStatusCode());
        assertEquals(null,actualPojo.getMeta());
    }


}
