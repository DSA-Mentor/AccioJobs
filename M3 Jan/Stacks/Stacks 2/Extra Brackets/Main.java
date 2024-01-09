import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        // Stack -> storing characters that can be, '(', operator or operand
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // if the character was '(', operator or operand, push in the stack
            if (ch != ')') {
                st.push(ch);
            } else {
                // character is a closing bracket ')'
                if (st.peek() == '(') {
                    // no expression in between
                    // hence extra bracket pair
                    return true;
                } else {
                    // have expression between, you are useful pair
                    // remove the expression
                    while (st.peek() != '(') {
                        st.pop();
                    }

                    // peek will be corresponding opening bracket
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
        if(Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}