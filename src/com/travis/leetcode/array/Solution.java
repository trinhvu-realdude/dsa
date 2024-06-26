package com.travis.leetcode.array;

import java.util.*;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            }
            if (num == 1) {
                count += 1;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int v[] = new int[n];

        int i = -1;
        while ((i + 1) < n && nums[i + 1] < 0) {
            i++;
        }

        int j = n;
        while ((j - 1) >= 0 && nums[j - 1] >= 0) {
            j--;
        }

        int k = 0;
        while (i >= 0 || j < n) {
            if (i >= 0 && j < n) {
                int ii = nums[i] * nums[i];
                int jj = nums[j] * nums[j];

                if (ii < jj) {
                    v[k] = ii;
                    i--;
                    k++;
                } else {
                    v[k] = jj;
                    j++;
                    k++;
                }
            } else if (i >= 0) {
                v[k] = nums[i] * nums[i];
                i--;
                k++;
            } else {
                v[k] = nums[j] * nums[j];
                j++;
                k++;
            }
        }
        return v;
    }

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer occurrence = map.get(num);
            if (occurrence != null) {
                map.put(num, occurrence + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer value : map.values()) {
            if (value > 2) return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 3, 4};
        System.out.println(solution.isPossibleToSplit(nums));
    }
}
