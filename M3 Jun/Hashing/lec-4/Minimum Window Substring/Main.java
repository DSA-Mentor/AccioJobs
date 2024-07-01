import java.io.*;
import java.util.*;

class Solution {
    // TC: O(N + M), SC: o(52) ~ O(1)
    public String minWindow(String s, String t) {
        // create freqMap of String t
        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        int dmcnt = t.length();
        int mcnt = 0;

        int inc = -1;
        int exc = -1;

        HashMap<Character, Integer> fmap1 = new HashMap<>();

        String ans = "";
        while (true) {
            boolean wordDone = false;
            if (inc + 1 < s.length() && dmcnt != mcnt) {
                inc++;

                char ch = s.charAt(inc);
                fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

                if (fmap2.containsKey(ch) == true && fmap1.get(ch) <= fmap2.get(ch)) {
                    mcnt++;
                }

                wordDone = true;
            } else if (exc < inc && mcnt == dmcnt) {
                String subString = s.substring(exc + 1, inc + 1);
                if (ans.equals("") == true || ans.length() > subString.length()) {
                    ans = subString;
                }

                exc++;

                char ch = s.charAt(exc);
                fmap1.put(ch, fmap1.get(ch) - 1);

                if (fmap2.containsKey(ch) == true && fmap1.get(ch) < fmap2.get(ch)) {
                    mcnt--;
                }

                if (fmap1.get(ch) == 0) {
                    fmap1.remove(ch);
                }

                wordDone = true;
            }

            if (wordDone == false) {
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