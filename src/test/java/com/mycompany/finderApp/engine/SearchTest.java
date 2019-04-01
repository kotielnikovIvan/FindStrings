package com.mycompany.finderApp.engine;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    private Search search = new Search();
    private Map<String, Integer> testWords = new HashMap<>();

    @Test
    public void realSentenceEqualsToTestSentenceExpectResultIsEquals() {
        Map<String, Integer> realWords = new HashMap<>();
        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 2);
        testWords.put("you", 3);

        realWords = search.findWordsAmount("hello , I , my , you ! You , my ? Hello . you");

        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }

    @Test
    public void ifSentenceIsNullExpectResultIsNull() {
        testWords = search.findWordsAmount(null);
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

    @Test
    public void ifSentenceIsNotNullExpectResultIsNotNull() {
        testWords = search.findWordsAmount("Hello world");
        for (String key : testWords.keySet())
            assertNotNull(key);
    }

    @Test
    public void ifSentenceIsEmptyExpectResultIsEmpty() {
        testWords = search.findWordsAmount("");
        assertTrue(testWords.isEmpty());
    }

    @Test
    public void ifSentenceIsNotEmptyExpectResultIsNotEmpty() {
        testWords = search.findWordsAmount("Hello , dear !");
        assertFalse(testWords.isEmpty());
    }

    @Test
    public void ifSentenceHasNumbersExpectResultsIsNull() {
        testWords = search.findWordsAmount("2 5 623 32 46 5");
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

    @Test
    public void ifSentenceHasSymbolsExpectResultIsNull() {
        testWords = search.findWordsAmount("! . ? ,");
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

}