package TestHelpers;
import TestScheme.CommunityTest;
import TestScheme.NodesTest;

public class TestHelperURIData {
    public static final String USERS_SESSIONS = "users/sessions";
    public static final String PHONE = USERS_SESSIONS + "/phone";
    public static final String MAGIC = USERS_SESSIONS + "/magic";
    public static final String MAGIC_PHONE = MAGIC + "/phone";
    public static final String MAGIC_EMAIL = MAGIC + "/email";
    public static final String COMMUNITIES = "communities";
    private static String communityUUID = CommunityTest.getCommunityUUID();
    public static final String COM_DELETE = COMMUNITIES + "/" + communityUUID;
    public static final String WORKSPACES = COM_DELETE + "/workspaces";
    public static String workspaceUUID = CommunityTest.getRoomUUID();
    public static final String WORKSPACE_ID = "workspaces/" + workspaceUUID;
    public static final String CHAT = WORKSPACE_ID + "/chat";
    public static final String TEXT_PAD = "textpads";
    public static final String CANVASES = "canvases";
    private static String textPadUUID = NodesTest.getTextPadUUID();
    private static String canvasUUID = NodesTest.getCanvasUUID();
    public static final String TEXT_PAD_DELETE = TEXT_PAD + "/" + textPadUUID;
    public static final String CANVAS_DELETE = CANVASES + "/" + canvasUUID;
    public static final String GUEST_MAGIC = "guests/magic/room/" + workspaceUUID;
    public static final String INVITES = COM_DELETE + "/invites";

}
