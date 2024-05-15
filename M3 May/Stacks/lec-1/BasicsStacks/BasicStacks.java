import java.util.Stack;

public class BasicStacks {
    public static void main(String[] args) {
        // initialize a stack
        Stack<Integer> st = new Stack<>();

        // add elements to the stack
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(-10);

        // size of the stack
        System.out.println("size: " + st.size());

        // topmost element of the stack
        System.out.println("peek: " + st.peek());

        // size of the stack
        System.out.println("size: " + st.size());

        // remove from the stack
        System.out.println("pop: " + st.pop());

        // size of the stack
        System.out.println("size: " + st.size());

        // size of the stack
        System.out.println("peek: " + st.peek());
    }
}
