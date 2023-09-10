// Problem: https://leetcode.com/contest/weekly-contest-318/problems/apply-operations-to-an-array/

import java.util.ArrayList;

class Solution {
    // Approach: Using arraylist. T.C.: O(n), S.C.: O(n)
    // public int[] applyOperations(int[] nums) {
    // int zeroCount = 0;
    // for (int i = 0; i < nums.length - 1; i++) {
    // if (nums[i] == nums[i + 1]) {
    // nums[i] *= 2;
    // nums[i + 1] = 0;
    // zeroCount++;
    // }
    // }

    // // 1st copy all non-zero in a new arraylist so automatically we have all
    // // non-zeroes on left.
    // ArrayList<Integer> ans = new ArrayList<>();
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] != 0) {
    // ans.add(nums[i]);
    // }
    // }
    // // Then just add the 0s at the end, so automatically all 0s are on right.
    // for (int i = 1; i <= zeroCount; i++) {
    // ans.add(0);
    // }

    // // Move from arraylist to array as that's what we need to return.
    // for (int i = 0; i < nums.length; i++) {
    // nums[i] = ans.get(i);
    // }
    // return nums;
    // }

    // Alternate approach: 2-pointer. T.C.: O(n), S.C.: O(1)
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Bring all non-0 elements to left such that [0, i] -> all non-0
        int i = 0, j = 0; // i -> last non-zero, j -> to traverse nums[] to find non-zeroes beyond i
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }

        // [i + 1, nums.length - 1] -> all 0s
        while (i < nums.length) {
            nums[i++] = 0;
        }

        return nums;
    }
}