import java.io.*;
import java.util.*;

class Solution {
 //    public int[] nextSmallerElementOnLeftIndexwise(int[] arr, int n) {
 //        // Stack: people looking for there nseli
 //        Stack<Integer> st = new Stack<>();

 //        int[] nseli = new int[n];

 //        // move from right to left
 //        for (int i = n - 1; i >= 0; i--) {
 //            int ele = arr[i];

 //            while (st.size() > 0 && ele < arr[st.peek()]) {
 //                int idx = st.pop();
 //                nseli[idx] = i;
 //            }

 //            st.push(i);
 //        }

 //        while (st.size() > 0) {
 //            int idx = st.pop();
 //            nseli[idx] = -1;
 //        }

 //        return nseli;
 //    }

 //    public int[] nextSmallerElementOnRightIndexwise(int[] arr, int n) {
 //        // Stack: people looking for there nseri
 //        Stack<Integer> st = new Stack<>();

 //        int[] nseri = new int[n];

 //        // move from right to left
 //        for (int i = 0; i < n; i++) {
 //            int ele = arr[i];

 //            while (st.size() > 0 && ele <= arr[st.peek()]) {
 //                int idx = st.pop();
 //                nseri[idx] = i;
 //            }

 //            st.push(i);
 //        }

 //        while (st.size() > 0) {
 //            int idx = st.pop();
 //            nseri[idx] = n;
 //        }

 //        return nseri;
 //    }

 //    long mod = 1000000007;
    
	// public long minSubarraySum(int n, int arr[]) {
	// 	// write code here

 //        // Step 1: calculate nseli
 //        int[] nseli = nextSmallerElementOnLeftIndexwise(arr, n);
        
 //        // Step 2: calculate nseri
 //        int[] nseri = nextSmallerElementOnRightIndexwise(arr, n);

 //        // Step 3: calc sum, (i - nseli[i]) * (nseri[i] - i) * arr[i]
 //        long sum = 0;
 //        for (int i = 0; i < n; i++) {
 //            long width = (((i - nseli[i]) % mod) * ((nseri[i] - i) % mod)) % mod;
 //            sum = (((long)(width * arr[i]) % mod) + sum) % mod;
 //        }

 //        return sum % mod;
	// }

    public long minSubarraySum(int n, int arr[]) {
		// write code here
        long mod = 1000000007;
        
        Stack<Integer> st = new Stack<>();
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int ele = arr[i];

            while (st.size() > 0 && ele < arr[st.peek()]) {
                int idx = st.pop();
                int lb = -1;
                if (st.size() > 0) {
                    lb = st.peek();
                }

                long width = ((i - idx) * (idx - lb)) % mod;
                long currSum = (width * arr[idx]) % mod;
                sum = (sum + currSum) % mod;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            int lb = -1;
            if (st.size() > 0) {
                lb = st.peek();
            }

            long width = ((n - idx) * (idx - lb)) % mod;
            long currSum = (width * arr[idx]) % mod;
            sum = (sum + currSum) % mod;
        }

        return sum % mod;
	}
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}