/*
Home-grown Queue <E> interface
This interface supports the isEmpty, enqueue, dequeue, and peek operations
*/

public interface Queue<E> {
    // Returns whether or not the stack is empty
    boolean isEmpty();

    // Adds a new element to the top of the stack
    void enqueue(E newValue);

    // Removes and returns the element at the front of the queue
    E dequeue();

    // Returns (but does not remove) the element at the front of the queue
    E peek();
}