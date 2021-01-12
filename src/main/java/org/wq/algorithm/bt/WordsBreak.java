package org.wq.algorithm.bt;

import java.util.*;

//作者：LeetCode
//链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class WordsBreak {

        static public boolean memWordBreak(String s, List<String> wordDict) {
            return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
        }
        static public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
            if (start == s.length()) {
                return true;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
            return memo[start] = false;
        }


    static public boolean bfsWordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(dpWordBreaktest
////        System.out.println(dpWordBreak
//        ("catsanddog", new ArrayList<>(
//                List.of("cats",
//                        "cat",
//                        "sand",
//                        /*"and",*/
//                        "dog"))));

        System.out.println(dpWordBreak
        ("bsc", new ArrayList<>(
                List.of("b",
                        "c"))));
    }


    static public boolean dpWordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            //pre
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        for (boolean v: dp
             ) {
            System.out.print(v+" ");
        }
        System.out.println();
        return dp[s.length()];
    }

}
