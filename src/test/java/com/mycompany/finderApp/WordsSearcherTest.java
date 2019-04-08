package com.mycompany.finderApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WordsSearcherTest {

    private WordsSearcher wordsSearcher;
    private Map<String, Integer> testWords;

    private String notEmptyText = "All people are different, but we all have something in common";
    private String regularText = "hello, I, my, you! You ,my? Hello .you";
    private String emptyText = "";
    private String nullText;
    private String textWithOnlyNumbers = "2 5 623 32 46 5";
    private String textWithOnlyMarks = "&# # @! $$# ?>< .,";

    @BeforeEach
    public void createObjects() {
        wordsSearcher = new WordsSearcher();
        testWords = new HashMap<>();
    }

    @Test
    public void when_realSentence_EqualsTo_TestSentence_then_ResultEquals() {
        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 2);
        testWords.put("you", 3);

        Map<String, Integer> realWords;
        realWords = wordsSearcher.findWordsAmount(regularText);

        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }

    @Test
    public void when_sentenceIsNull_then_catchException() throws RuntimeException {
        try {
            testWords = wordsSearcher.findWordsAmount(nullText);
            for (String key : testWords.keySet()) {
                assertNull(key);
            }
            Assertions.fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void when_sentenceIsNotNull_then_resultIsNotNull() {
        testWords = wordsSearcher.findWordsAmount(notEmptyText);
        for (String key : testWords.keySet())
            assertNotNull(key);
    }

    @Test
    public void when_sentenceIsEmpty_then_resultIsEmpty() {
        testWords = wordsSearcher.findWordsAmount(emptyText);
        assertTrue(testWords.isEmpty());
    }

    @Test
    public void when_sentenceIsNotEmpty_then_resultIsNotEmpty() {
        testWords = wordsSearcher.findWordsAmount(notEmptyText);
        assertFalse(testWords.isEmpty());
    }

    @Test
    public void when_sentenceHasOnlyNumbers_then_resultIsNull() {
        testWords = wordsSearcher.findWordsAmount(textWithOnlyNumbers);
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

    @Test
    public void when_subSentenceHasOnlySymbols_then_resultIsNull() {
        testWords = wordsSearcher.findWordsAmount(textWithOnlyMarks);
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }
}