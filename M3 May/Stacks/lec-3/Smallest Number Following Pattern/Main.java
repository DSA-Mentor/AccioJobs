import java.io.*;
import java.util.*;

class Solution {
    public String smallestNumber(String str) {
        // write code here
        StringBuilder temp = new StringBuilder("");
        StringBuilder res = new StringBuilder("");

        char ch = '1';
        for (char c : str.toCharArray()) {
            temp.append(ch);
            ch = (char) (ch + 1);

            if (c == 'i') {
                res.append(temp.reverse());
                temp = new StringBuilder("");
            }
        }

        temp.append(ch);
        res.append(temp.reverse());

        return res.toString();
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.print(Obj.smallestNumber(str));
    }
}