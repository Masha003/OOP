package labfour.stack;

import labfour.interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {
    private static final int CAPACITY = 5;
    private T[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (T[]) new Object[CAPACITY];
        top = -1;
    }

    public boolean push(T item) {
        if(isFull()) {
            return false;
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
        return top == CAPACITY - 1;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "The stack is empty. \n";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i <= top; i++) {
                sb.append(elements[i].toString());
                if (i < top) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
