package TestScheme;

import TestHelpers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.path.json.JsonPath.from;

public class NodesTest {
    private static Response returnResponseCreateTextPad() {
        User user = new User();
        user.setType(DataHelper.typesList.get(8));
        user.setTitle(DataHelper.textPadTitle);
        UserDetails userUUID  = new UserDetails();
        userUUID.setUuid(AuthTest.getUUID());
        user.setUser(userUUID);
        return RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(user)
                .when().post(TestHelperURIData.TEXT_PAD);
    }
    private static Response returnResponseCanvas() {
        User user = new User();
        user.setType(DataHelper.typesList.get(0));
        user.setTitle(DataHelper.canvasTitle);
        UserDetails userUUID  = new UserDetails();
        userUUID.setUuid(AuthTest.getUUID());
        user.setUser(userUUID);
        return RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(user)
                .when().post(TestHelperURIData.CANVASES);
    }
    private static void assertResult(Response response) {
        response.then().assertThat()
                .body("data.user.userName", equalTo(DataHelper.userName));
    }
    public static void createTextPad() {
        Response response = returnResponseCreateTextPad();
        response.then().spec(SpecBuilder.responseSpec);
        assertResult(response);
    }
    public static String getTextPadUUID() {
        Response response = returnResponseCreateTextPad();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.uuid");
    }
    public static void deleteTextPad() {
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.TEXT_PAD_DELETE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void createCanvas() {
        Response response = returnResponseCanvas();
        response.then().spec(SpecBuilder.responseSpec);
        assertResult(response);
    }
    public static String getCanvasUUID() {
        Response response = returnResponseCanvas();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.uuid");
    }
    public static void deleteCanvas() {
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.CANVAS_DELETE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
}
