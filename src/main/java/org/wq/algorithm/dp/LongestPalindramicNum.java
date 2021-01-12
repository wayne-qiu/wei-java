package org.wq.algorithm.dp;

public class LongestPalindramicNum {

    static public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        //cur
        for (int j = 1; j < len; j++) {
            //pre
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    static public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String len1 = expandAroundCenter(s, i, i); // 3
            String len2 = expandAroundCenter(s, i, i + 1); //2
            String temp = len1.length()>len2.length()?len1:len2;

            result = temp.length()>result.length()?temp:result;
        }
        return result;
    }

    static private String expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        String result = "";
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            result = s.substring(L,R+1);
            L--;
            R++;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abcsbabsmscbabcsm"));
        System.out.println(longestPalindrome2("aaba"));
    }

}
