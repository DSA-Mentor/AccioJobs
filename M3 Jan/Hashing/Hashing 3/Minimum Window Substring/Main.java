import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // write code here
        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        int inc = -1;
        int exc = -1;

        int dmcnt = t.length();
        int mcnt = 0;

        HashMap<Character, Integer> fmap1 = new HashMap<>();

        String ans = "";

        while (true) {
            boolean flag1 = false;
            if (mcnt != dmcnt && inc + 1 < s.length()) {
                inc++;
                char ch = s.charAt(inc);

                if (fmap2.containsKey(ch) == true) {
                    if (fmap2.get(ch) > fmap1.getOrDefault(ch, 0)) {
                        mcnt++;
                    }
                }

                fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

                flag1 = true;
            }

            boolean flag2 = false;
            if (mcnt == dmcnt && exc < inc) {
                if (ans.equals("") || ans.length() > (inc - exc)) {
                    ans = s.substring(exc + 1, inc + 1);
                }

                exc++;
                char ch = s.charAt(exc);

                fmap1.put(ch, fmap1.get(ch) - 1);

                if (fmap2.containsKey(ch) == true) {
                    if (fmap2.get(ch) > fmap1.get(ch)) {
                        mcnt--;
                    }
                }

                if (fmap1.get(ch) == 0) {
                    fmap1.remove(ch);
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