package com.travis.leetcode.problems.difficulty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Easy {

    /**
     * 1. Two Sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.get(num) != null) {
                return new int[]{map.get(num), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * 9. Palindrome Number
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return str.contentEquals(reverse);
    }

    /**
     * 14. Longest Common Prefix
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int i = 0;

        StringBuilder result = new StringBuilder();

        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                result.append(s1.charAt(i));
                i++;
            } else {
                break;
            }
        }

        return result.toString();
    }

    /**
     * 20. Valid Parentheses
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('0');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                char top = stack.peek();
                if ((top == '(' && c == ')')
                        || (top == '[' && c == ']')
                        || (top == '{' && c == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }
        return index + 1;
    }

    /**
     * 27. Remove Element
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /**
     * 28. Find the Index of the First Occurrence in a String
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 35. Search Insert Position
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
                if (nums[i] > target) return i;
            }
        }
        return -1;
    }

    /**
     * 58. Length of Last Word
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] strs = s.trim().split(" ");
        return strs[strs.length - 1].length();
    }

    /**
     * 66. Plus One
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 69. Sqrt(x)
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 70. Climbing Stairs
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    /**
     * 88. Merge Sorted Array
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while (i < n) {
            nums1[m] = nums2[i];
            m++;
            i++;
        }
        Arrays.sort(nums1);
    }

    /**
     * 121. Best Time to Buy and Sell Stock (1ms)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        for (int price : prices) {
            if (price < buy) buy = price;
            int profit = price - buy;
            if (profit > max) max = profit;
        }
        return max;
    }

    /**
     * 125. Valid Palindrome (14ms)
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "").trim().toLowerCase();
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    /**
     * 136. Single Number (14ms)
     * Momo Interview
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1;
    }

    /**
     * 169. Majority Element
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > (double) nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    /**
     * 217. Contains Duplicate
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                if (map.get(num) == 1) return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    /**
     * 219. Contains Duplicate II (8ms)
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int j = map.get(nums[i]);
                if (Math.abs(i - j) <= k) return true;
                else {
                    map.remove(nums[i]);
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 242. Valid Anagram
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        return false;
    }
}
