import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public static int longestSubarray(int[] arr) {
        int x = 0, y = 0, z = 0;

        HashMap<String, Integer> map = new HashMap<>();

        String str = (y - x) + "#" + (z - y);
        map.put(str, -1);

        int maxL = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val == 0)
                x++;
            else if (val == 1)
                y++;
            else if (val == 2)
                z++;

            str = (y - x) + "#" + (z - y);

            if (map.containsKey(str) == true) {
                int len = i - map.get(str);
                maxL = Math.max(len, maxL);
            } else {
                map.put(str, i);
            }
        }

        return maxL;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
