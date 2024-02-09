import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution ob = new Solution();
        ob.evaluate(exp);
    }
}

class Solution {
    // opr with higher value will have more precedence
    public int getPrecedence(char o) {
        if (o == '+' || o == '-') {
            return 1;
        } else if (o == '*' || o == '/') {
            return 2;
        } else {
            System.out.println("error");
            return -1;
        }
    }

    public int eval(int v1, char o, int v2) {
        switch (o) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                System.out.println("error");
                return -1;
        }
    }

    public int solve(String exp) {
        Stack<Character> opr = new Stack<>();
        Stack<Integer> opd = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                opr.push('(');
            } else if (ch >= '0' && ch <= '9') {
                opd.push((int) (ch - '0'));
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    int v2 = opd.pop();
                    int v1 = opd.pop();
                    char o = opr.pop();

                    int ans = eval(v1, o, v2);
                    opd.push(ans);
                }

                // remove corresponding opening bracket
                opr.pop();
            } else {
                while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(ch) <= getPrecedence(opr.peek())) {
                    int v2 = opd.pop();
                    int v1 = opd.pop();
                    char o = opr.pop();

                    int ans = eval(v1, o, v2);
                    opd.push(ans);
                }

                opr.push(ch);
            }
        }

        while (opr.size() != 0) {
            int v2 = opd.pop();
            int v1 = opd.pop();
            char o = opr.pop();

            int ans = eval(v1, o, v2);
            opd.push(ans);
        }

        return opd.peek();
    }

    public void convert(String exp) {
        Stack<Character> opr = new Stack<>();
        Stack<String> postFix = new Stack<>();
        Stack<String> preFix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                opr.push('(');
            } else if (ch >= '0' && ch <= '9') {
                postFix.push(ch + "");
                preFix.push(ch + "");
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    char o = opr.pop();

                    String v2 = postFix.pop();
                    String v1 = postFix.pop();
                    postFix.push(v1 + v2 + o);

                    v2 = preFix.pop();
                    v1 = preFix.pop();
                    preFix.push(o + v1 + v2);
                }

                // remove corresponding opening bracket
                opr.pop();
            } else {
                while (opr.size() > 0 && opr.peek() != '(' && getPrecedence(ch) <= getPrecedence(opr.peek())) {
                    char o = opr.pop();

                    String v2 = postFix.pop();
                    String v1 = postFix.pop();
                    postFix.push(v1 + v2 + o);

                    v2 = preFix.pop();
                    v1 = preFix.pop();
                    preFix.push(o + v1 + v2);
                }

                opr.push(ch);
            }
        }

        while (opr.size() != 0) {
            char o = opr.pop();

            String v2 = postFix.pop();
            String v1 = postFix.pop();
            postFix.push(v1 + v2 + o);

            v2 = preFix.pop();
            v1 = preFix.pop();
            preFix.push(o + v1 + v2);
        }

        System.out.println(postFix.peek());
        System.out.println(preFix.peek());
    }

    public void evaluate(String exp) {
        System.out.println(solve(exp));
        convert(exp);
    }
}