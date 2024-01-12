import java.io.*;
import java.util.*;

class Solution{
	// public long minSubarraySum(int n, int a[]){
	// 	// write code here
 //        int[] nseli = nextSmallerElementOnLeftIndexwise(a, n);
 //        int[] nseri = nextSmallerElementOnRightIndexwise(a, n);

 //        int sum = 0;

 //        for (int i = 0; i < n; i++) {
 //            // l -> people on left = i - nseli[i] - 1
 //            int l = i - nseli[i] - 1;

 //            // r -> people on right = nseri[i] - i - 1
 //            int r = nseri[i] - i - 1;

 //            int totalSubarrays = 1 + (l * 1) + (1 * r) + (l * 1 * r);

 //            sum += totalSubarrays * a[i];
 //        }

 //        return sum;
	// }

    long mod = 1000000007;
    public long minSubarraySum(int n, int a[]){
		// stack -> people looking for there next smaller element on left
        Stack<Integer> st = new Stack<>();

        long sum = 0;

        // move right -> left
        for (int i =  n - 1; i >= 0; i--) {
            int ele = a[i];

            while (st.size() > 0 && ele < a[st.peek()]) {
                int idx = st.pop();

                int lb = i;
                int rb = n;
                if (st.size() > 0) {
                    rb = st.peek();
                }

                int l = idx - lb - 1;
                int r = rb - idx - 1;
                long totalSubarrays = 1 + (l * 1) + (1 * r) + (l * 1 * r);

                sum = ((sum % mod) + (totalSubarrays * a[idx]) % mod) % mod;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();

            int lb = -1;
            int rb = n;
            if (st.size() > 0) {
                rb = st.peek();
            }

            int l = idx - lb - 1;
            int r = rb - idx - 1;
            long totalSubarrays = 1 + (l * 1) + (1 * r) + (l * 1 * r);

            sum = ((sum % mod) + (totalSubarrays * a[idx]) % mod) % mod;
        }
 
        return sum;
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