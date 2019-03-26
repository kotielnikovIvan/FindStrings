package com.mycompany.finderApp.service;

import com.mycompany.finderApp.entity.Sentence;
import com.mycompany.finderApp.requestHandler.RequestHandler;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FindWordsServiceTest {
    FileService fileService = new FileService();
    RequestHandler handler = new RequestHandler();

    String stringBeforeTests;

    @BeforeEach
    public void readBeforeTests() {
        stringBeforeTests = fileService.readFile();
    }

    @Test
    public void testFindWords() {

        Map<String, Integer> testWords = new HashMap<>();

        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 2);
        testWords.put("you", 3);

        fileService.writeToFile("hello , Hello , i , I , my , you ? my . you you");
        handler.countWordsAmount();
        Map<String, Integer> realWords = handler.getWords();

        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }

    @Test
    public void testReadWriteFile() {
        String sentenceBeforeRead = "Hello, dear!";
        fileService.writeToFile(sentenceBeforeRead);
        String sentenceAfterRead = fileService.readFile();
        assertTrue(sentenceBeforeRead.equals(sentenceAfterRead));
    }

    @Test
    public void testEmptySentence() {
        fileService.writeToFile("");

        handler.countWordsAmount();

        assertTrue(handler.getSentence().getStringSentence().equals(""));

    }

    @AfterEach
    public void writeToFileAfterTests() {
        fileService.writeToFile(stringBeforeTests);
    }
}