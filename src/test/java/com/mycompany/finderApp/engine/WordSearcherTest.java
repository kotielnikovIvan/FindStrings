package com.mycompany.finderApp.engine;

import com.mycompany.finderApp.logic.WordSearcher;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WordSearcherTest {

    private WordSearcher wordSearcher;
    private Map<String, Integer> testWords;

    @BeforeEach
    public void createObject() {
        wordSearcher = new WordSearcher();
        testWords = new HashMap<>();
    }

    @Test
    public void when_realSentence_EqualsTo_TestSentence_then_ResultEquals() {
        Map<String, Integer> realWords = new HashMap<>();
        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 2);
        testWords.put("you", 3);

        realWords = wordSearcher.findWordsAmount(
                "hello , I , my , you ! You , my ? Hello . you");

        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }

    @Test
    public void when_sentenceIsNull_then_resultIsNull() {
        testWords = wordSearcher.findWordsAmount(null);
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

    @Test
    public void when_sentenceIsNotNull_then_resultIsNotNull() {
        testWords = wordSearcher.findWordsAmount("Hello world");
        for (String key : testWords.keySet())
            assertNotNull(key);
    }

    @Test
    public void when_sentenceIsEmpty_then_resultIsEmpty() {
        testWords = wordSearcher.findWordsAmount("");
        assertTrue(testWords.isEmpty());
    }

    @Test
    public void when_sentenceIsNotEmpty_then_resultIsNotEmpty() {
        testWords = wordSearcher.findWordsAmount("Hello , dear !");
        assertFalse(testWords.isEmpty());
    }

    @Test
    public void when_sentenceHasOnlyNumbers_then_resultIsNull() {
        testWords = wordSearcher.findWordsAmount("2 5 623 32 46 5");
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

    @Test
    public void when_sentenceOnlyHasSymbols_then_resultIsNull() {
        testWords = wordSearcher.findWordsAmount("! . ? ,");
        for (String key : testWords.keySet()) {
            assertNull(key);
        }
    }

}