import java.util.Arrays;

public class Main {
    static class Pair {
        public String a;
        public int b;

        Pair(String a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        // Integer[] arr = { 10, 40, 70, 3, 2, 9, 1000 };

        // Arrays.sort(arr);

        // for (int e: arr) System.out.print(e + " ");

        // Arrays.sort(arr, (a, b) -> {
        //     return b - a;
        // });

        // for (int e: arr) System.out.print(e + " ");        


        // Arrays.sort(arr, (a, b) -> {
        //     // custom logic
        //     return b - a;
        // });

        // for (int e : arr)
        //     System.out.print(e + " ");

        Pair[] arr = new Pair[5];
        arr[0] = new Pair("apple", 20);
        arr[1] = new Pair("banana", 50);
        arr[2] = new Pair("grape", -10);
        arr[3] = new Pair("orange", -200);
        arr[4] = new Pair("mango", 500);


        Arrays.sort(arr, (A, B) -> {
            if (A.a.length() == B.a.length()) {
                return B.b - A.b;
            } else {
                return A.b - B.b;
            }
        });

        for (Pair e : arr) {
            System.out.println(e.a + " " + e.b);
        }
    }    
}
