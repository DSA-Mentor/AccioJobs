import java.util.*;

class Solution {
    public static int longestSubarray(int[] arr) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();

        int x0 = 0;
        int x1 = 0;
        int x2 = 0;

        int a = (x1 - x0);
        int b = (x2 - x1);

        String str = a + "#" + b;

        map.put(str, -1);

        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    x0++;
                    break;
                case 1:
                    x1++;
                    break;
                case 2:
                    x2++;
                    break;
            }

            a = (x1 - x0);
            b = (x2 - x1);
            str = a + "#" + b;

            if (map.containsKey(str) == true) {
                int len = i - map.get(str);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(str, i);
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
