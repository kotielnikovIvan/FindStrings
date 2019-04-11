package com.mycompany.wordsSearcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    public String readFile(String finalPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(finalPath))) {
            StringBuffer sentence = new StringBuffer();
            int i;
            while ((i = reader.read()) != -1) {
                sentence.append((char) i);
            }
            return new String(sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
