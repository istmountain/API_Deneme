package stepdefinitions;
import baseUrl.HerokuappBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import pojos.HerokuBookingdates_pojo;
import pojos.HerokuappResponse_pojo;
import pojos.HeroukappBooking_pojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HeroukappPojo_SD extends HerokuappBaseUrl {

       @And("Request body firstname {string},lastname {string}, totalprice {int}, depositpaid true , bookingdates checkin checkout additionalneeds {string}")
       public void FirstLastpriceDepositTrueBookingdatesAdditionalneeds(String firstname, String lastname, int totalprice, String additionalneeds) {
        spec=spec.pathParam("1","booking");
           HerokuBookingdates_pojo bookingdates=new HerokuBookingdates_pojo("2021-09-21","2021-12-21");
        HeroukappBooking_pojo bookingpojo=new HeroukappBooking_pojo(firstname,lastname,totalprice,true,bookingdates,additionalneeds);
           System.out.println(bookingpojo);
        response=given().spec(spec).contentType(ContentType.JSON).body(bookingpojo).when().post("/{1}");


        HerokuappResponse_pojo bookingResponsepojo= response.as(HerokuappResponse_pojo.class);

           System.out.println(bookingResponsepojo);

           assertEquals(bookingpojo.getFirstname(),bookingResponsepojo.getBooking().getFirstname());
           assertEquals(bookingdates.getCheckin(),bookingResponsepojo.getBooking().getBookingdates().getCheckin());
           assertEquals(200,response.getStatusCode());
           assertEquals(bookingpojo.isDepositpaid(),bookingpojo.isDepositpaid());




    }

    @And("HTTP Status Code should be {int} Herokuapp pojo")
    public void httpStatusCodeShouldBeHerokuapppojo(int StatusCode) {

    }

    @And("Request body bookingid {int},booking, firstname {string},lastname {string}, totalprice {int}, depositpaid true , bookingdates checkin checkout additionalneeds {string}")
    public void requestBodyBookingidBookingFirstnameLastnameTotalpriceDepositpaidTrueBookingdatesCheckinCheckoutAdditionalneeds(int arg0, String arg1, String arg2, int arg3, String arg4) {
    }

    @And("endpointi {string} uzantisini ekler heroukapp pojo")
    public void endpointiUzantisiniEklerHeroukappPojo(String uzanti1) {
        spec.pathParam("1", uzanti1);

       }

    @When("I send Get Request to the Url herokuapp pojo")
    public void ıSendGetRequestToTheUrlHerokuappPojo() {

    }



    @And("Response body firstname {string}, lastname {string}, totalprice {int}, depositpaid true,additionalneeds {string} bookingdates checkin {string}, checkout: {string}")
    public void FirstLastpricepaidTrueAdditionalBookingdatesCheckinCheckout(String firstname, String lastname, int totalprice, String aditionalneeds, String checkin, String checkout) {
          HerokuBookingdates_pojo bookingdates=new HerokuBookingdates_pojo(checkin,checkout);
          HeroukappBooking_pojo expectedPojo=new HeroukappBooking_pojo(firstname,lastname,totalprice,true,bookingdates,aditionalneeds);

          System.out.println(expectedPojo);
          response=given().spec(spec).when().get("/{1}/{2}");
          HeroukappBooking_pojo actualPojo= response.as(HeroukappBooking_pojo.class);
        System.out.println(actualPojo);
        assertEquals(bookingdates.getCheckout(),actualPojo.getBookingdates().getCheckout());
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedPojo,actualPojo);







       }

    @And("endpointi {string} ve {int}  uzantisini ekler heroukapp pojo")
    public void endpointiVeUzantisiniEklerHeroukappPojo(String uzanti1, int uzanti2) {
      spec.pathParams("1",uzanti1,"2",uzanti2);

       }
}
