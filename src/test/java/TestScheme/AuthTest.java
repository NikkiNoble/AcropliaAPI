package TestScheme;

import TestHelpers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.path.json.JsonPath.from;

public class AuthTest {
    private static User passUser = new User();
    private static Response returnResponseSignIn() {
        passUser.setEmail(DataHelper.userMail);
        passUser.setPassword(DataHelper.userPassword);
        return RestAssured.given().spec(SpecBuilder.requestSpec)
                .body(passUser)
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
    static String getUUID() {
        Response response = returnResponseSignIn();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.user.uuid");
    }
    public static void signInWithPhonePassword() {
        passUser.setPhone(DataHelper.userPhone);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpec)
                .body(passUser)
                .when().post(TestHelperURIData.PHONE);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.user.displayName", equalTo(DataHelper.phoneUserName));
    }
    public static void signInWithMagicLink() {
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpec)
                .body(passUser)
                .when().post(TestHelperURIData.MAGIC);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void signInWithMagicLinkPhone() {
        passUser.setPhone(DataHelper.userPhone);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpec)
                .body(passUser)
                .when().post(TestHelperURIData.MAGIC_PHONE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void signInWithMagicLinkEmail() {
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpec)
                .body(passUser)
                .when().post(TestHelperURIData.MAGIC_EMAIL);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void signInUnsuccessful() {
        User wrUser = new User();
        wrUser.setEmail(DataHelper.userMail);
        wrUser.setPassword(DataHelper.userPasswordWrong);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpec)
                .body(wrUser)
                .when().post(TestHelperURIData.USERS_SESSIONS);
        response.then().spec(SpecBuilder.responseSpecUnauth)
                .body(containsString("Credentials are wrong"));
    }
    public static void createAndDeleteContact() {
        JSONArray contactList = new JSONArray();
        JSONObject parentData = new JSONObject();
        JSONObject childData = new JSONObject();
        childData.put("userName", DataHelper.otherUserName)
                .put("uuid", DataHelper.userID);
        parentData.put("user", childData);
        contactList.put(parentData);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(String.valueOf(contactList))
                .when().post(TestHelperURIData.CONTACTS);
        response.then().spec(SpecBuilder.responseSpec);
        Response delResponse = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.DEL_CONTACT);
        delResponse.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void generateAvatar() {
        passUser.setFirstName(DataHelper.testName);
        passUser.setLastName(DataHelper.testLastName);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(passUser)
                .when().post(TestHelperURIData.AVATAR);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.type", equalTo("IMAGE"));
    }
}

