package org.wq.algorithm.dp;

public class LongestDuplicatedStr {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abcsbabsmscbabcsm"));
        System.out.println(longestRepeatingSubstring("aaa"));
    }

    static public int longestRepeatingSubstring(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int n = S.length();
        int res = 0;

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res , dp[i][j]);
                }
            }
        }

        return res;
    }

}
