package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RsflBookBaseUrl {

    protected Response response;
    protected RequestSpecification spec=

            new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


}
