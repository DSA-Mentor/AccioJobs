import java.util.*;

class Solution {
    // TC: O(N*logN), SC: O(N)
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        HashMap<Integer, Integer> fmapOfBrr = new HashMap<>();
        for (int num : brr) {
            fmapOfBrr.put(num, fmapOfBrr.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> fmapOfArr = new HashMap<>();
        for (int num : arr) {
            fmapOfArr.put(num, fmapOfArr.getOrDefault(num, 0) + 1);
        }

        for (int key : fmapOfBrr.keySet()) {
            int freqInArr = fmapOfArr.getOrDefault(key, 0);
            fmapOfBrr.put(key, fmapOfBrr.get(key) - freqInArr);
        }

        ArrayList<Integer> missingEle = new ArrayList<>();
        for (int key : fmapOfBrr.keySet()) {
            if (fmapOfBrr.get(key) > 0 || fmapOfBrr.get(key) < 0) {
                missingEle.add(key);
            }
        }

        Collections.sort(missingEle);
        if (missingEle.size() == 0) {
            System.out.print(-1);
        }

        for (int ele : missingEle) {
            System.out.print(ele + " ");
        }
        return;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n, arr, m, brr);
    }
}