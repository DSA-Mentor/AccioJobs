import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(n)
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        HashMap<Integer, Integer> fmap2 = new HashMap<>();
        for (int ele : brr) {
            fmap2.put(ele, fmap2.getOrDefault(ele, 0) + 1);
        }

        // for (int ele : arr) {
        // if (fmap2.containsKey(ele) == true) {
        // fmap2.put(ele, fmap2.get(ele) - 1);
        // }
        // }

        // ArrayList<Integer> list = new ArrayList<>();
        // for (int key : fmap2.keySet()) {
        // if (fmap2.get(key) < 0 || fmap2.get(key) > 0) {
        // list.add(key);
        // }
        // }

        HashMap<Integer, Integer> fmap1 = new HashMap<>();
        for (int ele : arr) {
            fmap1.put(ele, fmap1.getOrDefault(ele, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int key : fmap2.keySet()) {
            if (fmap1.containsKey(key) == false) {
                list.add(key);
            } else if (fmap1.get(key) != fmap2.get(key)) {
                list.add(key);
            }
        }

        if (list.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);

        for (int ele : list) {
            System.out.print(ele + " ");
        }
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