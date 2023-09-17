package com.travis.leetcode.sorting;

class Insertion {
    public static void sort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int j = i;

            while (j > 0 && nums[j - 1] > cur) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = cur;
        }
    }
}

class Selection {
    public static void sort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }
}

class Bubble {
    public static void sort(int[] nums) {
        int n = nums.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }
}

public class Sorting {
    public static void main(String[] args) {
        int[] nums = {2, 6, 1, 0, 9, 10};

        Bubble.sort(nums);
        print(nums);

//        Insertion.sort(nums);
//        print(nums);

//        Selection.sort(nums);
//        print(nums);
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
