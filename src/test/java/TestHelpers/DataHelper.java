package TestHelpers;

import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;

public class DataHelper {
    public static String userPhone = "+79276838772";
    public static String userMail = "acroplia.avtobot@gmail.com";
    public static String userPassword = "123456";
    public static String comTitle = "Dance class";
    public static String messageText = "test";
    public static String roomTitle = "New room";
    public static String userDisplayName = "Acroplia Avtobot";
    public static String phoneUserName = "katya phone";
    public static String userPasswordWrong = "111111";
    public static String userInviteEmail = "motolovanastya@gmail.com";
    public static String textPadTitle = "Note";
    public static List<String> typesList = Arrays.asList("CANVAS", "CANVAS_DOCUMENT", "COLLECTION", "FOLDER", "LINK",
            "POST", "TASK_LIST", "TEST", "TEXTPAD");
    public static String userName = "acroplia_avtobot";
    public static String chatType = "USER_TEXT";
    public static List<String> roomsList = Arrays.asList("GROUP", "P2P", "TASK");
    public static String canvasTitle = "Canvas";
    public static String nameOfTask = "Task";
    public static String userID = "7c4f3304-b437-463f-892d-e183e689eb35";
    public static String otherUserName = "Nastya";
    static String communityID = "/c2e35b62-4615-46df-b03c-004a657fe18f";
    public static String testName = "Vasya";
    public static String testLastName = "Pupkin";
    static String roomID = "052892e5-99d1-4708-bad1-faf7c2392ecd";
    public static void printBody(Response response) {
        String respJson = response.getBody().asString();
        System.out.println(respJson);
    }
}
