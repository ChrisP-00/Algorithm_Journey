package week018.day0123_Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(new WordReverser(input).process());
    }

    private static class WordReverser {
        private static final char OPENING_TAG_SYMBOL = '<';
        private static final char CLOSING_TAG_SYMBOL = '>';
        private static final char SPACE_SYMBOL = ' ';

        private final String inputString;
        private final StringBuilder finalResult = new StringBuilder();
        private final StringBuilder reversedWord = new StringBuilder();
        private boolean isInsideHtmlTag = false;

        public WordReverser(String inputString) {
            this.inputString = inputString;
        }

        public String process() {
            for (char currentCharacter : inputString.toCharArray()) {
                processCharacter(currentCharacter);
            }
            appendReversedWordToResult();
            return finalResult.toString();
        }

        private void processCharacter(char currentCharacter) {
            switch (currentCharacter) {
                case OPENING_TAG_SYMBOL -> handleOpeningTag(currentCharacter);
                case CLOSING_TAG_SYMBOL -> handleClosingTag(currentCharacter);
                case SPACE_SYMBOL -> handleSpace(currentCharacter);
                default -> handleDefault(currentCharacter);
            }
        }

        private void handleOpeningTag(char currentCharacter) {
            appendReversedWordToResult();
            isInsideHtmlTag = true;
            finalResult.append(currentCharacter);
        }

        private void handleClosingTag(char currentCharacter) {
            isInsideHtmlTag = false;
            finalResult.append(currentCharacter);
        }

        private void handleSpace(char currentCharacter) {
            if (!isInsideHtmlTag) {
                appendReversedWordToResult();
            }
            finalResult.append(currentCharacter);
        }

        private void handleDefault(char currentCharacter) {
            if (isInsideHtmlTag) {
                finalResult.append(currentCharacter);
            } else {
                reversedWord.append(currentCharacter);
            }
        }

        private void appendReversedWordToResult() {
            finalResult.append(reversedWord.reverse());
            reversedWord.setLength(0);
        }
    }
}
