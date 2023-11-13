package labfour.queue;

import labfour.interfaces.Queue;

public class ArrayQueue<T> implements Queue<T> {
    private static final int CAPACITY = 5;
    private T[] elements;
    private int rear, front, size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        elements = (T[]) new Object[CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean enqueue(T item) {
        if(isFull()) {
            return false;
        }
        rear = (rear + 1) % CAPACITY;
        elements[rear] = item;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        T item = elements[front];
        front = (front + 1) % CAPACITY;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }

        return elements[front];
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
