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
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < M.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int p1 = st.pop();
            int p2 = st.pop();

            if (M[p1][p2] == 0) {
                // p2 is eliminated
                st.push(p1);
            } else {
                // p1 is eliminated
                st.push(p2);
            }
        }

        int pC = st.pop();

        int rn = pC;
        for (int i = 0; i < M.length; i++) {
            if (i != rn && M[rn][i] == 1) {
                return -1;
            }
        }

        int cn = pC;
        for (int i = 0; i < M.length; i++) {
            if (i != cn && M[i][cn] == 0) {
                return -1;
            }
        }

        return pC;
    }

}