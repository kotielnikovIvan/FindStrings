package com.mycompany.finderApp.service;

import java.util.Map;
import java.util.logging.Logger;

public class SearchService {
    private final static Logger log = Logger.getLogger(SearchService.class.getSimpleName());
    private String sentence;

    public SearchService(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public void findWordsAmount(Map<String, Integer> words) {
        if (sentence == null) {
            log.warning("You don't have a sentence!");
        } else if (sentence.isEmpty()) {
            log.info("Your sentence is empty!");
        } else {
            String[] subSentences = sentence.toLowerCase().split(" ");
            for (int i = 0; i < subSentences.length; i++) {
                if (!(subSentences[i].matches("[0-9]+"))) {
                    int amount = 0;
                    if (!(subSentences[i] == "." || subSentences[i] == "," || subSentences[i] == "!" || subSentences[i] == "?")) {
                        if (!words.containsKey(subSentences[i])) {
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
    }
}

