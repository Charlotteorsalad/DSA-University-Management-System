// Author: Chai Jia You

package adt;

public class JYArrayList<T> implements JYListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public JYArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public JYArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
        if (isArrayFull()) {
            doubleArray();
        }

        array[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    //add the new object with specific its location
    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries)) {
            if (isArrayFull()) {
                doubleArray();
            }
            makeSpace(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
        }

        return result;
    }

    @Override
    public void remove(T anEntry) {
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(array[index])) {
                remove(index + 1);
            }
        }
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    //Replace the a item in the array with the newEntry;
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            array[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            result = array[givenPosition - 1];
        }
        return result;
    }

    @Override
    public T getExits(String str) {
        String[] data = toString().split("\\R");
        for (int index = 0; index < numberOfEntries; index++) {
            if (data[index].toLowerCase().contains(str.toLowerCase())) {
                return getEntry(index + 1);
            }
        }
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int searchIndex(T anEntry) {
        for (int index = 0; (index < numberOfEntries); index++) {
            if (anEntry.equals(array[index])) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int[] searchPosition(String word) {
        int[] result = new int[numberOfEntries];

        word = word.toLowerCase();
        int count = 0;
        String[] data = toString().split("\\R");

        for (int index = 0; index < numberOfEntries; index++) {
            if (data[index].toLowerCase().contains(word)) {
                result[count] = index + 1;
                count++;
            }
        }

        return result;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;

    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; index++) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

    //private function
    //move the array to fill the empty place;
    private void removeGap(int givenPosition) {

        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    //check whether the array is full
    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    //increase the space of the array
    private void doubleArray() {
        T[] oldArray = array;
        array = (T[]) new Object[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    //add a space for the new added object
    //shifting the array that after the object to the back
    private void makeSpace(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        //move the index of the object 
        //start to the back start from the end of the array
        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

}
