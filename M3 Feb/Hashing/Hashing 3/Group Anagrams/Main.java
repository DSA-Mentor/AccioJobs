
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    static String encode(int[] freqArr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            if (freqArr[i] > 0) {
                char ch = (char) ('a' + i);
                sb.append(ch);
                sb.append(freqArr[i]);
            }
        }

        return sb.toString();
    }

    static int[] getFreqArr(String str) {
        int[] freqArr = new int[26];
        for (char ch : str.toCharArray()) {
            int idx = (int) (ch - 'a');
            freqArr[idx] += 1;
        }

        return freqArr;
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> firstOfEachGrp = new ArrayList<>();
        for (String word : wordArr) {
            int[] freqArr = getFreqArr(word);
            String encodedStr = encode(freqArr);

            if (map.containsKey(encodedStr) == false) {
                ArrayList<String> grp = new ArrayList<>();
                grp.add(word);
                firstOfEachGrp.add(word);
                map.put(encodedStr, grp);
            } else {
                ArrayList<String> grp = map.get(encodedStr);
                grp.add(word);
                map.put(encodedStr, grp);
            }
        }

        Collections.sort(firstOfEachGrp);

        for (String str : firstOfEachGrp) {
            int[] freqArr = getFreqArr(str);
            String encodedStr = encode(freqArr);
            ArrayList<String> grp = map.get(encodedStr);
            for (String s : grp) {
                System.out.print(s + " ");
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