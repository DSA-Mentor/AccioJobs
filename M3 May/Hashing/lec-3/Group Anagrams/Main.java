import java.util.*;

public class Main {
    static String encode(String str) {
        // create a charFreqArr
        int[] cfa = new int[26];

        for (char ch : str.toCharArray()) {
            int pos = (int) (ch - 'a');
            cfa[pos]++;
        }

        // create encoded string: char + freq + ...
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            int freq = cfa[i];
            char ch = (char) ('a' + i);

            sb.append(ch);
            sb.append(freq);
        }

        return sb.toString();
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // firstOfEachGrp
        ArrayList<String> foeg = new ArrayList<>();

        for (String word : wordArr) {
            // encoded string
            String enStr = encode(word);

            ArrayList<String> grp = new ArrayList<>();

            if (map.containsKey(enStr) == true) {
                grp = map.get(enStr);
            } else {
                foeg.add(word);
            }

            grp.add(word);
            map.put(enStr, grp);
        }

        Collections.sort(foeg);

        for (String word : foeg) {
            String enStr = encode(word);

            for (String w : map.get(enStr)) {
                System.out.print(w + " ");
            }
        }
    }

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