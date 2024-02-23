import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        int dmcnt = t.length();
        int mcnt = 0;

        String ans = "";

        int inc = -1;
        int exc = -1;

        HashMap<Character, Integer> fmap1 = new HashMap<>();
        while (true) {
            boolean doneSomething = false;
            if (dmcnt != mcnt && inc + 1 < s.length()) {
                inc++;
                char ch = s.charAt(inc);

                fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

                if (fmap2.containsKey(ch) == true && fmap2.get(ch) >= fmap1.get(ch)) {
                    mcnt++;
                }

                doneSomething = true;
            } else if (dmcnt == mcnt && exc + 1 <= inc) {
                String substr = s.substring(exc + 1, inc + 1);
                if (ans == "" || ans.length() > substr.length()) {
                    ans = substr;
                }

                exc++;
                char ch = s.charAt(exc);

                fmap1.put(ch, fmap1.getOrDefault(ch, 0) - 1);

                if (fmap2.containsKey(ch) && fmap2.get(ch) > fmap1.get(ch)) {
                    mcnt--;
                }

                if (fmap1.get(ch) == 0) {
                    fmap1.remove(ch);
                }

                doneSomething = true;
            }

            if (doneSomething == false) {
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