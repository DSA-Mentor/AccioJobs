import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // initialize a stack
        Stack<Integer> st = new Stack<>();

        // add some ele
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        // size of the stack
        System.out.println("size: " + st.size());

        // topmost person of the stack
        System.out.println("topmost: " + st.peek());

        // remove from stack
        System.out.println("removed ele: " + st.pop());

        // size of the stack
        System.out.println("size: " + st.size());

        // topmost person of the stack
        System.out.println("topmost: " + st.peek());
    }
}
