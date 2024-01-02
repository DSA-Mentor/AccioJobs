import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] lifetime = new int[k];
        for (int i = 0; i < k; i++) lifetime[i] = sc.nextInt();
        sc.close();
        System.out.println(maxRunTime(n, lifetime));
    }

    public static boolean isPossible(int n, long shift, int[] lifeTime) {
        long totalWork = n * shift;
        long currWork = 0;

        for (int time : lifeTime) {
            if (time <= shift) {
                currWork += time;
            } else {
                currWork += shift;
            }
        }

        return currWork >= totalWork;
    }

    public static long maxRunTime(int n, int[] lifeTime) {
        // your code here
        long lo = 0;
        long hi = 0;
        for (int time : lifeTime) {
            hi += time;
        }
        hi = hi / n;


        long pans = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (isPossible(n, mid, lifeTime) == true) {
                pans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return pans;
    }
}