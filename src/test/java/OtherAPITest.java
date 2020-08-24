import TestScheme.NodesTest;
import org.junit.jupiter.api.Test;

class OtherAPITest {
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
}
