package Shapes;

public class Square extends Shapes {
    static public double perimeter(int length){
        return 4 * length;
    }
    static public double area(int length){
        return Math.pow(length, 2);
    }
}