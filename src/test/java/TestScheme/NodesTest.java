package TestScheme;

import TestHelpers.DataHelper;
import TestHelpers.TestHelperURIData;
import TestHelpers.TestHelperBodyData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.path.json.JsonPath.from;

public class NodesTest {
    private static Response returnResponseCreateTextPad() {
        return RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.textPads)
                .when().post(TestHelperURIData.TEXT_PAD);
    }
    private static Response returnResponseCanvas() {
        return RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.canvas)
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
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull)
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
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.CANVAS_DELETE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
}
