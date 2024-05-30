public class Main{
    public static void main(String[] args){
        int[] array = {5, 6, 7, 8, 9, 11, 13, 17};
        System.out.println(linearSearchArray(array, 17));
        System.out.println(binarySearchArray(array, 17));
        System.out.println("DSA");
    }

    // Linear Search
    public static int linearSearchArray(int[] sortedArray, int item){
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == item){
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearchArray(int[] sortedArray, int item){
        int start = 0;
        int end = sortedArray.length;
        int mid = end / 2;

        while(start != mid || mid != end){
            if (sortedArray[mid] == item){
                return mid;
            } else if (sortedArray[mid] > item) {
                end = mid;
            } else if (sortedArray[mid] < item) {
                start = mid;
            }
            mid = (end + start) / 2;
        }
        return -1;
    }

}