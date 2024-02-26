import java.util.*;

class Solution {
    // TC: O(N), SC: O(1)
    public static int longestSubarray(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();

        int x = 0;
        int y = 0;
        int z = 0;

        String encoded = (y - x) + "#" + (z - y);

        map.put(encoded, -1);

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                x++;
            else if (arr[i] == 1)
                y++;
            else if (arr[i] == 2)
                z++;

            encoded = (y - x) + "#" + (z - y);

            if (map.containsKey(encoded) == true) {
                int len = i - map.get(encoded);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(encoded, i);
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
