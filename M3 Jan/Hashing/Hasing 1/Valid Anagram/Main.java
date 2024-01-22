import java.util.*;

class Solution {
    static boolean areAnagram(String c1, String c2) {
        // Write your code here
        if (c1.length() != c2.length())
            return false;

        HashMap<Character, Integer> fmap1 = new HashMap<>();
        for (char ch : c1.toCharArray()) {
            fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (char ch : c2.toCharArray()) {
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        for (Character key : fmap1.keySet()) {
            if (fmap2.containsKey(key) == false) {
                return false;
            } else {
                if (fmap2.get(key) != fmap1.get(key)) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();

        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
