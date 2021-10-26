public class Node<E> {

    private E data; // what this node is actually holding
    private Node<E> next; // when it comes to variable declaration that is not a primitive, Java treats this kind of declaration as a reference

    // constructor
    // Node<E> is already implied, even though it is not defined as so in the constructor
    public Node(E data, Node<E> next) {
        setData(data);
        setNext(next);
    }

    public void setData(E data) {
        this.data = data;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }
}