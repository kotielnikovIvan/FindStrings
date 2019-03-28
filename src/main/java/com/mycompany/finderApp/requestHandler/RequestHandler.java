package com.mycompany.finderApp.requestHandler;

import com.mycompany.finderApp.service.SearchService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    private final static String PATH = System.getProperty("user.dir") +
            File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "sentence.txt";

    String sentence;
    private Map<String, Integer> words = new HashMap<>();

    public RequestHandler() {
        sentence = readFile();
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    public String readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            StringBuffer tempSentence = new StringBuffer();
            int i;
            while ((i = reader.read()) != -1) {
                tempSentence.append((char) i);
            }
            String sentence = new String(tempSentence);
            return sentence;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public void handleSearch() {

        SearchService searchService = new SearchService(sentence);
        searchService.findWordsAmount(words);
    }

}
