package org.wq.algorithm.bt;

public class SearchMatrix {

//    public void search(int[][] a, int target){
//
//        int row = 0, col = 0;
//
//        for (; row<0 || row < a.length; ) {
//
//            if(a[row][column] == target){
//                System.out.println(i+""+j);
//                row ++;
//            }else if(a[row][column] < target){
//                row++;
//                column++;
//            }
//
//        }
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                System.out.println(row+","+col);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] a = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(new SearchMatrix().searchMatrix(a, 12));
    }
}
