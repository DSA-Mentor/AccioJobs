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
        // potential celeb
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() != 1) {
            int p1 = st.pop();
            int p2 = st.pop();

            if (M[p1][p2] == 1) {
                // p1 knows p2; p1 can never be a celeb
                st.push(p2);
            } else {
                // p1 doesn't knows p2; p2 can never be a celeb
                st.push(p1);
            }
        }

        // potential celeb index
        int pci = st.pop();

        // row = 0; he should not know anyone
        for (int c = 0; c < n; c++) {
            if (c != pci) {
                if (M[pci][c] == 1) {
                    return -1;
                }
            }
        }

        // col = 1; he should be known by everyone
        for (int r = 0; r < n; r++) {
            if (r != pci) {
                if (M[r][pci] == 0) {
                    return -1;
                }
            }
        }

        return pci;
    }
}