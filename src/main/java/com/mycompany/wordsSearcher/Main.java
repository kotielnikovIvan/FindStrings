package com.mycompany.wordsSearcher;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileManager reader = new FileManager();

        String finalPath = args[0] + File.separator + args[1];
        String text = reader.readFile(finalPath);

        WordsSearcher wordsSearcher = new WordsSearcher();
        System.out.println(wordsSearcher.findWordsAmount(text));
    }
}
