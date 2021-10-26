public class NaughtyLLQueue<E> implements Queue<E>{

    // Maintains the head and tail nodes of the list
    private Node<E> head, tail;

    // check if stack is empty. if head == null, there are no nodes
    public boolean isEmpty() {
        return head == null;
    }

    // (This just adds a new node to the front of the queue with a special
    //  case for adding to an empty list since that requires altering the head.)
    public void enqueue(E newValue) {
        // Create a new node containing the newValue and whose
        //  next points to null
        Node<E> newNode = new Node<>(newValue, null);

        // Adding to the "front" of a non-empty list
        if (!isEmpty()) {
            newNode.setNext(head); // have newNode next point to next of node after Head
            head = tail = newNode;
        }
        else
            head = tail = newNode;
    }

    // Removes and returns the element from the back of the stack 																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															, a NullPointerException
    public E dequeue() {
        if (!isEmpty()) {
            int count = 1;

            Node<E> current = head;

            while(current.getNext() != null){
                current = current.getNext();
                count++;
            }

            E dataToReturn = current.getData();

            Node<E> removeNode = head;

            if (count == 1) {
                head = tail = null;
                dataToReturn = removeNode.getData();
            }
            else {
                for (int i = 1; i < count - 1; i++) {
                    removeNode = removeNode.getNext();
                }
                removeNode.setNext(null);
                tail = removeNode;
            }

            if (head == null)
                tail = null;

            return dataToReturn;
        }
        else
            return null; // This indicates that the queue is empty, or head = null

    }

    // Returns (but does not remove) the head of the queue
    public E peek() {
        if (!isEmpty())
            return head.getData();
        else
            return null; // This indicates that the queue is empty
    }


    public String toString() {
        String result = "LLQueue object, elements (front to back):\n";
        for (Node<E> temp = head; temp != null; temp = temp.getNext())
            result += temp.getData() + "\n";
        return result;
    }

    public static void main(String[] args) {
        Queue<String> test = new NaughtyLLQueue<>();

        System.out.println(test);

        for (int i = 0; i < 8; i++) {
            test.enqueue(i  + "");
        }

        System.out.println(test);

        System.out.println("Returned and removed: " + test.dequeue());
        System.out.println(test);
        System.out.println("Returned and removed: " + test.dequeue());
        System.out.println(test);

        System.out.println("Peek : " + test.peek());
    }
}
