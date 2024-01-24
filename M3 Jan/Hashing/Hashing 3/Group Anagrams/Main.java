
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    static String encode(String word) {
        // create freqArray
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            int pos = (int) (ch - 'a');
            freq[pos] += 1;
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (freq[i] > 0) {
                sb.append(ch);
                sb.append(freq[i]);
            }
        }

        return sb.toString();
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> firstOfEachGrp = new ArrayList<>();

        for (String word : wordArr) {
            String key = encode(word);
            if (map.containsKey(key) == true) {
                ArrayList<String> grp = map.get(key);
                grp.add(word);
                map.put(key, grp);
            } else {
                ArrayList<String> grp = new ArrayList<>();
                grp.add(word);
                map.put(key, grp);
                firstOfEachGrp.add(word);
            }
        }

        Collections.sort(firstOfEachGrp);

        for (String first : firstOfEachGrp) {
            String key = encode(first);
            for (String word : map.get(key)) {
                System.out.print(word + " ");
            }
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}