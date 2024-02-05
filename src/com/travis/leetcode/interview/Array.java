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
        int lastIndex = nums.length - 1;

        int i = lastIndex;
        int j = i - 1;

        int rotateElm = nums[lastIndex];

        while (k > 0) {
            if (j < 0) break;
            nums[i] = nums[j];
            i--;
            j--;

            if (i == 0) {
                nums[0] = rotateElm;
                rotateElm = nums[lastIndex];
                i = lastIndex;
                j = i - 1;
                k--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array solution = new Array();

        int[] digits = {9, 9, 9};

        int[] result = solution.plusOne(digits);

        printArray(result);
    }
}