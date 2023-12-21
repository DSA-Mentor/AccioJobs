import java.util.*;

class Solution {
    // TC: O(N*logN)
    // static boolean areAnagram(String c1, String c2) {
    //     //Write your code here
    //     char[] charArray1 = c1.toCharArray();
    //     char[] charArray2 = c2.toCharArray();

    //     Arrays.sort(charArray1);
    //     Arrays.sort(charArray2);

    //     c1 = new String(charArray1);
    //     c2 = new String(charArray2);

    //     if (c1.equals(c2) == true) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    static HashMap<Character, Integer> createFreqMap(String str) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        return freqMap;
    }

    static boolean areAnagram(String c1, String c2) {
        //Write your code here
        if (c1.length() != c2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> freqMap1 = createFreqMap(c1);
        HashMap<Character, Integer> freqMap2 = createFreqMap(c2);

        for (Character key : freqMap1.keySet()) {
            int val = freqMap1.get(key);

            if (freqMap2.getOrDefault(key, 0) != val) {
                return false;
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
