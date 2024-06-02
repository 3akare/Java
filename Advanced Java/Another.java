public class Another {
    public static void main(String[] args){
        String str = "David Bakare";
        System.out.println(str);
        // str = reverseString(str);
        System.out.println(str);
        System.out.println(reverseString2(str));
    }
    
    public static String reverseString(String str){
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        char temp = 0;

        while (left < right){
            temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(charArray);
    }

    public static String reverseString2(String str){
        int length = str.length() - 1;
        char[] newStr = new char[length + 1 ];
        int i;
        for (i = 0; i < length; i++){
            newStr[length - i] = str.charAt(i);
        }
        newStr[0] = str.charAt(length);
        return String.valueOf(newStr);
    }
}
