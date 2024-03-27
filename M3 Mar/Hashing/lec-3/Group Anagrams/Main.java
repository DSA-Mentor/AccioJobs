
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    static String encoding(String str) {
        // create a fArray of character
        int[] fArray = new int[26];
        for (char ch : str.toCharArray()) {
            int idx = (int) (ch - 'a');
            fArray[idx]++;
        }

        // create encoded string
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            if (fArray[i] > 0) {
                sb.append((char) ('a' + i));
                sb.append(fArray[i]);
            }
        }

        return sb.toString();
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> firstEle = new ArrayList<>();

        for (String word : wordArr) {
            String encodedString = encoding(word);

            ArrayList<String> grp;
            if (map.containsKey(encodedString) == false) {
                firstEle.add(word);
                grp = new ArrayList<>();
            } else {
                grp = map.get(encodedString);
            }

            grp.add(word);
            map.put(encodedString, grp);
        }

        Collections.sort(firstEle);

        for (String ele : firstEle) {
            String encodedString = encoding(ele);
            for (String w : map.get(encodedString)) {
                System.out.print(w + " ");
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