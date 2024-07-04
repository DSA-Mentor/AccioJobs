import java.util.Arrays;

public class Main {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 30, 4, 2, 11, 90 };

        Arrays.sort(arr, (a, b) -> {
            return b - a;
        });

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Pair[] brr = {new Pair(10, 20), new Pair(-10, 13), new Pair(10, 1), new
        // Pair(10, 24)};
        // Arrays.sort(brr, (a, b) -> {
        // if (a.x == b.x) {
        // return b.y - a.y;
        // }

        // return a.x - b.x;
        // });

        Pair[] brr = { new Pair(10, 20), new Pair(-10, 13), new Pair(10, 1), new Pair(10, 24) };
        Arrays.sort(brr, (a, b) -> {
            int sum1 = a.x + a.y;
            int sum2 = b.x + b.y;

            return sum1 - sum2;
        });

        for (Pair p : brr) {
            System.out.print("(" + p.x + ", " + p.y + "), ");
        }
    }
}