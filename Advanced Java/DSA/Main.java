public class Main{
    public static void main(String[] args){
        int[] array = {5, 6, 7, 8, 9, 11, 13, 17};
        System.out.println(linearSearchArray(array, 17));
        System.out.println(binarySearchArray(array, 17));
        System.out.println("DSA");
    }

    // Linear Search
    public static int linearSearchArray(int[] sortedArray, int target){
        int steps = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == target){
                System.out.println(step++);
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearchArray(int[] sortedArray, int target){
        int start;
        int end = sortedArray.length - 1;
        int mid;
        int steps = 0;

        while(start <= end){
            mid = (end + start) / 2;
            System.out.println(steps++);
            if (sortedArray[mid] == target){
                return mid;
            } else if (sortedArray[mid] > target) {
                end = mid + 1;
            } else if (sortedArray[mid] < target) {
                start = mid - 1;
            }
        }
        return -1;
    }

}