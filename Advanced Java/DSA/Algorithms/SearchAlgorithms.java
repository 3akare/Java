package Algorithms;
public class SearchAlgorithms {
    // Linear Search
    public static int linearSearch(int[] sortedArray, int target){
        int steps = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == target) return i;
        }
        return -1;
    }
    // Binary Search
    public static int binarySearch(int[] sortedArray, int target){
        int start = -1;
        int end = sortedArray.length - 1;
        int mid;

        while(start <= end){
            mid = (end + start) / 2;
            if (sortedArray[mid] == target){
                return mid;
            } else if (sortedArray[mid] > target) {
                end = mid - 1;
            } else if (sortedArray[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }
}