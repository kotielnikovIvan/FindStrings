package com.mycompany.wordsSearcher;

public class Main {

    public static void main(String[] args) {
        FileManager reader = new FileManager();
        String text = reader.readFile(args[0]);

        WordsSearcher wordsSearcher = new WordsSearcher();
        System.out.println(wordsSearcher.findWordsAmount(text));
    }
}
