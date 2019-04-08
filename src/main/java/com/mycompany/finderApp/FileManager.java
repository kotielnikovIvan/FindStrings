package com.mycompany.finderApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

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
