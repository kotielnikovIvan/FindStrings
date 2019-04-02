package com.mycompany.finderApp.main;

import com.mycompany.finderApp.logic.WordSearcher;
import com.mycompany.finderApp.logic.ReaderUtility;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ReaderUtility reader = new ReaderUtility();
        WordSearcher wordSearcher = new WordSearcher();

        Map<String, Integer> words = new HashMap<>();
        String filePath = args[0];
        String fileName = args[1];
        String sentence = reader.readFile(filePath, fileName);

        words = wordSearcher.findWordsAmount(sentence);
    }

}
