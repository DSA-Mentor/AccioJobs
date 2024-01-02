import java.util.*;

class Solution {
    // public void allDuplicates(int n, int[] arr) {
    //     // Write Your code here.
    //     HashMap<Integer, Integer> freqMap = new HashMap<>();
    //     ArrayList<Integer> dups = new ArrayList<>();

    //     for (int num : arr) {
    //         int prevFreq = freqMap.getOrDefault(num, 0);
    //         freqMap.put(num, prevFreq + 1);

    //         if (freqMap.get(num) >= 2) {
    //             dups.add(num);
    //         }
    //     }

    //     for (int num : dups) {
    //         System.out.print(num + " ");
    //     }
    //     System.out.println();
    // }

    public void allDuplicates(int n, int[] arr) {
        // Write Your code here.
        HashSet<Integer> mySet = new HashSet<>();
        ArrayList<Integer> dups = new ArrayList<>();

        for (int num : arr) {
            if (mySet.contains(num) == true) {
                dups.add(num);
            } else {
                mySet.add(num);
            }
        }

        for (int num : dups) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr);
        sc.close();
    }
}