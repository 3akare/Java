import Shapes.Circle;
import Shapes.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    @Test
    public void testCircleArea() {
        assertEquals(154, (int) Circle.area(7), () -> "Circle Area Failed");
    }

    @Test
    public void testCirclePerimeter() {
        assertEquals(44, (int) Circle.perimeter(7), () -> "Circle Perimeter Failed");
    }

    @Test
    public static void testSquareArea() {
        assertEquals(49, (int) Square.area(7), () -> "Square Area Failed");
    }

    @Test
    public void testSquarePerimeter() {
        assertEquals(28, (int) Square.perimeter(7), () -> "Square Perimeter Failed");
    }
}
