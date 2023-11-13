package labfour;

import labfour.interfaces.Queue;
import labfour.interfaces.Stack;
import labfour.queue.ArrayQueue;
import labfour.queue.DynamicArrayQueue;
import labfour.queue.LinkedQueue;
import labfour.stack.ArrayStack;
import labfour.stack.DynamicArrayStack;
import labfour.stack.LinkedStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedStack = new LinkedStack<>();
        Stack<Integer> dynamicStack = new DynamicArrayStack<>();

        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        Queue<Integer> dynamicQueue = new DynamicArrayQueue<>();

        //Operations with array stack
        System.out.println("Perform operations on ArrayStack: \n");
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println("ArrayStack after pushes: " + arrayStack.toString());
        arrayStack.pop();
        System.out.println("ArrayStack after pop: " + arrayStack.toString());
        System.out.println();

        // Perform operations on LinkedStack
        System.out.println("Perform operations on LinkedStack: \n");
        linkedStack.push(1);
        linkedStack.push(2);
        System.out.println("LinkedStack after pushes: " + linkedStack.toString());
        linkedStack.pop();
        System.out.println("LinkedStack after pop: " + linkedStack.toString());
        System.out.println();

        // Perform operations on DynamicArrayStack
        System.out.println("Perform operations on DynamicArrayStack: \n");
        dynamicStack.push(1);
        dynamicStack.push(2);
        System.out.println("LinkedStack after pushes: " + dynamicStack.toString());
        dynamicStack.pop();
        System.out.println("LinkedStack after pop: " + dynamicStack.toString());
        System.out.println();

        // Perform operations on ArrayQueue
        System.out.println("Perform operations on ArrayQueue: \n");
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);
        System.out.println("ArrayQueue after enqueues: " + arrayQueue.toString());
        arrayQueue.dequeue();
        System.out.println("ArrayQueue after dequeue: " + arrayQueue.toString());
        System.out.println();

        // Perform operations on LinkedQueue
        System.out.println("Perform operations on LinkedQueue: \n");
        linkedQueue.enqueue(7);
        linkedQueue.enqueue(8);
        System.out.println("LinkedQueue after enqueues: " + linkedQueue.toString());
        linkedQueue.dequeue();
        System.out.println("LinkedQueue after dequeue: " + linkedQueue.toString());
        System.out.println();

        // Perform operations on DynamicArrayQueue
        System.out.println("Perform operations on DynamicArrayQueue: \n");
        dynamicQueue.enqueue(9);
        dynamicQueue.enqueue(10);
        System.out.println("DynamicArrayQueue after enqueues: " + dynamicQueue.toString());
        dynamicQueue.dequeue();
        System.out.println("DynamicArrayQueue after dequeue: " + dynamicQueue.toString());
        System.out.println();
    }
}
