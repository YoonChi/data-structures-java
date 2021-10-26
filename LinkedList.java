/*
Implements the List<E> interface using a linked list as the underlying data structure.
A linked list consists of "nodes"; each node contains data and a reference to the next
node.  From the head (first) node, any other node can be reached.  The nodes in a list
do *not* have to be contiguous in memory, unlike the elements of an array.
*/
public class LinkedList<E> implements List<E> {
    // This instance variable keeps track of the head node of the list.
    // From that head node, we can get anywhere else in the list.
    private Node<E> head;

    // This instance variable keeps track of how many elements are currently in the list
    private int size = 0;

    // Returns the list element at the specified index
    // O(n) because of the call to nodeAt
    public E get(int index) {
        if (index >= 0 && index < size)
            return nodeAt(index).getData();
        else
            throw new IndexOutOfBoundsException();
    }

    // Replaces the list element at an existing index with a new value
    // O(n) because of the call to nodeAt
    public void set(int index, E newValue) {
        if (index >= 0 && index < size)
            nodeAt(index).setData(newValue);
        else
            throw new IndexOutOfBoundsException();
    }

    // Adds a new element to the end of the list
    // O(1) if adding to an empty list
    // O(n) if adding to a non-empty list
    public void add(E newValue) {
        // Create a new node containing the newValue
        Node<E> newNode = new Node<>(newValue, null);

        if (size == 0) {		// If the list is empty...
            // Point the head reference to the new node
            head = newNode;
        }
        else {					// If the list is not empty...
            // Get to the last node in the list, and set its next to the new node
            nodeAt(size - 1).setNext(newNode);
        }

        size++;
    }

    // Add new element to specified index
    public void add(int index, E newValue) {
        Node<E> newNode = new Node<>(newValue, null);

        if (size == 0) {
            head = newNode;
        }
        else {
            if (index >= 0 && index <= size) {
                Node<E> nextNode = nodeAt(index);

                if (index > 0) {
                    nodeAt(index - 1).setNext(newNode);
                }
                else {
                    // If index = 0, set head to newNode, then set NewNode's next to node after newNode
                    // System.out.println("set newNode at index 0");
                    head = newNode;

                }
                nodeAt(index).setNext(nextNode);
            }
            else
                throw new IndexOutOfBoundsException();
        }

        size++;
    }
    // Removes and returns the list element at the specified index
    // O(1) if removing from the head of the list (no list traversal needed)
    // O(n) if removing from the back of the list (need to traverse all the way to the end)
    public E remove(int index) {
        if (index >= 0 && index < size) {
            E dataToReturn;
            if (index == 0) {		// Special case: remove the first node from the list
                dataToReturn = head.getData();
                head = head.getNext();
            }
            else {					// Remove any other node from the list
                Node<E> nodeBefore = nodeAt(index - 1);
                dataToReturn = nodeBefore.getNext().getData();
                nodeBefore.setNext(nodeBefore.getNext().getNext());
            }
            size--;
            return dataToReturn;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public String toString() {
        String result = "LinkedList object (size = " + size + "), elements: head -> ";

        // The commented out loop below works, but it's inefficient because *every*
        //  call to nodeAt involves a loop
        // for (int i = 0; i < size; i++)
        // 	result += nodeAt(i).getData() + " -> ";

        // Better - just a single loop through the list is needed
        for (Node<E> temp = head; temp != null; temp = temp.getNext())
            result += temp.getData() + " -> ";

        result += "null";
        return result;
    }

    // Returns the Node object at the specified index in the list
    // Declared private, since nodeAt is meant to be called only by other
    //  methods within this class
    private Node<E> nodeAt(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++)		// Runs for "index" iterations
            temp = temp.getNext();			// Each time this runs, temp advances down the list by one node
        return temp;
    }

    public static void main(String[] args) {
        // HOMEWORK
        // Test the new add method using indexes at beginning, middle, and end of the list

        int count = 0;
        List<Integer> test = new LinkedList<>();

        System.out.println(test);

        // Keep count of list test's size
        for (int i = 1; i < 8; i++) {
            test.add(i);
            count++;
        }

        System.out.println(test);

        // Test 1: add an element to the beginning of the list
        test.add(0, 25);
        count++;
        System.out.println(test);

        // Test 2: add an elemsent to the middle of the list
        test.add(4, 30);
        count++;
        System.out.println(test);

        // Test 3: add an element to the end of the list
        test.add(count, 40);
        System.out.println(test);

    }
}
