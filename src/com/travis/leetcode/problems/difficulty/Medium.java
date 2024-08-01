package com.travis.leetcode.problems.difficulty;

import java.util.HashMap;
import java.util.Map;

public class Medium {

    /**
     * 3. Longest Substring Without Repeating Characters
     * 407/987 testcases passed
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder substring = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            if (!substring.toString().contains(character)) {
                substring.append(character);
                map.put(substring.toString(), substring.length());
            } else {
                substring = new StringBuilder();
                substring.append(character);
            }
        }
        int maxLen = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > maxLen) maxLen = map.get(key);
        }
        return maxLen;
    }
}
