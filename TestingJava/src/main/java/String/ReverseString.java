package String;

import org.jetbrains.annotations.NotNull;

public class ReverseString {
    public static @NotNull String reverseString(@NotNull String word){
        char[] stringChars = word.toCharArray();
        for (int i = 0; i < stringChars.length / 2; i++) {
            char temp = stringChars[i];
            stringChars[i] = stringChars[stringChars.length - i - 1];
            stringChars[stringChars.length - i - 1] = temp;
        }
        return String.valueOf(stringChars);
    }

    public static @NotNull String reverseString2(@NotNull String word){
        char[] stringChars = word.toCharArray();
        char[] stringChars2 = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            stringChars[i] = stringChars2[word.length() - i - 1];
        }
        return String.valueOf(stringChars);
    }
}
