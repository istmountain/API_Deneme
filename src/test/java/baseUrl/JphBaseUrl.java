package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JphBaseUrl {


    protected Response response;
    protected RequestSpecification spec=

            new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();







}






