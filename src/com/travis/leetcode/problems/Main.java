package com.travis.leetcode.problems;

import com.travis.leetcode.problems.roadmap.ArrayHashing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayHashing arrayHashing = new ArrayHashing();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(arrayHashing.groupAnagrams(strs));
    }
}
