import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int reverseInteger(int x) {
        // write code here
        long rev = 0;

        while (x != 0 && x % 10 == 0) {
            x = x / 10;
        }

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            rev = rev * 10 + digit;

            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) rev;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.reverseInteger(x));

    }
}