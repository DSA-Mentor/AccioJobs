
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    // TC: o(M) + o(26) ~ O(M)
    // SC: O(1)
    static String getCode(String word) {
        // step 1: generate a freq array
        int[] freqArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freqArr[(int) (ch - 'a')] += 1;
        }

        // step 2: generate encoded value from freq array
        StringBuilder code = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            if (freqArr[i] > 0) {
                char ch = (char) ('a' + i);
                code.append(ch);
                code.append(freqArr[i]);
            }
        }

        return code.toString();
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        // Map -> key: grp code, value: grp
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> firstOfEachGrp = new ArrayList<>();

        for (String word : wordArr) {
            // encode the string
            String code = getCode(word);

            if (map.containsKey(code) == true) {
                // update the grp
                ArrayList<String> grp = map.get(code);
                grp.add(word);
                map.put(code, grp);
            } else {
                // create a new key value pair
                ArrayList<String> grp = new ArrayList<>();
                grp.add(word);
                firstOfEachGrp.add(word);
                map.put(code, grp);
            }
        }

        Collections.sort(firstOfEachGrp);
        for (String word : firstOfEachGrp) {
            // encode the string
            String code = getCode(word);

            for (String w : map.get(code)) {
                System.out.print(w + " ");
            }
        }

    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++) {
            wordArr[i] = sc.next();
        }

        printAnagramsTogether(wordArr, n);

        sc.close();
    }
}