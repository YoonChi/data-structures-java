public class ArrayStack<E> implements Stack<E> {
    private E[] data = (E[])(new Object[10]); // create an object of array, then cast to type E

    private int size = 0;

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    // Adds an element to the end of the array
    public void push(E newValue) {
        if (size== data.length) {
            // Make a new larger array to hold the list1's data
            E[] newList = (E[])(new Object[data.length * 2]);

            // Copy all existing elements of data into newData
            for (int i = 0; i < data.length; i++) {
                newList[i] = data[i];
            }

            // Point the old data reference to newData
            data = newList;
        }

        data[size] = newValue;
        size++; // increment size by 1
    }

    // Removes the node from list and returns the data that was in the node
    public E pop() {
        if (!isEmpty()) {
            E dataToDelete = data[size-1];
            size--;
            data[size] = null;
            return dataToDelete;
        }
        else
            return null;
    }

    // Returns (but does not remove) the element at the top of the stack
    public E peek() {
        if (!isEmpty()) {
            E dataToReturn = data[size-1];
            return dataToReturn;
        }
        else
            return null;
    }

    // Print each element of the stack from bottom to top
    public String toString() {
        String result = "ArrayList object (size = " + size + ", capacity = " + data.length + "), elements:\n";
        for (int i = 0; i < data.length; i++) {
            result += " " + data[i] + "\n";
        }
        return result;
    }
    public static void main(String[] args) {
        Stack<Integer> test = new ArrayStack<>();

        for (int i = 1; i < 5; i++) {
            test.push(i);
        }

        System.out.println(test);
        System.out.println("Removed data : " + test.pop());

        System.out.println(test);

        System.out.println("Peeked: " + test.peek());
        System.out.println(test);

    }
}
