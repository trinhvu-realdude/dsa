package com.travis.leetcode.problems;

import com.travis.leetcode.problems.difficulty.Easy;

public class Main {
    public static void main(String[] args) {
        Easy easy = new Easy();

        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(easy.singleNumber(nums));
    }
}
