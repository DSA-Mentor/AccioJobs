import java.io.*;
import java.util.*;
import java.util.*;

// class Solution {
//     public static boolean isPossible(int[] stalls, int cows, int minDist) {
//         int cowPlaced = 1;
//         int lastPlacedPos = stalls[0];

//         for (int i = 1; i < stalls.length; i++) {
//             if (stalls[i] - lastPlacedPos >= minDist) {
//                 cowPlaced++;
//                 lastPlacedPos = stalls[i];
//             }
//         }

//         return cowPlaced < cows ? false : true;
//     }

//     public static int aggressiveCows(int a[], int cows){
//         Arrays.sort(a);

//         int si = Integer.MAX_VALUE;
//         for (int i = 1; i < a.length; i++) {
//             int dist = a[i] - a[i - 1];
//             si = Math.min(si, dist);
//         }
//         int ei = a[a.length - 1] - a[0];

//         int pans = -1;
//         while (si <= ei) {
//             int mid = (si + ei) / 2;
//             if (isPossible(a, cows, mid) == true) {
//                 pans = mid;
//                 si = mid + 1;
//             } else {
//                 ei = mid - 1;
//             }
//         }

//         return pans;
//     }
// }

class Solution {
    public static boolean isPossible(int[] stalls, int cows, int minDist) {
        int cowPlaced = 1;
        int lastPlacedPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacedPos >= minDist) {
                cowPlaced++;
                lastPlacedPos = stalls[i];
            }
        }

        return cowPlaced < cows ? false : true;
    }

    public static int aggressiveCows(int a[], int cows) {
        Arrays.sort(a);

        int si = 1;
        int ei = 1000000000;

        int pans = 0;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (isPossible(a, cows, mid) == true) {
                pans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return pans;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(nums, k));

    }
}
