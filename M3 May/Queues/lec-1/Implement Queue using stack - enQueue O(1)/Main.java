import java.util.*;

class StackQueue {
    Stack<Integer> Main = new Stack<>();
    Stack<Integer> Aux = new Stack<>();

    void Push(int a) {
        Main.push(a);
    }

    int Pop() {
        if (Main.size() > 0) {
            while (Main.size() != 1) {
                Aux.push(Main.pop());
            }

            int ele = Main.pop();

            while (Aux.size() != 0) {
                Main.push(Aux.pop());
            }

            return ele;
        } else {
            return -1;
        }
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackQueue s = new StackQueue();
        int q = scanner.nextInt();

        while (q-- > 0) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                s.Push(a);
            } else if (queryType == 2) {
                System.out.print(s.Pop() + " ");
            }
        }
    }
}
