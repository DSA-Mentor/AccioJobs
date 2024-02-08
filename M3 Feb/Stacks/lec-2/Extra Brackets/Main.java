import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(1)
    public boolean ExtraBrackets(String exp) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch != ')') {
                // opening bracket or an expression
                st.push(ch);
            } else {
                // try finding corresponding opening bracket
                // if you encounter any exp then you are useful pair, else extra bracket

                if (st.peek() == '(') {
                    // you don't have any expression in between
                    return true;
                } else {
                    // remove expression in between
                    while (st.peek() != '(') {
                        st.pop();
                    }

                    // remove corresponding opening bracket
                    st.pop();
                }
            }
        }

        // no extra bracket
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution Obj = new Solution();
        if (Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}