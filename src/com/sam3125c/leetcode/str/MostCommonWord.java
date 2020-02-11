/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. Most Common Word
 * Runtime: 21 ms, faster than 33.40% of Java online submissions for Most Common Word.
 * Memory Usage: 37.5 MB, less than 61.62% of Java online submissions for Most Common Word.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-21
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String ban : banned) {
            bannedSet.add(ban);
        }
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");

        Map<String, Integer> count = new HashMap<>(64);
        for (String word : words) {
            Integer sum = count.get(word);
            if (sum == null) {
                count.put(word, 1);
            } else {
                count.put(word, sum + 1);
            }
        }

        String target= "";
        int max = 0;
        for (Map.Entry each : count.entrySet()) {
            int value = (int)each.getValue();
            String key = each.getKey().toString();
            if (value > max && !bannedSet.contains(key)) {
                max = value;
                target = key;
            }
        }

        return target;
    }

}
