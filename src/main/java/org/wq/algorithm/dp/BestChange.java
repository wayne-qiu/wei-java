package org.wq.algorithm.dp;


public class BestChange {

    static public int dp(int n) {
        n++;
        int[] coins = new int[n];
        int[] V = {1, 3, 5};
        coins[0]=0;
        for (int i = 1; i < n; i++) {
            coins[i] =  coins[i-1]+1;
            for (int j = 0; j < V.length; j++) {
                if (V[j] > i) {
                    break;
                }
                // min
                if (coins[i - V[j]] < coins[i-1]) {
                    coins[i] = coins[i - V[j]] + 1;
                }
            }
        }
        return coins[n - 1];
    }

    public static void main(String[] args) {

        System.out.println(dp(4));
    }
}
