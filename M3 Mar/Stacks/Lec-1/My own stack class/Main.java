import java.util.ArrayList;

public class Main {
    static class MyStack {
        ArrayList<Integer> myStack;
        int size;

        MyStack() {
            this.myStack = new ArrayList<>();
            this.size = 0;
        }

        // push method
        void push(int val) {
            this.myStack.add(val);
            this.size++;
        }

        // pop method
        int pop() {
            if (this.size == 0) {
                System.out.println("Stack is Empty");
                return -1;
            } else {
                int removeEle = this.myStack.remove(size - 1);
                this.size--;
                return removeEle;
            }
        }

        // peek method
        int peek() {
            if (this.size == 0) {
                System.out.println("Stack is Empty");
                return -1;
            } else {
                int removeEle = this.myStack.get(size - 1);
                return removeEle;
            }
        }

        // size of the stack
        int size() {
            return this.size;
        }
    }

    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("size: " + st.size());

        System.out.println("peek: " + st.peek());

        System.out.println("pop: " + st.pop());

        System.out.println("pop: " + st.pop());

        System.out.println("pop: " + st.pop());

        System.out.println("pop: " + st.pop());
    }
}
