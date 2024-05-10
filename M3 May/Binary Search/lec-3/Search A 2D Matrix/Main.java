import java.util.*;

public class Main {
    // TC: O(log N + log M), SC: O(1)
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        // search in last column, for just greater or equal value
        int si = 0;
        int ei = n - 1;

        int pRow = -1;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (mat[mid][m - 1] == x) {
                return true;
            } else if (mat[mid][m - 1] > x) {
                pRow = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        if (pRow == -1) {
            return false;
        }

        // apply Binary Search in Potential Row
        si = 0;
        ei = m - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (mat[pRow][mid] == x) {
                return true;
            } else if (mat[pRow][mid] > x) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if (SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}