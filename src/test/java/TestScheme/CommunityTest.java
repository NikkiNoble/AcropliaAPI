package TestScheme;

import TestHelpers.DataHelper;
import TestHelpers.TestHelperURIData;
import TestHelpers.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;

public class CommunityTest {
    private static User user = new User();
    private static Response returnResponseCommunity() {
        user.setTitle(DataHelper.comTitle);
        return RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(user)
                .when().post(TestHelperURIData.COMMUNITIES);
    }
    private static Response returnResponseRoom() {
        User roomUser = new User();
        roomUser.setType(DataHelper.roomsList.get(0));
        roomUser.setTitle(DataHelper.roomTitle);
        return RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(roomUser)
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
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.COM_DELETE);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void deleteRoom() {
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.WORKSPACE_ID);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void createMagicForGuestLogin() {
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body("{}")
                .when().post(TestHelperURIData.GUEST_MAGIC);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body(containsString("key"));
    }
    public static void communityInvite() {
        user.setEmail(DataHelper.userInviteEmail);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(user)
                .when().post(TestHelperURIData.INVITES);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.inviter.userName", equalTo(DataHelper.userName));
        String respJson = response.getBody().asString();
        String uuidInvite = from(respJson).get("data.uuid");
        Response delResponse = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete(TestHelperURIData.INVITES + "/" + uuidInvite);
        delResponse.then().spec(SpecBuilder.responseSpecBody);
    }
    public static void addTaskType() {
        user.setName(DataHelper.nameOfTask);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(user)
                .queryParam(getRoomUUID())
                .when().post(TestHelperURIData.TASK_TYPE);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.name", equalTo(DataHelper.nameOfTask));
    }
    public static void inviteToCall() {
        user.setEmail(DataHelper.userInviteEmail);
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(user)
                .when().post(TestHelperURIData.CALL_INVITES);
        response.then().spec(SpecBuilder.responseSpecBody);
    }
}
