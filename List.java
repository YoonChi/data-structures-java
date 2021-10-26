/*
Home-grown List<E> interface.  We focus on a subset of the operations
from Java's built-in java.util.List interface:

get, set, add, remove
*/
public interface List<E> {
    // Returns the list element at the specified index
    E get(int index);

    // Replaces the list element at an existing index with a new value
    void set(int index, E newValue);

    // Adds a new element to the end of the list
    void add(E newValue);

    // Adds a new element at a specified index
    void add(int index, E newValue);

    // Removes and returns the list element at the specified index
    E remove(int index);
}
