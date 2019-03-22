package com.myApp;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private String sentence;
    private Map<String, Integer> words = new HashMap();

    public Map<String, Integer> getWords() {
        return words;
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void findWordsAmount() {
        String[] subSentences =
                sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for ( int i = 0; i < subSentences.length; i++) {
            int amount = 0;
            if(!words.containsKey(subSentences[i])) {
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

