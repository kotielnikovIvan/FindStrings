package com.mycompany.finderApp.requestHandler;

import com.mycompany.finderApp.entity.Sentence;
import com.mycompany.finderApp.service.FileService;
import com.mycompany.finderApp.service.FindWordsService;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RequestHandler {
    private final static Logger log = Logger.getLogger(RequestHandler.class.getSimpleName());

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
        sentence.setStringSentence(fileService.readFile());
        if (sentence.getStringSentence() != null && sentence.getStringSentence() != "") {
            findWordsService.findWordsAmount(sentence.getStringSentence(), words);
        } else {
            log.info("Your string is null or empty");
        }
    }

}
