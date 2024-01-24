import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // write code here
        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freqMap2.put(ch, freqMap2.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> freqMap1 = new HashMap<>();

        int dmcnt = t.length();
        int mcnt = 0;

        int inc = -1;
        int exc = -1;

        String ans = "";

        while (true) {
            boolean flag1 = false;
            if (inc + 1 < s.length() && mcnt < dmcnt) {
                inc += 1;
                char ch = s.charAt(inc);
                if (freqMap2.containsKey(ch) == true) {
                    if (freqMap2.get(ch) > freqMap1.getOrDefault(ch, 0)) {
                        mcnt++;
                    }
                }
                freqMap1.put(ch, freqMap1.getOrDefault(ch, 0) + 1);
                flag1 = true;
            }

            boolean flag2 = false;
            if (exc < inc && mcnt == dmcnt) {
                if (ans == "" || ans.length() > (inc - exc)) {
                    ans = s.substring(exc + 1, inc + 1);
                }

                exc += 1;
                char ch = s.charAt(exc);
                freqMap1.put(ch, freqMap1.get(ch) - 1);

                if (freqMap2.containsKey(ch) == true) {
                    if (freqMap2.get(ch) > freqMap1.get(ch)) {
                        mcnt--;
                    }
                }

                if (freqMap1.get(ch) == 0) {
                    freqMap1.remove(ch);
                }
                flag2 = true;
            }

            if (flag1 == false && flag2 == false) {
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