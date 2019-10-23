/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.str;

/**
 * 58. Length of Last Word
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
 * Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Length of Last Word.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-23
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int len = s.length();
        int stop = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            stop = i;
        }
        return len - stop;
    }

}
