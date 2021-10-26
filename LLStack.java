/*
Implements the Stack<E> interface using a linked list as the underlying
data structure.  The stack operations (push, pop, peek) are done at the
head of the list, since doing them at the tail would require traversing
the list.  This allows us to make the stack operations O(1) instead of
O(n).
*/
public class LLStack<E> implements Stack<E> {
    // Maintains the head node of the list
    private Node<E> head;

    // Returns whether or not the stack is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // Adds a new element to the top of the stack
    // (This simply adds a new node to the head of the list)
    public void push(E newValue) {
        // Create a new Node whose next points to the current head
        Node<E> newNode = new Node<>(newValue, head);

        // Point the head reference at the new node
        head = newNode;

        // Could condense the above lines into this:
        // head = new Node<>(newValue, head);
    }

    // Removes and returns the element at the top of the stack
    // (This simply removes the head node from the list and returns
    //  the data that was in that node)
    public E pop() {
        if (!isEmpty()) {
            E dataToReturn = head.getData();
            head = head.getNext();
            return dataToReturn;
        }
        else
            return null;	// This indicates that the stack is empty
    }

    // Returns (but does not remove) the element at the top of the stack
    public E peek() {
        if (!isEmpty())
            return head.getData();
        else
            return null;	// This indicates that the stack is empty
    }

    public String toString() {
        String result = "LLStack object, elements:\n";
        for (Node<E> temp = head; temp != null; temp = temp.getNext())
            result += temp.getData() + "\n";
        return result;
    }

    public static void main(String[] args) {
        Stack<String> test = new LLStack<>();
        System.out.println(test);

        test.push("maple syrup");
        System.out.println(test);

        test.push("strawberry syrup");
        System.out.println(test);

        test.push("bleu cheese syrup");
        System.out.println(test);

        System.out.println(test.peek());
        System.out.println(test);

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test);

        System.out.println(test.pop());
        System.out.println(test);

        System.out.println(test.pop());
    }
}
