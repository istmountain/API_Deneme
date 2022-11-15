package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonplaceholderBaseUrl {


    protected Response response;
    protected RequestSpecification spec=

            new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();







}






