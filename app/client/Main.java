import TextProcessingCalculator.TextProcessingCalculator;

public class Main {
    public static void main(String[] args){
        final String text = "Apart from counting words and characters, our online editor can help you to improve word choice and writing style, and, optionally, help you to detect grammar mistakes and plagiarism. To check word count, simply place your cursor into the text box above and start typing. You'll see the number of characters and words increase or decrease as you type, delete, and edit them. You can also copy and paste text from another program over into the online editor above. The Auto-Save feature will make sure you won't lose any changes while editing, even if you leave the site and come back later. Tip: Bookmark this page now.\n" +
                "\n" +
                "Knowing the word count of a text can be important. For example, if an author has to write a minimum or maximum amount of words for an article, essay, report, story, book, paper, you name it. WordCounter will help to make sure its word count reaches a specific requirement or stays within a certain limit.\n" +
                "\n" +
                "In addition, WordCounter shows you the top 10 keywords and keyword density of the article you're writing. This allows you to know which keywords you use how often and at what percentages. This can prevent you from over-using certain words or word combinations and check for best distribution of keywords in your writing.\n" +
                "\n" +
                "In the Details overview you can see the average speaking and reading time for your text, while Reading Level is an indicator of the education level a person would need in order to understand the words you’re using.";
        TextProcessingCalculator textProcessingCalculator = new TextProcessingCalculator(text);

        System.out.println("whitespaces: " + textProcessingCalculator.whiteSpaces());
        System.out.println("words " + textProcessingCalculator.wordCount());
        System.out.println("characters " + textProcessingCalculator.getCharacterCount());
        System.out.println("Sentences: " + textProcessingCalculator.getSentences());
        System.out.println("Paragraph: " + textProcessingCalculator.paragraph());
    }
}
