/*
Implements the List<E> interface using an array as the underlying data structure
*/
public class ArrayList<E> implements List<E> {
    // The array that stores the list's data is an instance variable of ArrayList
    // We set the initial capacity to 10 (this doesn't matter a whole lot, as long as
    //  the array can be reallocated when needed)
    private E[] data = (E[])(new Object[10]);

    // This instance variable keeps track of how many elements are currently in the list
    private int size = 0;

    // Returns the list element at the specified index
    // O(1)
    public E get(int index) {
        if (index >= 0 && index < size)
            return data[index];
        else
            throw new IndexOutOfBoundsException();
    }

    // Replaces the list element at an existing index with a new value
    // O(1)
    public void set(int index, E newValue) {
        if (index >= 0 && index < size)
            data[index] = newValue;
        else
            throw new IndexOutOfBoundsException();
    }

    // Adds a new element to the end of the list
    // O(1) if no array reallocation is needed
    // O(n) if an array reallocation is needed (but this doesn't happen often)
    public void add(E newValue) {
        // Check to see if the size of the array list matches the capacity
        //  (i.e., the array list is full)
        if (size == data.length) {
            // Make a new larger array to hold the list's data
            E[] newData = (E[])(new Object[data.length * 2]);

            // Copy all the existing elements of data into newData
            for (int i = 0; i < data.length; i++)
                newData[i] = data[i];

            // Point the old data reference to newData
            data = newData;
        }

        // Add the new element to the end of the list, and increase the size
        data[size] = newValue;
        size++;
    }

    // HOMEWORK 4 PORTION - YC
    public void add(int index, E newValue) {

        // This method adds newValue to the list at a specified index.
        if (size == data.length) {

            E[] newData = (E[])(new Object[data.length * 2]);

            // Copy all existing elements of data into newData array
            for (int i = 0; i < data.length; i++)
                newData[i] = data[i];

            // Point the old data reference to newData
            data = newData;
        }

        if (index >= 0 && index <= size) {
            // If index is 0, shift all elements up 1, then insert newValue in index[0]
            if (index == 0) {
                E[] newData = (E[])(new Object[data.length]);

                for (int i = 0; i < size; i++) {
                    newData[i+1] = data[i];
                }

                newData[0] = newValue;
                data = newData;

            }
            // If index is last index, add newValue at the end of the list
            else if (index == size) {
                data[size] = newValue;
            }
            else {
                E[] newData = (E[])(new Object[data.length]);

                // First loop will re-enter elements from data into newData
                // from index 0 to index 'index'
                for (int i = 0; i < index; i++) {
                    newData[i] = data[i];
                }

                // insert newValue at assigned index
                newData[index] = newValue;

                // Second loop will re-enter elements from data into newData
                // from index 'index' to last index.
                for (int i = index; i < size; i++) {
                    newData[i+1] = data[i];
                }

                // redirect newData back to data
                data = newData;
            }
        }
        else
            throw new IndexOutOfBoundsException();

        size++;

    }

    // Removes and returns the list element at the specified index
    // O(n) if removing from the front of the list (all the other elements have to be shifted down)
    // O(1) if removing from the back of the list (no shifting needed)
    public E remove(int index) {
        if (index >= 0 && index < size) {
            E valueToDelete = data[index];

            // Shift all array elements starting from index down by 1
            for (int i = index; i < size - 1; i++)
                data[i] = data[i + 1];
            size--;

            // Erase the element that used to be at the back of the list
            //  (Not strictly needed - the next call to add would overwrite this anyway)
            data[size] = null;
            return valueToDelete;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public String toString() {
        String result = "ArrayList object (size = " + size + ", capacity = " + data.length + "), elements:\n";
        for (int i = 0; i < size; i++)
            result += " " + data[i] + "\n";
        return result;
    }

    public static void main(String[] args) {
        int count = 0;

        // HOMEWORK
        // Test the new add method using indexes at beginning, middle, and end of the list

        List<String> test = new ArrayList<>();

        // Keep count of what the list size is for the second test (adding element to end of list)
        for (int i = 1; i < 10; i++) {
            test.add(i + "");	// Convert each int into a String
            count++;
        }

        System.out.println(test);

        // First test: add element to the end of the list
        test.add(count, 30 + "");
        System.out.println(test);

        // Second test: add element to the beginning of the list
        test.add(0, 25 + "");
        System.out.println(test);

        // Third test: add element to the middle of the list
        test.add(5, 40 + "");
        System.out.println(test);
    }
}

