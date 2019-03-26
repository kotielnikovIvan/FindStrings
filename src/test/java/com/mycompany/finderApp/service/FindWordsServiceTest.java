package com.mycompany.finderApp.service;

import com.mycompany.finderApp.requestHandler.RequestHandler;
import com.mycompany.finderApp.service.FindWordsService;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FindWordsServiceTest {

    @Test
    public void testFindWords() {
        FileService fileService = new FileService();
        RequestHandler handler = new RequestHandler();
        Map<String, Integer> testWords = new HashMap<>();

        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 2);
        testWords.put("you", 3);

        fileService.writeToFile("Hello, hello, i, I, my, you ? my. you you");
        handler.countWordsAmount();
        Map<String, Integer> realWords = handler.getWords();

        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }

    @Test
    public void testNull() {
        FileService fileService = new FileService();
        RequestHandler handler = new RequestHandler();

        fileService.writeToFile(null);
        handler.countWordsAmount();
        Map<String, Integer> realWords = handler.getWords();
        assertNull(realWords);
    }


}