import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here

        Stack<Character> st = new Stack();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch != ')') {
                // it will be opening bracket or part of exp
                st.push(ch);
            } else {
                // check if top of the stack is a opening bracket:
                // Callout extra bracket pair, as no expression in between
                if (st.peek() == '(') {
                    return true;
                } else {
                    // remove exp in between
                    while (st.peek() != '(') {
                        st.pop();
                    }

                    // now stack peek is a opening bracket, hence remove it as an exp in between was removed
                    st.pop();
                }
            }
        }

        // No extra bracket
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