import java.util.Stack;

class Main {
    public static void main(String[] args) {
        // intitialize a stack
        Stack<Integer> st = new Stack<>();

        // push method: Pushes an item onto the top of this stack.
        st.push(10);
        st.push(30);
        st.push(40);
        st.push(5);

        // get topmost element
        System.out.println("topmost element: " + st.peek());

        // size of the stacj
        System.out.println("size: " + st.size());

        // remove from stack
        System.out.println("removed ele: " + st.pop());
        System.out.println("removed ele: " + st.pop());
        System.out.println("removed ele: " + st.pop());
        System.out.println("size: " + st.size());
        System.out.println("removed ele: " + st.pop());

        // System.out.println("removed ele: " + st.pop());

        // experiment
        Stack st2 = new Stack<>();

        st2.push(10);
        st2.push("ritik");

        System.out.println(st2.size());

        System.out.println(st2.pop());
        System.out.println(st2.pop());
    }
}