package testdata;

import baseUrl.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import org.junit.Test;
import pojos.Jsonplaceholder_pojo;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Postpojo1 extends JsonplaceholderBaseUrl {

    @Test
    public void Postpojo1(){

        Jsonplaceholder_pojo pojo=new Jsonplaceholder_pojo(55,"Tidy your room",false);
        spec.pathParam("1","todos");
        response=given().spec(spec).contentType(ContentType.JSON).body(pojo).when().post("/{1}");
        response.prettyPrint();

        Jsonplaceholder_pojo pojo2=response.as(Jsonplaceholder_pojo.class);

         assertEquals(pojo.getUserId(),pojo2.getUserId());
    }
}
