package org.wq.algorithm;

import java.util.Arrays;

public class MergeSort {

    static public void mergeSort(int[] array,int start,int end){
        if(start < end){
//折半成两个小集合，分别进行递归
            int mid=(start+end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1,end);
//把两个有序小集合，归并成一个大集合
            merge(array, start, mid,end);
        }
    }

    static private void merge(int[] array, int start, int mid, int end){
        int p1 = start;
        int p2 = mid+1;
        int p = 0;
        int[] temp = new int[end-start+1];
        while( p1 <= mid && p2 <= end ){
            if(array[p1] < array[p2]){
                temp[p++] = array[p1++];
            }else{
                temp[p++] = array[p2++];
            }
        }
        if(p1 <= mid){
            for(int i=p1; i <= mid;) {
                temp[p++] = array[i++];
            }
        }
        if(p2 <= end){
            for(int i=p2; i <= end;){
                temp[p++] = array[i++];
            }
        }
        for(int i=0 ; i< temp.length; i++){
            array[start++] = temp[i];
        }

    }


    public static void main(String[] args){
        int[] array ={5,8,6,3,9,2,1,7};
        mergeSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
