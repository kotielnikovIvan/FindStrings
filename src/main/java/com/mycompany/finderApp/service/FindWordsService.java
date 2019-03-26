package com.mycompany.finderApp.service;

import java.util.Map;

public class FindWordsService {

    public void findWordsAmount(String sentence, Map<String, Integer> words) {
        String[] subSentences = sentence.toLowerCase().split(" ");
        for (int i = 0; i < subSentences.length; i++) {
            int amount = 0;
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

