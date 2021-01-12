package org.wq.algorithm;

import java.util.Arrays;

class DupArrayDeletion {

    public static void main(String[] args) {

        int[] a = new int[]{1,2,2,3,3,3,4,5};

        int j=0;
        for(int i=1; i<a.length; i++){
            if(a[i]!=a[j]){
                a[++j]=a[i];
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println(j);
    }
}
