package TextProcessingCalculator;

public class TextProcessingCalculator {
    private final String data;
    private final Integer characterCount = 0;

    public TextProcessingCalculator(String data){
        this.data = data;
    }

    public Long whiteSpaces(){
        return data.chars().filter(ch -> ch == ' ').count();
    }

    public Integer wordCount(){
        return data.split(" ").length;
    }

    public Integer getCharacterCount(){
        return data.length();
    }

    public Integer getSentences(){
        int numberSentences = 0;
        if (characterCount > 0) numberSentences = 1;
        for (int idx = 0; idx < data.length();idx++){
            if (data.charAt(idx) == '?' || data.charAt(idx) == '!' || data.charAt(idx) == '.'){
                if (idx == data.length() - 1 || !Character.isLetter(data.charAt(idx + 1))) {
                    numberSentences++;
                }
            }
        }
        if (numberSentences > 1) numberSentences--;
        return numberSentences;
    }

    public Integer paragraph(){
        int count = 0;
        if (characterCount > 0) count = 1;

        for (int idx = 0; idx < data.length(); idx++){
            if (data.charAt(idx) == '\n' && data.charAt(idx + 1) != '\n') count++;
        }

        return count;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
