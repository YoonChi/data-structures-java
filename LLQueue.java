/*
Implements the Queue<E> interface using a linked list as the underlying
data structure.  We maintain references to both the head and tail nodes.

We let the head of the list correspond to the front of the queue and the
tail of the list correspond to the back of the queue.  Add (enqueue) is
done from the tail, and remove (dequeue) is done from the head.  This
lets us make all the queue operations O(1).
*/
public class LLQueue<E> implements Queue<E> {
    // Maintain the head and tail nodes of the list
    // For an empty list, both point to null
    private Node<E> 	head,
            tail;

    // Returns whether or not the queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Adds a new element to the back of the queue
    // (This just adds a new node to the back of the linked list, with a special
    //  case for adding to an empty list since that requires altering the head.)
    public void enqueue(E newValue) {
        // Create a new node containing the newValue and whose
        //  next points to null
        Node<E> newNode = new Node<>(newValue, null);

        if (!isEmpty()) {		// Adding to the back of a non-empty list
            // Change the tail node's next to the new node
            tail.setNext(newNode);

            // Update tail to point to the new node
            tail = newNode;
        }
        else 					// Adding to an empty list
            head = tail = newNode;	// New node becomes both head and tail
    }

    // Removes and returns the element at the front of the queue
    // (This just removes the head node from the linked list, and returns
    //  the data that was in that node.)
    public E dequeue() {
        if (!isEmpty()) {
            E dataToReturn = head.getData();
            head = head.getNext();

            // If the removal of the head node empties the list, also
            //  set tail to null
            if (head == null)
                tail = null;

            return dataToReturn;
        }
        else
            return null;	// This indicates that the queue is empty
    }

    // Returns (but does not remove) the element at the front of the queue
    // (This just returns the data part of the head node of the linked list.)
    public E peek() {
        if (!isEmpty())
            return head.getData();
        else
            return null;	// This indicates that the queue is empty
    }

    public String toString() {
        String result = "LLQueue object, elements (front to back):\n";
        for (Node<E> temp = head; temp != null; temp = temp.getNext())
            result += temp.getData() + "\n";
        return result;
    }

    public static void main(String[] args) {
        Queue<String> test = new LLQueue<>();

        for (int i = 0; i < 9; i++) {
            test.enqueue(i + "");
        }

        System.out.println("peek returned: " + test.peek());
        System.out.println(test);

        while (!test.isEmpty()) {
            test.dequeue();
        }

        System.out.println("dequeue returned: " + test.dequeue());


    }
}
