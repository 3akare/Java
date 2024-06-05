import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import String.ReverseString;

public class ReverseStringTest {

    @Test
    public void testReverseOneWord() {
        assertEquals("divad", ReverseString.reverseString("david"), () -> "Reverse String One Word Failed");
    }

    @Test
    public void testReverseMultipleWords() {
        assertEquals("Reverse String Multiple Words Failed",
                ReverseString.reverseString("deliaF sdroW elpitluM gnirtS esreveR"),
                () -> "Reverse String Multiple Words Failed");
    }

    @Test
    public void testReverseOneWord2() {
        assertEquals("divad", ReverseString.reverseString2("david"), () -> "Revere String (2) One word Failed");
    }

    @Test
    public void testReverseMultipleWords2() {
        assertEquals("Reverse String Multiple Words Failed",
                ReverseString.reverseString2("deliaF sdroW elpitluM gnirtS esreveR"),
                () -> "Reverse String (2) Multiple Words Failed");
    }
}
