import java.util.*;

class Solution {
    public static int longestSubarray(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        String key = (c1 - c0) + "$" + (c2 - c1);
        map.put(key, -1);

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            } else if (arr[i] == 2) {
                c2++;
            }

            key = (c1 - c0) + "$" + (c2 - c1);

            if (map.containsKey(key) == true) {
                int len = i - map.get(key);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
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
