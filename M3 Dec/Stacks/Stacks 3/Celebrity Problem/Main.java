import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M, N));
    }
}

class Solution {
    // TC: O(N), SC: O(N)
    int findCelebrity(int M[][], int n) {
        Stack<Integer> possibleCelebs = new Stack();
        for (int i = 0; i < n; i++) {
            possibleCelebs.push(i);
        }

        while (possibleCelebs.size() > 1) {
            int p1 = possibleCelebs.pop();
            int p2 = possibleCelebs.pop();

            if (M[p1][p2] == 1) {
                // person 1 knows person 2
                possibleCelebs.push(p2);
            } else {
                // person 1 doesn't know person 2
                possibleCelebs.push(p1);
            }
        }

        int possibleCeleb = possibleCelebs.pop();

        // row = 0
        for (int c = 0; c < n; c++) {
            if (possibleCeleb != c && M[possibleCeleb][c] == 1) {
                return -1;
            }
        }

        // col = 1
        for (int r = 0; r < n; r++) {
            if (possibleCeleb != r && M[r][possibleCeleb] == 0) {
                return -1;
            }
        }

        return possibleCeleb;
    }

}