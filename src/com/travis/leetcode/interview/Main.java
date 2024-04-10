package com.travis.leetcode.interview;

import java.util.*;

class Interview {

    public static class Array {
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
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
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

        /**
         * Intersection of Two Arrays II
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            List<Integer> result = new ArrayList<>();

            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            int[] v = new int[result.size()];
            for (int k = 0; k < v.length; k++) {
                v[k] = result.get(k);
            }

            return v;
        }

        /**
         * Rotate Image
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            reverse(matrix, 0, matrix.length - 1);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        private void reverse(int[][] matrix, int start, int end) {
            while (start < end) {
                int[] temp = matrix[start];
                matrix[start] = matrix[end];
                matrix[end] = temp;
                start++;
                end--;
            }
        }

        /**
         * Valid Sudoku
         *
         * @param board
         * @return
         */
        public boolean isValidSudoku(char[][] board) {
            return false;
        }

        public static void printArray(int[] arr) {
            System.out.println(Arrays.toString(arr));
        }

        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public static class String {
        /**
         * Reverse String
         *
         * @param s
         */
        public void reverseString(char[] s) {
            int i = 0;
            int j = s.length - 1;

            while (i < j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }

        /**
         * First Unique Character in a String
         *
         * @param s
         * @return
         */
        public int firstUniqChar(java.lang.String s) {
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
                    map.put(s.charAt((i)), i);
                } else {
                    map.remove(s.charAt(i));
                    map.put(s.charAt(i), -1);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) != -1) {
                    return i;
                }
            }

            return -1;
        }

        /**
         * Valid Palindrome
         *
         * @param s
         * @return
         */
        public boolean isPalindrome(java.lang.String s) {
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            if (s.length() > 0) {
                StringBuilder reverse = new StringBuilder();

                int i = s.length() - 1;
                while (i >= 0) {
                    reverse.append(s.charAt(i));
                    i--;
                }

                return reverse.toString().equals(s);
            }
            return true;
        }

        /**
         * Implement strStr()
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(java.lang.String haystack, java.lang.String needle) {
            return haystack.indexOf(needle);
        }

        /**
         * Valid Anagram
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(java.lang.String s, java.lang.String t) {
            java.lang.String s1 = sort(s);
            java.lang.String t1 = sort(t);
            return s1.equals(t1);
        }

        private java.lang.String sort(java.lang.String s) {
            StringBuilder result = new StringBuilder();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            for (char c : chars) {
                result.append(c);
            }
            return result.toString();
        }

        /**
         * Longest Common Prefix
         *
         * @param strs
         * @return
         */
        public java.lang.String longestCommonPrefix(java.lang.String[] strs) {
            Arrays.sort(strs);
            java.lang.String s1 = strs[0];
            java.lang.String s2 = strs[strs.length - 1];

            int i = 0;

            while (i < s1.length() && i < s2.length()) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }
            return s1.substring(0, i);
        }

        /**
         * Reverse Integer
         *
         * @param x
         * @return
         */
        public int reverse(int x) {
            return -1;
        }

        /**
         * String to Integer (atoi)
         *
         * @param s
         * @return
         */
        public int myAtoi(String s) {
            return -1;
        }
    }

    public static class DynamicProgramming {
        /**
         * Climbing Stairs
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            int[] arr = new int[n + 1];
            arr[0] = 1;
            arr[1] = 1;

            for (int i = 2; i <= n; i++)
                arr[i] = arr[i - 1] + arr[i - 2];

            return arr[n];
        }

        /**
         * Best Time to Buy and Sell Stock
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
         * Maximum Subarray
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            return -1;
        }

        /**
         * House Robber
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            return -1;
        }
    }

    public static class SortingAndSearching {
        /**
         * Merge Sorted Array
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m;
            int j = 0;

            while (i < nums1.length && j <= n) {
                nums1[i] = nums2[j];
                i++;
                j++;
            }
            Arrays.sort(nums1);
        }

        /**
         * First Bad Version
         *
         * @param n
         * @return
         */
        public int firstBadVersion(int n) {
            // use Binary Search
            int left = 1;
            int right = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (isBadVersion(mid)) {
                    if (!isBadVersion(mid - 1)) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        /**
         * The isBadVersion API is defined in the parent class VersionControl in Leetcode.
         * boolean isBadVersion(int version);
         *
         * @param version
         * @return
         */
        public boolean isBadVersion(int version) {
            return false;
        }
    }

    public static class BinaryTree {
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        TreeNode root;

        BinaryTree(int val) {
            root = new TreeNode(val);
        }

        BinaryTree() {
            root = null;
        }

        public void preOrderTraversal(TreeNode node) {
            if (node != null) {
                System.out.print(node.val + " ");
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }

        public void inOrderTraversal(TreeNode node) {
            if (node != null) {
                inOrderTraversal(node.left);
                System.out.print(node.val + " ");
                inOrderTraversal(node.right);
            }
        }

        public void postOrderTraversal(TreeNode node) {
            if (node != null) {
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                System.out.print(node.val + " ");
            }
        }

        public void print(TreeNode node) {
            System.out.print("Pre-order Traversal: ");
            preOrderTraversal(node);
            System.out.println();

            System.out.print("In-order Traversal: ");
            inOrderTraversal(node);
            System.out.println();

            System.out.print("Post-order Traversal: ");
            postOrderTraversal(node);
            System.out.println();
        }

        /**
         * Maximum Depth of Binary Tree
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            int depth = 0;
            depth = maxDepthRecursive(depth, root);
            return depth;
        }

        public int maxDepthRecursive(int depth, TreeNode node) {
            if (node != null) {
                depth = depth + 1;
                int r1 = maxDepthRecursive(depth, node.left);
                int r2 = maxDepthRecursive(depth, node.right);
                return java.lang.Math.max(r1, r2);
            }
            return depth;
        }
    }

    public static class Math {

        /**
         * Fizz Buzz
         *
         * @param n
         * @return
         */
        public List<java.lang.String> fizzBuzz(int n) {
            List<java.lang.String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    list.add(java.lang.String.valueOf(i));
                } else {
                    if (i % 3 == 0 && i % 5 == 0) {
                        list.add("FizzBuzz");
                    } else {
                        if (i % 3 == 0) list.add("Fizz");
                        if (i % 5 == 0) list.add("Buzz");
                    }
                }
            }
            return list;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Interview.Math solution = new Interview.Math();
        int n = 15;
        System.out.println(solution.fizzBuzz(n));
    }
}