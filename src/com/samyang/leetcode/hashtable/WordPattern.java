/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Runtime: 2 ms, faster than 17.78% of Java online submissions for Word Pattern.
 * Memory Usage: 34 MB, less than 97.30% of Java online submissions for Word Pattern.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-25
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<String, String> map = new HashMap<>(16);
        pattern = pattern.trim();
        str = str.trim();

        int len = pattern.length();
        String[] words = str.split(" ");
        if (words.length != len) {
            return false;
        }

        Map<Character, Integer> patternMap = new HashMap<>(16);
        Map<String, Integer> wordMap = new HashMap<>(16);
        Map<Character, String> mapping = new HashMap<>(16);
        for (int i = 0; i < len; i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
            mapping.put(pattern.charAt(i), words[i]);
        }

        if (patternMap.size() != wordMap.size()) {
            return false;
        }

        for (Map.Entry<Character, String> entry: mapping.entrySet()) {
            if (!patternMap.get(entry.getKey()).equals(wordMap.get(entry.getValue()))) {
               return false;
            }
        }

        return true;
    }

}
