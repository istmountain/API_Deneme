package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GorestBaseUrl {

    protected Response response;
    protected RequestSpecification spec=

            new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();
}
