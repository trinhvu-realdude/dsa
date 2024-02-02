package com.travis.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

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
            map.put(nums[i], i);

            if (target - nums[i] == nums[map.get(nums[i])]) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Array solution = new Array();

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        int[] result = solution.twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}