package TestScheme;

import TestHelpers.DataHelper;
import TestHelpers.TestHelperBodyData;
import TestHelpers.TestHelperURIData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;

public class CommunityTest {
    private static Response returnResponseCommunity() {
        return RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.communityInfo)
                .when().post(TestHelperURIData.COMMUNITIES);
    }
    private static Response returnResponseRoom() {
        return RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.roomInfo)
                .when().post(TestHelperURIData.WORKSPACES);
    }
    public static void createCommunity() {
        Response response = returnResponseCommunity();
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
        .body("data.visibility", equalTo("PUBLIC"))
                .body("data.owner.userName", equalTo(DataHelper.userName));
    }
    public static String getCommunityUUID() {
        Response response = returnResponseCommunity();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.uuid");
    }
    public static void createRoom() {
        Response response  = returnResponseRoom();
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.title", equalTo(DataHelper.roomTitle));
    }
    public static String getRoomUUID() {
        Response response = returnResponseRoom();
        String respJson = response.getBody().asString();
        return from(respJson).get("data.uuid");
    }
    public static void deleteCommunity() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.COM_DELETE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void deleteRoom() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.WORKSPACE_ID);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void createMagicForGuestLogin() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull).body("{}")
                .when().post(TestHelperURIData.GUEST_MAGIC);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body(containsString("key"));
    }
    public static void communityInvite() {
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.invites)
                .when().post(TestHelperURIData.INVITES);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.inviter.userName", equalTo(DataHelper.userName));
    }


}
