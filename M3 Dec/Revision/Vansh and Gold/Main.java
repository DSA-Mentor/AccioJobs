import java.util.*;

class Solution {
    public static int maximumArea(int hist[], int n){
		//Your code here 
		int maxArea = 0;

		// people looking nsel
		Stack<Integer> st = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			int ele = hist[i];

			while (st.size() > 0 && ele < hist[st.peek()]) {
				int idx = st.pop();
				int LB = i;

				int RB = (int) n;
				if (st.size() > 0) {
					RB = st.peek();
				}

				int w = RB - LB - 1;
				int h = hist[idx];
				int area = h * w;
				maxArea = Math.max(maxArea, area);
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			int LB = -1;

			int RB = (int) n;
			if (st.size() > 0) {
				RB = st.peek();
			}

			int w = RB - LB - 1;
			int h = hist[idx];
			int area = h * w;
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
    }

    public static int maxDiggingArea(int[][] mat, int n, int m) {
        //Write your code here
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] != 0) {
                    mat[r][c] += mat[r - 1][c];
                }
            }
        }

        int maxArea = 0;
        for (int r = 0; r < n; r++) {
            int area = maximumArea(mat[r], m);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        }
        System.out.println(Solution.maxDiggingArea(arr, n, m));
        sc.close();
    }

}