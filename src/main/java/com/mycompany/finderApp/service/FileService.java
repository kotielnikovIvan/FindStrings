package com.mycompany.finderApp.service;

import java.io.*;

public class FileService {

    private final static String PATH = System.getProperty("user.dir") +
            File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "sentence.txt";

    public void writeToFile(String sentence) {

        try (Writer writer = new BufferedWriter(new FileWriter(PATH))) {
            writer.write(sentence);

        } catch (IOException e) {
            e.printStackTrace();
        }

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

}
