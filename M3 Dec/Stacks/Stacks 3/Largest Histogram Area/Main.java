import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution
{
    // static int[] nextSmallerElementOnLeftIndexwise(long[] hist, int n) {
    //     // Stack: people looking for there next smaller element on left
    //     Stack<Integer> st = new Stack();

    //     int[] nseli = new int[n];
        
    //     // move: right to left
    //     for (int i = n - 1; i >= 0; i--) {
    //         long ele = hist[i];

    //         while (st.size() > 0 && ele < hist[st.peek()]) {
    //             int idx = st.peek();
    //             nseli[idx] = i;
    //             st.pop();
    //         }

    //         st.push(i);
    //     }

    //     // people who are not able find there nsel
    //     while (st.size() != 0) {
    //         int idx = st.peek();
    //         nseli[idx] = -1;
    //         st.pop();
    //     }

    //     return nseli;
    // }

    // static int[] nextSmallerElementOnRightIndexwise(long[] hist, int n) {
    //     // Stack: people looking for there next smaller element on right
    //     Stack<Integer> st = new Stack();

    //     int[] nseri = new int[n];
        
    //     // move: left to right
    //     for (int i = 0; i < n; i++) {
    //         long ele = hist[i];

    //         while (st.size() > 0 && ele < hist[st.peek()]) {
    //             int idx = st.peek();
    //             nseri[idx] = i;
    //             st.pop();
    //         }

    //         st.push(i);
    //     }

    //     // people who are not able find there nser
    //     while (st.size() != 0) {
    //         int idx = st.peek();
    //         nseri[idx] = (int) n;
    //         st.pop();
    //     }

    //     return nseri;
    // }

    // // TC: O(N), SC: O(N)
    // public static long maximumArea(long hist[], long n){
    // 	//Your code here   
    //     // step 1: get next smaller element on left
    //     int[] nseli = nextSmallerElementOnLeftIndexwise(hist, (int) n);
        
    //     // step 2: get next smaller element on right
    //     int[] nseri = nextSmallerElementOnRightIndexwise(hist, (int) n);

    //     // step 3: get width: nseri[i] - nseli[i] - 1, Area = width * hist[i];
    //     long maxArea = 0;

    //     for (int i = 0; i < (int) n; i++) {
    //         int width = nseri[i] - nseli[i] - 1;
    //         long currArea = width * hist[i];
    //         maxArea = Math.max(maxArea, currArea);
    //     }

    //     return maxArea;
    // }


    // TC: O(N), SC: O(N)
    public static long maximumArea(long hist[], long n){
    	// Your code here   
        
        // Stack: people looking for there next smaller element on left
        Stack<Integer> st = new Stack();

        long maxArea = 0;
        
        // move: right to left
        for (int i = (int) n - 1; i >= 0; i--) {
            long ele = hist[i];

            while (st.size() > 0 && ele < hist[st.peek()]) {
                int idx = st.peek();
                int nseli = i;
                st.pop();
                
                int nseri;
                if (st.size() == 0) {
                    nseri = (int) n;
                } else {
                    nseri = st.peek();
                }

                int width = nseri - nseli - 1;
                long currArea = width * hist[idx];
                maxArea = Math.max(maxArea, currArea);
            }

            st.push(i);
        }

        // people who are not able find there nsel
        while (st.size() != 0) {
            int idx = st.peek();
            int nseli = -1;
            st.pop();

            int nseri;
            if (st.size() == 0) {
                nseri = (int) n;
            } else {
                nseri = st.peek();
            }

            int width = nseri - nseli - 1;
            long currArea = width * hist[idx];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}



