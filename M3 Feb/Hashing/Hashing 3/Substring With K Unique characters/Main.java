import java.util.*;

public class Main {
    public static int longestkSubstr(int n, int k, String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        int maxLen = 0;

        int inc = -1;
        int exc = -1;

        while (true) {
            boolean doneSomething = false;
            if (inc + 1 < s.length() && fmap.size() <= k) {
                inc++;
                char ch = s.charAt(inc);

                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if (fmap.size() == k) {
                    int len = inc - exc;
                    maxLen = Math.max(maxLen, len);
                }

                doneSomething = true;
            } else if (exc < inc && fmap.size() > k) {
                exc++;
                char ch = s.charAt(exc);

                fmap.put(ch, fmap.getOrDefault(ch, 0) - 1);

                if (fmap.get(ch) == 0) {
                    fmap.remove(ch);
                }

                doneSomething = true;
            }

            if (doneSomething == false) {
                break;
            }
        }

        return maxLen == 0 ? -1 : maxLen;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n, k, s);
        System.out.println(ans);
    }
}