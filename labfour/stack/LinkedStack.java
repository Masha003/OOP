package labfour.stack;

import labfour.interfaces.Stack;

public class LinkedStack<T> implements Stack<T> {
    private static final int CAPACITY = 5;
    private int size;
    private Node top;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean push(T item) {
       if(isFull()) {
        return false;
       }
       Node newNode = new Node(item);
       newNode.next = top;
       top = newNode;
       size++;

       return true;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            return null;
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }
    
}
