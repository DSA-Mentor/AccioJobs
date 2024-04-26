import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> map1 = new HashMap<>();

        int dmcnt = t.length();
        int mcnt = 0;

        int inc = -1;
        int exc = -1;

        String ans = "";
        while (true) {
            boolean didAnything = false;

            if (dmcnt > mcnt && inc + 1 < s.length()) {
                inc++;
                char ch = s.charAt(inc);

                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                if (map2.containsKey(ch) == true && map2.get(ch) >= map1.get(ch)) {
                    mcnt++;
                }

                didAnything = true;
            } else if (dmcnt == mcnt && exc < inc) {
                String currAns = s.substring(exc + 1, inc + 1);
                if (ans == "" || ans.length() > currAns.length()) {
                    ans = currAns;
                }

                exc++;
                char ch = s.charAt(exc);

                map1.put(ch, map1.get(ch) - 1);

                if (map2.containsKey(ch) == true && map2.get(ch) > map1.get(ch)) {
                    mcnt--;
                }

                if (map1.get(ch) == 0) {
                    map1.remove(ch);
                }

                didAnything = true;
            }

            if (didAnything == false) {
                break;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s, t));
    }
}