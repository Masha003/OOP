package labfour;

import labfour.interfaces.Stack;
import labfour.stack.ArrayStack;
import labfour.stack.DynamicArrayStack;
import labfour.stack.LinkedStack;

public class Main {
    public static void main(String[] args) {
        // Stack<String> stack = new ArrayStack<>();

        // stack.push("Luda");
        // stack.push("Mareen");

        // System.out.println("Top element: " + stack.peek());

        // stack.pop();

        // System.out.println("Top el after pop(): " + stack.peek());

        // Stack<Integer> stack = new LinkedStack<>();
        // stack.push(1);
        // stack.push(2);

        // System.out.println("Top element: " + stack.peek()); // Outputs: Top element: 2
        // stack.pop();
        // System.out.println("Top element after pop: " + stack.peek()); // Outputs: Top element after pop: 1

        Stack<Integer> stack = new DynamicArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3); // The stack resizes here

        System.out.println("Top element: " + stack.peek()); // Outputs: Top element: 3
        stack.pop();
        System.out.println("Top element after pop: " + stack.peek()); // Outputs: Top element after pop: 2
    }
}
