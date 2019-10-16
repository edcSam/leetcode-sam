/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.str;

import java.math.BigDecimal;

/**
 * 67. Add Binary
 * Runtime: 29 ms, faster than 7.03% of Java online submissions for Add Binary.
 * Memory Usage: 37.4 MB, less than 7.86% of Java online submissions for Add Binary.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-10
 */
class AddBinary {

    public static final BigDecimal ZERO = new BigDecimal(0);
    public static final BigDecimal ONE = new BigDecimal(1);
    public static final BigDecimal TWO = new BigDecimal(2);

    public static String addBinary(String a, String b) {
        BigDecimal x = binaryToBigDecimal(a);
        BigDecimal y = binaryToBigDecimal(b);
        return bigDecimalToBinary(x.add(y));
    }

    public static BigDecimal binaryToBigDecimal(String binary) {
        int len = binary.length();
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < len; i++) {
            if (binary.charAt(i) == '1') {
                BigDecimal each = TWO.pow(len - (i + 1));
                result = result.add(each);
            }
        }
        return result;
    }

    public static String bigDecimalToBinary(BigDecimal bigDecimal) {
        StringBuilder result = new StringBuilder();
        BigDecimal[] each = new BigDecimal[]{bigDecimal};
        do {
            each = each[0].divideAndRemainder(TWO);
            if (each[1].equals(ONE)) {
                result.append("1");
            } else {
                result.append("0");
            }
        } while (!each[0].equals(ZERO));
        return result.reverse().toString();
    }

}
