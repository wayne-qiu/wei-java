package org.wq.algorithm.dp;

public class MaxContinuousNums {

    static public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n]; //记录了所以最优历史因子,这个例子中不必要

        dp[0] = nums[0];

        int result = dp[0];

        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            result = Math.max(result, dp[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        //int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] a = new int[]{-3,4,-1,2,-5,4};
        System.out.println(maxSubArray(a));
    }
}
