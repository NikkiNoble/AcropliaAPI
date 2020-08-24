import TestScheme.ChatTest;
import TestScheme.CommunityTest;
import org.junit.jupiter.api.Test;

class CommunityAPITest {
//    create public community
    @Test
    void shouldCreateCommunity() {
        CommunityTest.createCommunity();
    }
//    create and delete community
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

}
