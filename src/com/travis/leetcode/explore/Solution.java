package com.travis.leetcode.explore;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.get(num) != null) {
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return str.contentEquals(reverse);
    }

    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String reverseVowels(String s) {
        String reverseVowels = "";
        int j = s.length() - 1;
        while (j >= 0) {
            char cj = s.charAt(j);
            if (cj == 'a' || cj == 'e' || cj == 'i' || cj == 'o' || cj == 'u' || cj == 'A' || cj == 'E' || cj == 'I' || cj == 'O' || cj == 'U') {
                reverseVowels += cj;
            }
            j--;
        }

        String result = "";

        int i = 0;
        int k = 0;
        while (i < s.length()) {
            char ci = s.charAt(i);
            if (ci == 'a' || ci == 'e' || ci == 'i' || ci == 'o' || ci == 'u' || ci == 'A' || ci == 'E' || ci == 'I' || ci == 'O' || ci == 'U') {
                result += reverseVowels.charAt(k);
                k++;
            }
            result += ci;
            i++;
        }

        return result;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public boolean isValid(String s) {
        return false;
    }

    public String addBinary(String a, String b) {
        return null;
    }

    public int minimumCoins(int[] coins, int total) {
        int min = 0;

        for (int coin : coins) {
            while (total >= coin) {
                total -= coin;
                min++;
            }
        }
        return min;
    }

    public int balancedStringSplit(String s) {
        return -1;
    }

}

class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
