package labfour.queue;

import labfour.interfaces.Queue;

public class DynamicArrayQueue<T> implements Queue<T> {
    private static final int INIT_CAPACITY = 2;
    private static final int MAX_CAPACITY = 5;
    private T[] elements;
    private int rear, front, size;


    @SuppressWarnings("unchecked")
    public DynamicArrayQueue() {
        elements = (T[]) new Object[INIT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean enqueue(T item) {
        if(isFull()) {
            return false;
        }
        if(size == elements.length) {
            resize();
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = elements[front];
        elements[front] = null; // Help GC
        front = (front + 1) % elements.length;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
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
        return size == MAX_CAPACITY;
    }
    
    private void resize() {
        int newSize = Math.min(elements.length * 2, MAX_CAPACITY);

        @SuppressWarnings("unchecked")
        T[] newElements = (T[]) new Object[newSize];
        for (int i = 0, j = front; i < size; i++, j = (j + 1) % elements.length) {
            newElements[i] = elements[j];
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[(front + i) % elements.length].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
