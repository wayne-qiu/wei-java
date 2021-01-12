package org.wq.algorithm;

public class RainCollection {

    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    public int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];

        max_right[height.length-1] = height[height.length-1];
        for (int i = height.length -2; i > 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i]);
        }

        for (int i = 1; i < height.length-1; i++) {
            max_left = Math.max(max_left, height[i-1]);

            if(Math.min(max_left, max_right[i+1]) > height[i]){
                sum += Math.min(max_left, max_right[i+1]) - height[i];
            }
        }
        return sum;
    }


    int trap2Pointes(int[] height)
    {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max ){
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                ++left;
            }
            else {
                if(height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                --right;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] a = new int[]{};
        int[] a = new int[]{1};
//        int[] a = new int[]{1,0,0,1};
//        int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new RainCollection().trap2(a));
    }
}
