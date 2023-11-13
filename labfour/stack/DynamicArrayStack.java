package labfour.stack;

import labfour.interfaces.Stack;

public class DynamicArrayStack<T> implements Stack<T> {
    private static final int INIT_CAPACITY = 2;
    private static final int MAX_CAPACITY = 5;
    private T[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public DynamicArrayStack() {
        elements = (T[]) new Object[INIT_CAPACITY];
        top = -1;
    }

    @Override
    public boolean push(T item) {
        if(isFull()) {
            return false;
        }
        if(top == elements.length - 1) {
            resize();
        }
        elements[++top] = item;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            return null;
        }
        return elements[top--];
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return elements[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == MAX_CAPACITY - 1;
    }
    
    private void resize() {
        if(elements.length < MAX_CAPACITY) {

            @SuppressWarnings("unchecked")
            T[] newElements = (T[]) new Object[elements.length + 1];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
}
