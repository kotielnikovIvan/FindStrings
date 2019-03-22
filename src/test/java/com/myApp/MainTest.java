package com.myApp;

import org.junit.jupiter.api.Test;
import com.myApp.Main;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testFindWords(){

        Main main = new Main();
        Map<String, Integer> testWords = new HashMap();

        testWords.put("hello", 2);
        testWords.put("i", 1);
        testWords.put("my", 3);
        testWords.put("you", 2);

        main.setSentence("hello, hello/ I. My my You you My!");
        main.findWordsAmount();

        Map<String, Integer> realWords =  main.getWords();

        assertNotNull(realWords);
        assertEquals(testWords.get("hello"), realWords.get("hello"));
        assertEquals(testWords.get("I"), realWords.get("I"));
        assertEquals(testWords.get("my"), realWords.get("my"));
        assertEquals(testWords.get("you"), realWords.get("you"));
    }
}