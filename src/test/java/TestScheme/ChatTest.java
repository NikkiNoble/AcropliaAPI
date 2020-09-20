package TestScheme;

import TestHelpers.DataHelper;
import TestHelpers.TestHelperURIData;
import TestHelpers.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;

public class ChatTest {
    private static User chatUser = new User();
    private static Response returnResponseChat() {
        chatUser.setType(DataHelper.chatType);
        chatUser.setText(DataHelper.messageText);
        return RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(chatUser)
                .when().post(TestHelperURIData.CHAT);
    }
    public static void sendText() {
        Response response = returnResponseChat();
        response.then().statusCode(200);
        response.then().spec(SpecBuilder.responseSpec);
        response.then().assertThat()
                .body("data.type", equalTo("USER_TEXT"));
    }
    public static void deleteMessage() {
        chatUser.setType(DataHelper.chatType);
        chatUser.setText(DataHelper.messageText);
        String wrkUuid = TestHelperURIData.workspaceUUID;
        Response response = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .body(chatUser)
                .when().post("workspaces/" + wrkUuid + "/chat");
        String respJson = response.getBody().asString();
        String chatUuid = from(respJson).get("data.uuid");
        Response delResponse = RestAssured
                .given().spec(SpecBuilder.requestSpecFull)
                .when().delete("workspaces/" + wrkUuid + "/chat/messages/" + chatUuid);
        delResponse.then().spec(SpecBuilder.responseSpecBody);
    }
}
