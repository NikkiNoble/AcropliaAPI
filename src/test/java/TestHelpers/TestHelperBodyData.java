package TestHelpers;

import TestScheme.AuthTest;
import io.restassured.response.Response;

public class TestHelperBodyData {

    public static String userInfoBody = String.format("{\"email\": \"%s\",\"password\": \"%s\"}",
            DataHelper.userMail, DataHelper.userPassword);
    public static String userLinkEmail = String.format("{\"email\": \"%s\"}", DataHelper.userMail);
    public static String userLinkPhone = String.format("{\"phone\": \"%s\"}", DataHelper.userPhone);
    public static String userInfoBodyWrong = String.format("{\"email\": \"%s\",\"password\": \"%s\"}",
            DataHelper.userMail, DataHelper.userPasswordWrong);
    public static String communityInfo = String.format("{\"title\": \"%s\"}", DataHelper.comTitle);
    public static String roomInfo = String.format("{\"type\": \"%s\", \"title\": \"%s\"}",
            DataHelper.roomsList.get(0), DataHelper.roomTitle);
    public static String chatInfo = String.format("{\"type\": \"USER_TEXT\",\"text\": \"%s\"}", DataHelper.messageText);
    public static String userInfoPhone = String.format("{\"phone\": \"%s\", \"password\": \"%s\"}",
            DataHelper.userPhone, DataHelper.userPassword);
    public static String textPads  = String.format("{\"type\": \"%s\",\"title\": \"%s\", \"user\": {\"uuid\": \"%s\"}}",
            DataHelper.typesList.get(8), DataHelper.textPadTitle, AuthTest.getUUID());
    public static String invites = String.format("{ \"email\": \"%s\"}", DataHelper.userInviteEmail);
    public static String canvas  = String.format("{\"type\": \"%s\",\"title\": \"%s\", \"user\": {\"uuid\": \"%s\"}}",
            DataHelper.typesList.get(0), DataHelper.canvasTitle, AuthTest.getUUID());
    public static void printBody(Response response) {
        String respJson = response.getBody().asString();
        System.out.println(respJson);
    }
}
