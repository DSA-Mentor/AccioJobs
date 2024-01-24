import java.util.ArrayList;

public class Main {
    static class MyStack {
        ArrayList<Integer> list;

        MyStack() {
            list = new ArrayList<>();
        }

        public void push(int e) {
            list.add(e);
        }

        public int peek() {
            if (list.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                int size = list.size();
                return list.get(size - 1);
            }
        }

        public int pop() {
            if (list.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                int size = list.size();
                return list.remove(size - 1);
            }
        }

        public int size() {
            return list.size();
        }
    }

    public static void main(String[] args) {
        MyStack st = new MyStack();

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

        System.out.println("removed ele: " + st.pop());
    }
}
