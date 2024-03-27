import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // Initialize a frequency map for characters in t
        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        // Desired match count is the length of t
        int dmct = t.length();
        // Match count initialized to 0
        int mct = 0;

        // Pointers for the sliding window
        int inc = -1; // inclusive pointer
        int exc = -1; // exclusive pointer

        // Frequency map for characters in the current window of s
        HashMap<Character, Integer> fmap1 = new HashMap<>();

        // String to store the answer
        String ans = "";

        // Main loop to traverse the string s
        while (true) {
            boolean inInc = false; // Flag to check if we can include more characters
            // Check if we can include another character to match t
            if (inc + 1 < s.length() && mct != dmct) {
                inc++;
                char ch = s.charAt(inc);
                fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);

                // If the character is in t and its count does not exceed in fmap2, increase the
                // match count
                if (fmap2.containsKey(ch) && fmap1.get(ch) <= fmap2.get(ch)) {
                    mct++;
                }

                inInc = true;
            }

            boolean inExc = false; // Flag to check if we can exclude characters from the start
            // Check if we can exclude characters from the start to minimize the window size
            if (exc < inc && dmct == mct) {
                String substr = s.substring(exc + 1, inc + 1);
                // Update the answer if it's either the first found substring or shorter than
                // the current answer
                if (ans.isEmpty() || substr.length() < ans.length()) {
                    ans = substr;
                }

                exc++;
                char ch = s.charAt(exc);
                fmap1.put(ch, fmap1.get(ch) - 1);

                // If removing the character reduces the match count, decrease the match count
                if (fmap2.containsKey(ch) && fmap1.get(ch) < fmap2.get(ch)) {
                    mct--;
                }

                // Remove the character from fmap1 if its count becomes 0 to keep the map clean
                if (fmap1.get(ch) == 0) {
                    fmap1.remove(ch);
                }

                inExc = true;
            }

            // Break the loop if no more characters can be included or excluded to find a
            // better match
            if (!inInc && !inExc) {
                break;
            }
        }

        // Return the minimum window substring that contains all characters of t
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