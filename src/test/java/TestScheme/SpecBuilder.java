package TestScheme;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.containsString;

class SpecBuilder {
    private static String uri = "https://app-dev.acroplia.com:8080/api/v1/";
    static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(uri)
            .setContentType(ContentType.JSON)
            .build();
    static RequestSpecification requestSpecFull = new RequestSpecBuilder()
            .addHeader("X-Auth-Token", AuthTest.getAccessToken())
            .setBaseUri(uri)
            .setContentType(ContentType.JSON)
            .build();
    static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    static ResponseSpecification responseSpecBody = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("true"))
            .build();
    static ResponseSpecification responseSpecUnauth = new ResponseSpecBuilder()
            .expectStatusCode(401)
            .build();
}
