package org.wq.algorithm.dp;

public class Stock2 {

    public static void main(String[] args) {
        int[] a = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }


    public static int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int buy = -prices[0], sell = 0;
        for(int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell-prices[i]);
            sell = Math.max(sell, prices[i] + buy);
        }
        return sell;
    }

}
