package TestScheme;

import TestHelpers.TestHelperBodyData;
import TestHelpers.TestHelperURIData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;

public class ChatTest {
    private static Response returnResponseChat() {
        return RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.chatInfo)
                .when().post(TestHelperURIData.CHAT);
    }
    public static void sendText() {
        Response response = returnResponseChat();
        response.then().statusCode(200);
        String respJson = response.getBody().asString();
        System.out.println(respJson);
        System.out.println(TestHelperURIData.CHAT);
    }
    public static void deleteMessage() {
        String wrkUuid = TestHelperURIData.workspaceUUID;
        Response response = RestAssured.given().spec(SpecBuilder.requestSpecFull).body(TestHelperBodyData.chatInfo)
                .when().post("workspaces/" + wrkUuid + "/chat");
        String respJson = response.getBody().asString();
        String chatUuid = from(respJson).get("data.uuid");
        Response delResponse = RestAssured.given().spec(SpecBuilder.requestSpecFull)
                .when().delete("workspaces/" + wrkUuid + "/chat/messages/" + chatUuid);
        delResponse.then().spec(SpecBuilder.responseSpecBody);
    }
}
