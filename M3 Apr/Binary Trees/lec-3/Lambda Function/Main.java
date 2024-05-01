import java.util.Arrays;

public class Main {
    static class Pair {
        int a;
        int b;
        
        Pair() {

        }
        
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        // Integer[] arr = { 5, 4, 3, 7, 6, 1, 2, 8 };

        // sort in increasing order
        // Arrays.sort(arr);

        // default behavior is increasing order
        // this - other
        // reverse of default behavior decreasing order
        // other - this

        // sort in decreasing order
        // Arrays.sort(arr, (a, b) -> {
        //     return b - a;
        // });

        // for (var ele: arr) {
        //     System.out.print(ele + " ");
        // }
        // System.out.println();

        Pair[] arr = new Pair[5];

        arr[0] = new Pair(3, 5);
        arr[1] = new Pair(2, 6);
        arr[2] = new Pair(4, 4);
        arr[3] = new Pair(3, 4);
        arr[4] = new Pair(3, 7);

        // sort the array in such way that a is in inc order and for people have same value b should be in dec order

        // (2, 6), (3, 7), (3, 5), (3, 4), (4, 4)

        Arrays.sort(arr, (x, y) -> {
            if (x.a == y.a) {
                return y.b - x.b;
            } else {
                return x.a - y.a;
            }
        });

        for (var ele: arr) {
            System.out.print("(" + ele.a + " " + ele.b + "), ");
        }
        System.out.println();
    }    
}
