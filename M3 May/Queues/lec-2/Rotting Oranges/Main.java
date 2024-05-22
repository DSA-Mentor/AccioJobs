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
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int orangesRotting(int[][] grid) {
        // write your code here
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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
                Pair rpair = que.remove();

                int r = rpair.r;
                int c = rpair.c;

                if (r + 1 < n && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    que.add(new Pair(r + 1, c));
                }

                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    que.add(new Pair(r - 1, c));
                }

                if (c + 1 < m && grid[r][c + 1] == 1) {
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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
