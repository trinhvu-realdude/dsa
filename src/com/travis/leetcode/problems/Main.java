package com.travis.leetcode.problems;

import com.travis.leetcode.problems.difficulty.Easy;

public class Main {
    public static void main(String[] args) {
        Easy easy = new Easy();

        String s = "aa", t = "bb";
        System.out.println(easy.isAnagram(s, t));
    }
}
