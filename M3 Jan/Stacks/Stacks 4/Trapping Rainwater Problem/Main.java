import java.io.*;
import java.util.*;

class Solution {
    // // TC: O(N), SC: O(N)
    // public void TappingWater(int[] arr, int n) {
    //     int[] lmax = new int[n];
    //     lmax[0] = 0;
    //     for (int i = 1; i < n; i++) {
    //         lmax[i] = Math.max(lmax[i - 1], arr[i]);
    //     }

    //     int[] rmax = new int[n];
    //     rmax[n - 1] = 0;
    //     for (int i = n - 2; i >= 0; i--) {
    //         rmax[i] = Math.max(rmax[i + 1], arr[i]);
    //     }

    //     // min of rmax and lmax in height of water
    //     int waterStored = 0;
    //     for (int i = 0; i < n; i++) {
    //         int heightTillWaterCanGo = Math.min(lmax[i], rmax[i]);

    //         if (heightTillWaterCanGo > arr[i]) {
    //             waterStored = (heightTillWaterCanGo - arr[i]);
    //         }
    //     }

    //     return waterStored;
    // }

    // TC: O(N), SC: O(1)
    public void TappingWater(int[] arr, int n) {
        int LB = arr[0];
        int RB = arr[n - 1];

        int l = 1;
        int r = n - 2;

        int waterStored = 0;
        while (l <= r) {
            if (RB >= LB) {
                // LB in limiting
                int hw = LB;
                if (hw > arr[l]) {
                    waterStored += hw - arr[l];
                }

                LB = Math.max(LB, arr[l]);
                l++;
            } else {
                // RB is limiting
                int hw = RB;
                if (hw > arr[r]) {
                    waterStored += hw - arr[r];
                }

                RB = Math.max(RB, arr[r]);
                r--;
            }
        }

        System.out.println(waterStored);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}