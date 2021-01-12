package dp;

import java.util.ArrayDeque;
import java.util.Deque;

class IntPair{
    int r;
    int c;
    int step;
    IntPair(int r, int c, int step){
        this.r = r;
        this.c = c;
        this.step = step;
    }
}

public class MinExtension {

    static Deque<IntPair> queue = new ArrayDeque<IntPair>();

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(new IntPair(r,c,1));
                }
            }
        }

        while (queue.peek() != null) {
            IntPair node = queue.poll();

            if (!inArea(grid, node.r, node.c)) {
                continue;
            }

            if(grid[node.r][node.c] > 1){
                continue;
            }

            grid[node.r][node.c] = node.step+1;

            if(result<grid[node.r][node.c]){
                result = grid[node.r][node.c];
            }

            queue.offer(new IntPair(node.r - 1 , node.c , grid[node.r][node.c]));
            queue.offer(new IntPair(node.r + 1 , node.c , grid[node.r][node.c]));
            queue.offer(new IntPair(node.r , node.c - 1 , grid[node.r][node.c]));
            queue.offer(new IntPair(node.r , node.c + 1 , grid[node.r][node.c]));
        }

        return result-2;
    }


    static boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {

//        int[][] a = new int[][]{
//                {0,1,1,0,1},
//                {0,1,0,1,0},
//                {0,0,0,0,1},
//                {0,1,0,0,0}
//        };

        int[][] a = new int[][]{
                {1, 0, 0, 1}
        };

        System.out.println(maxAreaOfIsland(a));
    }
}
