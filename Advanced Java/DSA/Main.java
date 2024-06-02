import Algorithms.SearchAlgorithms;
import Algorithms.SortingAlgorithms;
import LargeArrayGenerator.LargeArray;
public class Main{
    public static void main(String[] args){

        int size = 20;
        int[] array = new int[size];

        LargeArray.arrayGenerator(array);

        int array1[] = array.clone();
        int array2[] = array.clone();
        int array3[] = array.clone();

        System.out.println("--------------------");
        SortingAlgorithms.bubbleSort(array1);
        System.out.println("--------------------");
        SortingAlgorithms.optimizedBubbleSort(array2);
        System.out.println("--------------------");
        SortingAlgorithms.selectionSort(array3);
        System.out.println("--------------------");
        System.out.println(SearchAlgorithms.binarySearch(array1, 12));
        System.out.println(SearchAlgorithms.linearSearch(array1, 12));
    }
}

