import java.util.*;

class Solution {
    public static int longestSubarray(int[] arr) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();

        int x = 0;
        int y = 0;
        int z = 0;

        String code = (y - x) + "#" + (z - y);

        map.put(code, -1);

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    x++;
                    break;
                case 1:
                    y++;
                    break;
                case 2:
                    z++;
                    break;
            }

            code = (y - x) + "#" + (z - y);

            if (map.containsKey(code) == true) {
                int len = i - map.get(code);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(code, i);
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
