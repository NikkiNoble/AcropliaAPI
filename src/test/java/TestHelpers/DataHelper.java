package TestHelpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class DataHelper {
    static String userPhone = "+79276838772";
    static String userMail = "acroplia.avtobot@gmail.com";
    static String userPassword = "123456";
    static String comTitle = "Dance class";
    static String messageText = "test";
    public static String roomTitle = "New room";
    public static String userDisplayName = "Acroplia Avtobot";
    public static String phoneUserName = "katya phone";
    static String userPasswordWrong = "111111";
    static String userInviteEmail = "motolovanastya@gmail.com";
    static String textPadTitle = "Note";
    static List<String> typesList = Arrays.asList("CANVAS", "CANVAS_DOCUMENT", "COLLECTION", "FOLDER", "LINK",
            "POST", "TASK_LIST", "TEST", "TEXTPAD");
    public static String userName = "acroplia_avtobot";
    static List<String> roomsList = Arrays.asList("GROUP", "P2P", "TASK");
    static String canvasTitle = "Canvas";

}
