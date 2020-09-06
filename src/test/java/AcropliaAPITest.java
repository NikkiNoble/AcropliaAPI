import TestScheme.AuthTest;
import TestScheme.ChatTest;
import TestScheme.CommunityTest;
import TestScheme.NodesTest;
import org.junit.jupiter.api.Test;

class AcropliaAPITest {
//    SIGNIN TESTS
    @Test
    void shouldSignInWithEmailPassword() {
        AuthTest.signInWithEmailPassword();
    }
    @Test
    void shouldSignInWithPhonePassword() {
        AuthTest.signInWithPhonePassword();
    }
    @Test
    void shouldSignInWithMagicLink() {
        AuthTest.signInWithMagicLink();
    }
    @Test
    void shouldSignInWithMagicLinkEmail() {
        AuthTest.signInWithMagicLinkEmail();
    }
    @Test
    void shouldSignInWithMagicLinkPhone() {
        AuthTest.signInWithMagicLinkPhone();
    }
    @Test
    void shouldNotSignIn() {
        AuthTest.signInUnsuccessful();
    }
    @Test
    void shouldGenerateAvatar() {
        AuthTest.generateAvatar();
    }
//    COMMUNITY AND ROOM TESTS
    @Test
    void shouldCreateAndDeleteContact() {
        AuthTest.createAndDeleteContact();
    }
    @Test
    void shouldCreateCommunity() {
        CommunityTest.createCommunity();
    }
    @Test
    void shouldDeleteCommunity() {
        CommunityTest.deleteCommunity();
    }
//    create community -> workspace and send message
    @Test
    void shouldSendMessage() {
        ChatTest.sendText();
    }
    //  create community -> workspace, create and delete message
    @Test
    void shouldDeleteMessage() {
        ChatTest.deleteMessage();
    }
    //    create link for guest login to the room
    @Test
    void shouldCreateMagicLinkForGuest() {
        CommunityTest.createMagicForGuestLogin();
    }
    //    create an invite to the community for a user and invoke the invite
    @Test
    void shouldInviteToCommunityAndRevokeInvite() {
        CommunityTest.communityInvite();
    }
    @Test
    void shouldInviteToCall() {
        CommunityTest.inviteToCall();
    }
//    NODES TESTS
    @Test
    void shouldCreateTextPad() {
        NodesTest.createTextPad();
    }
    @Test
    void shouldDeleteTextPad() {
        NodesTest.deleteTextPad();
    }
    @Test
    void shouldCreateCanvas() {
        NodesTest.createCanvas();
    }
    @Test
    void shouldDeleteCanvas() {
        NodesTest.deleteCanvas();
    }
    @Test
    void shouldCreateRoom() {
        CommunityTest.createRoom();
    }
    @Test
    void shouldDeleteRoom() {
        CommunityTest.deleteRoom();
    }
    @Test
    void shouldAddTaskType() {
        CommunityTest.addTaskType();
    }
}
