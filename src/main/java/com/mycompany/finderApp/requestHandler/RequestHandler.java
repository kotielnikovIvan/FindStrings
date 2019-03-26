package com.mycompany.finderApp.requestHandler;

import com.mycompany.finderApp.entity.Sentence;
import com.mycompany.finderApp.service.FileService;
import com.mycompany.finderApp.service.FindWordsService;

import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    Sentence sentence = new Sentence();

    private Map<String, Integer> words = new HashMap<>();

    public Sentence getSentence() {
        return sentence;
    }

    public void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }


    public void countWordsAmount() {
        FindWordsService findWordsService = new FindWordsService();
        FileService fileService = new FileService();
        sentence.setSentence(fileService.readFile());
        if (sentence.getSentence() != null) {
            findWordsService.findWordsAmount(sentence.getSentence(), words);
        }
    }

}
