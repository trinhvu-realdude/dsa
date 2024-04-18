package com.travis.leetcode.problems;

import com.travis.leetcode.problems.difficulty.Easy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Easy easy = new Easy();

        String[] strs = {"flower", "flow", "flight"};
        System.out.println(easy.longestCommonPrefix(strs));
    }
}
