/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 299. Bulls and Cows
 * Runtime: 11 ms, faster than 8.54% of Java online submissions for Bulls and Cows.
 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Bulls and Cows.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-25
 */
public class BullsAndCows {

    public static String getHint(String secret, String guess) {
        int len = secret.length();
        int A = 0;
        int B = 0;

        Map<Character, Integer> secretMap = new HashMap<>(16);
        Map<Character, Integer> guessMap = new HashMap<>(16);
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) - guess.charAt(i) == 0) {
                A += 1;
            } else {
                secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
                guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        if (A != len) {
            for (Map.Entry<Character, Integer> entry : guessMap.entrySet()) {
                B += entry.getValue() >= secretMap.getOrDefault(entry.getKey(), 0) ?
                        secretMap.getOrDefault(entry.getKey(), 0) : entry.getValue();
            }
        }
        return String.format("%sA%sB", A, B);
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }

}
