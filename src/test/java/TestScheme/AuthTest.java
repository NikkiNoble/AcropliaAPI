package TestScheme;

import TestHelpers.DataHelper;
import TestHelpers.TestHelperURIData;
import TestHelpers.TestHelperBodyData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.path.json.JsonPath.from;

public class AuthTest {
    private static Response returnResponseSignIn() {
        return RestAssured.given().spec(SpecBuilder.requestSpec).body(TestHelperBodyData.userInfoBody)
                .when().post(TestHelperURIData.USERS_SESSIONS);
    }
    public static void signInWithEmailPassword() {
        Response response = returnResponseSignIn();
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.user.displayName", equalTo(DataHelper.userDisplayName));
    }
    static String getAccessToken() {
        Response response = returnResponseSignIn();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.accessToken");
    }
    public static String getUUID() {
        Response response = returnResponseSignIn();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.user.uuid");
    }
    public static void signInWithPhonePassword() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpec).body(TestHelperBodyData.userInfoPhone)
                .when().post(TestHelperURIData.PHONE);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.user.displayName", equalTo(DataHelper.phoneUserName));
    }
    public static void signInWithMagicLink() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpec).body(TestHelperBodyData.userInfoBody)
                .when().post(TestHelperURIData.MAGIC);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void signInWithMagicLinkPhone() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpec).body(TestHelperBodyData.userLinkPhone)
                .when().post(TestHelperURIData.MAGIC_PHONE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void signInWithMagicLinkEmail() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpec).body(TestHelperBodyData.userLinkEmail)
                .when().post(TestHelperURIData.MAGIC_EMAIL);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void signInUnsuccessful() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpec).body(TestHelperBodyData.userInfoBodyWrong)
                .when().post(TestHelperURIData.USERS_SESSIONS);
        response.then().spec(SpecBuilder.responseSpecUnauth)
                .body(containsString("Credentials are wrong"));
    }
}
