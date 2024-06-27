import java.util.*;

public class Main {
    static int[] getFreqArray(String word) {
        int[] farr = new int[26];

        for (char ch : word.toCharArray()) {
            int pos = (int) (ch - 'a');
            farr[pos]++;
        }

        return farr;
    }

    static String getEncoding(int[] farr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            if (farr[i] > 0) {
                char ch = (char) ('a' + i);
                sb.append(ch);
                sb.append(farr[i]);
            }
        }

        return sb.toString();
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> fog = new ArrayList<>();
        for (String word : wordArr) {
            int[] farr = getFreqArray(word);
            String encoded = getEncoding(farr);

            if (map.containsKey(encoded) == false) {
                ArrayList<String> grp = new ArrayList<>();
                grp.add(word);
                fog.add(word);
                map.put(encoded, grp);
            } else {
                ArrayList<String> grp = map.get(encoded);
                grp.add(word);
                map.put(encoded, grp);
            }
        }

        Collections.sort(fog);
        for (String w : fog) {
            int[] farr = getFreqArray(w);
            String encoded = getEncoding(farr);

            for (String word : map.get(encoded)) {
                System.out.print(word + " ");
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