package com.mycompany.wordsSearcher;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class WordsSearcher {
    private final static Logger log = Logger.getLogger(WordsSearcher.class.getSimpleName());

    public Map<String, Integer> findWordsAmount(String text) throws RuntimeException {
        Map<String, Integer> words = new HashMap<>();
        if (text == null) {
            log.warning("You don't have a sentence!");
            throw new RuntimeException("Input sentence null");
        } else if (text.isEmpty()) {
            log.warning("Your sentence is empty!");
        } else {
            words = calculateWordsAmount(text);
        }
        return words;
    }

    private Map<String, Integer> calculateWordsAmount(String text) {
        String[] subStrings = text.toLowerCase().split(" ");
        // deleting all the numbers and marks in words
        for (int i = 0; i < subStrings.length; i++) {
            subStrings[i] = deleteMarksAndNumbers(subStrings[i]);
        }
        // counting amount of words
        Map<String, Integer> words = new HashMap<>();
        for (int i = 0; i < subStrings.length; i++) {
            if (!words.containsKey(subStrings[i])) {
                int amount = 0;
                for (int j = i; j < subStrings.length; j++) {
                    if (subStrings[i].equalsIgnoreCase(subStrings[j])) {
                        amount++;
                    }
                }
                if (!subStrings[i].equals("")) {
                    words.put(subStrings[i], amount);
                }
            }
        }
        return words;
    }

    private String deleteMarksAndNumbers(String word) {
        char[] chars = word.toCharArray();
        StringBuffer tempWord = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (((chars[i] >= 'a') && (chars[i] <= 'z')) ||
                    ((chars[i] >= 'A') && (chars[i] <= 'Z'))) {
                tempWord.append(chars[i]);
            }
        }
        return new String(tempWord);
    }
}

