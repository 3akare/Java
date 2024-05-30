package Shapes;

public class Circle extends Shapes{
    static public double perimeter(int radius){
        return (double) (2 * 22) /7 * radius;
    }

    static public double area(int radius){
        return ((double) 22 /7) * Math.pow(radius,2);
    }
}
