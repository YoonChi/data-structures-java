/*
Home-grown Stack<E> interface.

A stack is a linear data structure where all the operations are done
on only one end (the "top" of the stack).  It's a "last-in, first-out"
(LIFO) structure - the last element added is the first element to be
removed.

This interface supports the isEmpty, push, pop, and peek operations.
*/

// note: all methods declared in an interface are public and abstract


public interface Stack<E> {

    // Returns whether or not the stack is empty
    boolean isEmpty();

    // Adds a new element to the top of the stack
    void push(E newValue);

    // Removes the node from list and returns the data that was in the node
    E pop();

    // Returns (but does not remove) the element at the top of the stack
    E peek();

}

