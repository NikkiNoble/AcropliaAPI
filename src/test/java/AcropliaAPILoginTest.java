import TestScheme.AuthTest;
import org.junit.jupiter.api.Test;

class AcropliaAPILoginTest {
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





}
