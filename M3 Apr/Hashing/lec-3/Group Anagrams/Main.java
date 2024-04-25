
import java.util.*;

public class Main {
    static String encode(String str) {
        int[] farr = new int[26];
        for (char ch : str.toCharArray()) {
            int pos = (int) (ch - 'a');
            farr[pos]++;
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            if (farr[i] > 0) {
                sb.append((char) (i + 'a'));
                sb.append(farr[i]);
            }
        }

        return sb.toString();
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> firstOfEachGrp = new ArrayList<>();

        for (String word : wordArr) {
            String e = encode(word);

            if (map.containsKey(e) == false) {
                // first of this grp
                ArrayList<String> grp = new ArrayList<>();
                firstOfEachGrp.add(word);
                grp.add(word);
                map.put(e, grp);
            } else {
                ArrayList<String> grp = map.get(e);
                grp.add(word);
                map.put(e, grp);
            }
        }

        Collections.sort(firstOfEachGrp);

        for (String grpLeader : firstOfEachGrp) {
            String e = encode(grpLeader);

            for (String ele : map.get(e)) {
                System.out.print(ele + " ");
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