package org.wq.algorithm.fc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleTimes {
    public List<Long> productExcludeItself(List<Integer> A) {
        List<Long> B = new ArrayList<Long>();
        if (A == null || A.size() == 1){
            long bi = 1;
            B.add(bi);
            return B;
        }

        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        left[0] = 1;

        for (int i = 1; i < A.size(); i++){
            left[i] = left[i-1] * A.get(i-1);
        }

        right[A.size()-1] = 1;
        for (int i = A.size()-2; i>=0 ; i--){
            right[i] = right[i+1] * A.get(i+1);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < A.size(); i++){
            long res = right[i] * left[i];
            B.add(res);
        }

        return B;
    }

    public static void main(String[] args) {

        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(5);

        List<Long> result = new MultipleTimes().productExcludeItself(i);
        System.out.println(result);
    }
}
