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
    int findCelebrity(int M[][], int n) {
        Stack<Integer> potentialCeleb = new Stack<>();
        for (int i = 0; i < n; i++)
            potentialCeleb.push(i);

        while (potentialCeleb.size() != 1) {
            int p1 = potentialCeleb.pop();
            int p2 = potentialCeleb.pop();

            if (M[p1][p2] == 1) {
                potentialCeleb.push(p2);
            } else {
                potentialCeleb.push(p1);
            }
        }

        int celeb = potentialCeleb.pop();

        // row = 0, except M[celeb][celeb], doesn't know anyone
        for (int c = 0; c < n; c++) {
            if (c != celeb) {
                if (M[celeb][c] != 0) {
                    return -1;
                }
            }
        }

        // col = 1, except M[celeb][celeb], known by everyone
        for (int r = 0; r < n; r++) {
            if (r != celeb) {
                if (M[r][celeb] != 1) {
                    return -1;
                }
            }
        }

        return celeb;
    }

}