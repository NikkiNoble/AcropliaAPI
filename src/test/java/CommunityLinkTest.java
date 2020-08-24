import TestScheme.CommunityTest;
import org.junit.jupiter.api.Test;

class CommunityLinkTest {
//    create link for guest login to the room
    @Test
    void shouldCreateMagicLinkForGuest() {
        CommunityTest.createMagicForGuestLogin();
    }
//    create invite to community for a user
    @Test
    void shouldInviteToCommunity() {
        CommunityTest.communityInvite();
    }
}
