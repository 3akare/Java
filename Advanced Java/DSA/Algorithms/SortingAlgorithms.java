package Algorithms;
public class SortingAlgorithms {
    /*
    * BubbleSort
    * best case: O(n)
    * worse case: 0(n^2)
    * */
    public static void bubbleSort(int arr[]){
        int temp;
        int size = arr.length;
        int steps = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                steps++;
            }
        }
        System.out.println("Bubble steps: " + steps);
    }
    /*
     * Optimized BubbleSort
     * best case O(n)
     * worse case: 0(n^2)
     * */
    public static void optimizedBubbleSort(int arr[]){
        int temp;
        int size = arr.length;
        boolean swapped;
        int steps = 0;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                steps++;
            }
            if(!swapped) break;
        }
        System.out.println("Optimized bubble steps: " + steps);
    }
    /*
    * Selection Sort
    * best case: O(n)
    * worse case: O(n^2)
    * */
    public static void selectionSort(int arr[]) {
        int size = arr.length;
        int steps = 0;

        for (int i = 0; i < size - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIdx]){
                    minIdx = j;
                }
                steps++;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Selection steps: " + steps);
    }
}

