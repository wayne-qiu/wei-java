package org.wq.algorithm.binarysearch;

/**
 *
 作者：imageslr
 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/yi-ge-mo-ban-tong-sha-suo-you-er-fen-cha-zhao-wen-/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class BinarySearch {


    int lowerBound(int[] nums, int target) {
        int left = 0,  right = nums.length-1, mid = 0;
        while( left <= right) {
            mid = left + (right-left) / 2;
            if (nums[mid] >= target) { // 这里的比较运算符与题目要求一致
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // 返回下界的下标
    }

    int upperBound(int[] nums, int target) {
        int left = 0,  right = nums.length-1, mid = 0;
        while( left <= right) {
            mid = left + (right-left) / 2;
            if (nums[mid] > target) { // 这里的比较运算符与题目要求一致
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right; // 返回下界的下标
    }

    int searchFirst(int[] nums, int target) {
        int left = 0,  right = nums.length-1, mid = 0;
        while( left <= right) {
            mid = left + (right-left) / 2;
            if (nums[mid] >= target) { // 这里的比较运算符与题目要求一致
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target ){ // 判断一下是否越界，或者不相等
            return -1;
        }

        return left; // 返回下界的下标
    }

    int searchLast(int[] nums, int target) {
        int left = 0,  right = nums.length-1, mid = 0;
        while( left <= right) {
            mid = left + (right-left) / 2;
            if (nums[mid] > target) { // 这里的比较运算符与题目要求一致
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) { // 判断一下是否越界，或者不相等
            return -1;
        }
        return right; // 这里返回 right 而不是 left

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};

//        System.out.println(new BinarySearch().lowerBound(nums, 8));
        System.out.println(new BinarySearch().upperBound(nums, 8));
//        System.out.println(new BinarySearch().searchFirst(nums, 8));
        System.out.println(new BinarySearch().searchLast(nums, 8));
    }
}
