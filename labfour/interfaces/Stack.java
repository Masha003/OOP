package labfour.interfaces;

public interface Stack<T> {
    /**
     * Adds an element to the top of the stack.
     * @param item The element to be added.
     * @return true if the operation was successful, false if the stack is full.
     */
    boolean push(T item);

    /**
     * Removes and returns the top element of the stack.
     * @return The element at the top of the stack, or null if the stack is empty.
     */
    T pop();

    /**
     * Returns the top element of the stack without removing it.
     * @return The top element of the stack, or null if the stack is empty.
    */
    T peek();

    /**
     * Checks if the stack is empty
     * @return true if the stack is empty, false if otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the stack is full
     * @return true is the stack is full, false if otherwise.
     */
    boolean isFull(); 
}