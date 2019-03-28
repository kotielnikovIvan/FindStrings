package com.mycompany.finderApp.service;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTest {
    SearchService searchService = new SearchService(null);
    Map<String, Integer> testWords = new HashMap<>();

    @Test
    public void testFindWordsExpectTrue() {
        Map<String, Integer> realWords = new HashMap<>();
        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 2);
        testWords.put("you", 3);

        searchService.setSentence("hello , I , my , you ! You , my ? Hello . you");
        searchService.findWordsAmount(realWords);

        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }

    @Test
    public void testIfSentenceIsNullExpectTrue() {
        searchService.setSentence(null);
        searchService.findWordsAmount(testWords);
        assertNull(searchService.getSentence());
    }

    @Test
    public void testSentenceIsNotNullExpectTrue() {
        String sentence = "Hello World!";
        searchService.setSentence(sentence);
        assertNotNull(searchService.getSentence());
    }

    @Test
    public void testIfSentenceIsEmptyExpectTrue() {
        searchService.setSentence("");
        searchService.findWordsAmount(testWords);
        assertTrue(searchService.getSentence().isEmpty());
    }

    @Test
    public void testSentenceIsNotEmptyExpectTrue() {
        String sentence = "as asas";
        searchService.setSentence(sentence);
        searchService.findWordsAmount(testWords);
        assertTrue(!searchService.getSentence().isEmpty());
    }

    @Test
    public void testIfSentenceIsNotNullExpectResultIsNotNull() {
        Map<String, Integer> words = new HashMap<>();
        String sentence = "Hello , dear !";
        searchService.setSentence(sentence);
        searchService.findWordsAmount(words);
        for (String key : words.keySet()) {
            assertNotNull(key);
        }
    }

    @Test
    public void testIfSentenceIsNullExpectResultIsNull() {
        Map<String, Integer> words = new HashMap<>();
        String sentence = null;
        searchService.setSentence(sentence);
        searchService.findWordsAmount(words);
        for (String key : words.keySet()) {
            assertNull(key);
        }
    }

    @Test
    public void testIfSentenceHasOnlyNumbersResultsIsNull() {
        String sentence = "2 5 623 32 46 5";
        searchService.setSentence(sentence);
        searchService.findWordsAmount(testWords);
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

}