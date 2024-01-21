import java.util.*;
import java.io.*;
class Solution
{
    public static boolean isPossible(int[] arr, int pen, int maxOpt) {
        int currOpt = 0;
        for (int bag : arr) {
            if (bag % pen == 0) {
                currOpt += (bag / pen) - 1;
            } else {
                currOpt += (bag / pen);
            }
        }

        return currOpt <= maxOpt;
    }
    
    public static int solve(int n, int m, int arr[]) {
        int lo = 1;
        int hi = 0;
        for (int ball : arr) {
            hi = Math.max(ball, hi);
        }

        int pans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(arr, mid, m) == true) {
                pans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return pans;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}