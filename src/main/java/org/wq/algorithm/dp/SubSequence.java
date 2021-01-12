package org.wq.algorithm.dp;

import java.util.Arrays;

public class SubSequence {

    //@五分钟学算法//www.cxyxiaowu.com
    public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    // dp[i] -> the longest length sequence from 0 - i, and must include nums[i]
    int[] dp = new int[nums.length];

    Arrays.fill(dp, 1);

    int max = 0;

    for (int i = 0; i < nums.length; ++i) {
        for (int j = 0; j < i; ++j) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        max = Math.max(max, dp[i]);
    }

    return max;
}

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
