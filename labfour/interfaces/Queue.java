package labfour.interfaces;

public interface Queue<T> {
    /**
     * Adds an element to the back of the queue.
     * @param item The element to be added.
     * @return true if the operation was successful, false if the queue is full.
     */
    boolean enqueue(T item);

    /**
     * Removes and returns the element at the front of the queue.
     * @return The element at the front of the queue. If the queue is empty, returns null.
     */
    T dequeue();

        /**
     * Returns the front element of the queue without removing it.
     * @return The element at the front of the queue, or null if the queue is empty.
    */
    T peek();

     /**
     * Checks if the queue is empty
     * @return true if the queue is empty, false if otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full
     * @return true is the queue is full, false if otherwise.
     */
    boolean isFull(); 
    
}
