package org.wq.algorithm.dp;

public class Stock {

    public static void main(String[] args) {
        int[] a = new int[] {2,8,1,5,3,9,14};
        System.out.println(bestIncome2(a));
    }

    static int bestIncome2(int[] a){
        int buy = a[0];
        int earn = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i]< buy){
                buy = a[i];
            }
            if(a[i]-buy>earn){
                earn = a[i]-buy;
            }
        }

        return earn;
    }

    static int bestIncome(int[] a){
        int min = a[0], maxSale = 0;

        for (int i = 1; i < a.length; i++) {
            if(a[i]<min){
                min = a[i];
            }
            if(a[i]-min > maxSale){
                maxSale = a[i]-min;
            }
        }

        return maxSale;
    }
}
