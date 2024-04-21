package com.travis.leetcode.problems.roadmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayHashing {

    /**
     * 217. Contains Duplicate
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return true;
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
        s = sort(s);
        t = sort(t);
        return s.equals(t);
    }

    private String sort(String s) {
        StringBuilder result = new StringBuilder();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (char c : chars) {
            result.append(c);
        }
        return result.toString();
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int end = nums.length - 1;

        for (int start = 0; start < nums.length; start++) {
            for (int index = start + 1; index < nums.length; index++) {
                if (nums[start] + nums[index] == target) return new int[]{start, index};
                else if (nums[end - start] + nums[end - index] == target) return new int[]{end - start, end - index};
            }
        }
        return null;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }
}
