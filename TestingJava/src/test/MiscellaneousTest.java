import Shapes.Rectangle;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import String.ReverseString;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MiscellaneousTest {
    private final int[] array = {25, 12, 3, 46};
    Rectangle rectangle = new Rectangle();

    // Other Junit 5 annotations
    // @BeforeEach
    // @AfterEach
    // @BeforeAll
    // @AfterAll
    // @TestInstance
    //TestInstance
    // For More Read the users guide; https://junit.org/junit5/docs/current/user-guide/

    MiscellaneousTest(){
        System.out.println("Miscellaneous is invoked only once");
    }

    @Test
    public void assertTrueTest(){
        assertTrue(returnsTrue(), ()->"returnsTrue Function Failed");
    }

    @Test
    public void assertFalseTest(){
        assertFalse(returnsFalse(), ()->"returnsFalse Function Failed");
    }

    @Test
    public void assertArrayNotEqualsTest(){
        assertArrayEquals(new int[]{3, 12, 25, 46}, sortArray(array));
    }

    @Test
    public void shapesClassExceptionTest() throws Exception {
        assertThrows(Exception.class, ()-> rectangle.area());
        assertThrows(Exception.class, ()-> rectangle.perimeter());
    }

    @Test
    public void timeOutReverseStringTest(){
        assertTimeout(Duration.ofMillis(1), ()-> ReverseString.reverseString("Hello world, it is me again"), ()->"Reverse String Performance test Failed");
    }

    @Test
    public void timeOutReverseString2Test(){
        assertTimeout(Duration.ofMillis(10), ()-> ReverseString.reverseString2("Hello world, it is me again"), ()->"Reverse String (2) Performance test Failed");
    }

    public int[] sortArray(int[] array){
        int[] arrayCpy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCpy);
        return arrayCpy;
    }

    public boolean returnsTrue(){
        return true;
    }

    public boolean returnsFalse(){
        return false;
    }
}
