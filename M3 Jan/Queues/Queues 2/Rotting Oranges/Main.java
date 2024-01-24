import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();

        System.out.println(obj.orangesRotting(arr));
    }
}

class Solution {
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int orangesRotting(int[][] grid) {
        // write your code here
        Queue<Pair> que = new ArrayDeque<>();

        // add all the rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.add(new Pair(i, j));
                }
            }
        }

        // BFS
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rnode = que.remove();
                int r = rnode.row;
                int c = rnode.col;

                if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    que.add(new Pair(r + 1, c));
                }
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    que.add(new Pair(r - 1, c));
                }
                if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    que.add(new Pair(r, c + 1));
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    que.add(new Pair(r, c - 1));
                }
            }
            level++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        if (level == 0) {
            return 0;
        }
        return level - 1;
    }
}
