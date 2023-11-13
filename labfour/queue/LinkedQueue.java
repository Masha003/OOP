package labfour.queue;

import labfour.interfaces.Queue;

public class LinkedQueue<T> implements Queue<T> {
    private static final int CAPACITY = 5;
    private Node front, rear;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    @Override
    public boolean enqueue(T item) {
        if(isFull()) {
            return false;
        }

        Node newNode = new Node(item);
        if(rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if(front == null) {
            front = newNode;
        }
        size++;

        return true;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }

        T data = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }

        size--;
        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }

        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }
    
    
}
