package com.mycompany.finderApp.logic;


import java.io.*;

public class ReaderUtility {

    public String readFile(String filePath, String fileName) {
        final String totalPath = filePath + File.separator + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(totalPath))) {
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
