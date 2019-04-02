package com.mycompany.finderApp.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class WordSearcher {
    private final static Logger log = Logger.getLogger(WordSearcher.class.getSimpleName());

    public Map<String, Integer> findWordsAmount(String sentence) {
        Map<String, Integer> words = new HashMap<>();

        if (sentence == null) {
            log.warning("You don't have a sentence!");
        } else if (sentence.isEmpty()) {
            log.info("Your sentence is empty!");
        } else {
            String[] subSentences = sentence.toLowerCase().split(" ");
            for (int i = 0; i < subSentences.length; i++) {
                if (!(subSentences[i].matches("[0-9]+"))) {
                    if (!(subSentences[i].equals(".")) && !(subSentences[i].equals(",")) && !(subSentences[i].equals("!")) && !(subSentences[i].equals("?"))) {
                        if (!words.containsKey(subSentences[i])) {
                            int amount = 0;
                            for (int j = i; j < subSentences.length; j++) {
                                if (subSentences[i].equalsIgnoreCase(subSentences[j])) {
                                    amount++;
                                }
                            }
                            words.put(subSentences[i], amount);
                        }
                    }
                }
            }
        }
        return words;
    }
}

