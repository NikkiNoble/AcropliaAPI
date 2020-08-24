import TestScheme.CommunityTest;
import org.junit.jupiter.api.Test;

class RoomTestAPI {
    @Test
    void shouldCreateRoom() {
        CommunityTest.createRoom();
    }
    @Test
    void shouldDeleteRoom() {
        CommunityTest.deleteRoom();
    }
}
