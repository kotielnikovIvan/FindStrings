package com.mycompany.finderApp.main;

import com.mycompany.finderApp.engine.Search;
import com.mycompany.finderApp.utility.ReaderUtility;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ReaderUtility reader = new ReaderUtility();
        Search search = new Search();

        Map<String, Integer> words = new HashMap<>();
        String filePath = args[0];
        String fileName = args[1];
        String sentence = reader.readFile(filePath, fileName);

        words = search.findWordsAmount(sentence);
        System.out.println(words.keySet());
        System.out.println(words.values());
    }


}
