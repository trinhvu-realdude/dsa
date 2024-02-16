package com.travis.leetcode.interview;

import java.util.*;

public class Array {

    /**
     * Remove Duplicates from Sorted Array
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        int count = 0;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[count + 1] = nums[j];
                i = j;
                j = i + 1;
                count++;
            } else {
                j++;
            }

            if (j >= nums.length) {
                count++;
                break;
            }
        }

        return count != 0 ? count : 1;
    }

    /**
     * Best Time to Buy and Sell Stock II
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /**
     * Move Zeroes
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }

        while (i > j) {
            nums[i - 1] = 0;
            i--;
        }
    }

    /**
     * Two Sum
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
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * Plus One
     *
     * @param digits
     * @return
     */
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

    /**
     * Rotate Array
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] v = new int[nums.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = nums[i];
        }


    }

    /**
     * Contains Duplicate
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int value = 0;

        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            } else {
                map.put(num, value + 1);
            }
        }

        return false;
    }

    /**
     * Single Number
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }

        return (int) map.keySet().toArray()[0];
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array solution = new Array();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        solution.rotate(nums, k);

        printArray(nums);
    }
}