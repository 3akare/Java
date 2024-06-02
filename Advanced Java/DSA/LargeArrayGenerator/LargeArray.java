package LargeArrayGenerator;
import java.util.Random;
public class LargeArray {
    public static void arrayGenerator(int[] arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
        return;
    }
}
