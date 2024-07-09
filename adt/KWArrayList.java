// Author: Tan Kok Wang

package adt;

import utility.*;
import java.io.Serializable;

public class KWArrayList<T> implements KWListInterface<T>, Serializable {

  private T[] array;
  private int numberOfEntries;
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 10000;

  public KWArrayList() {
    array = (T[]) new Object[DEFAULT_CAPACITY];
  }

  public KWArrayList(int initialCapacity) {
    numberOfEntries = 0;
    if (initialCapacity < DEFAULT_CAPACITY)
        initialCapacity = DEFAULT_CAPACITY;
    else
        checkCapacity(initialCapacity);
    
    
    array = (T[]) new Object[initialCapacity];
    
  }

 @Override
  public boolean add(T newEntry) {
    array[numberOfEntries] = newEntry;
    numberOfEntries++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
        if(newPosition <= numberOfEntries)
        makeRoom(newPosition);
        array[newPosition - 1] = newEntry;
        numberOfEntries++;
    } else {
      TutorMessageUI.displayInvalidMessage();
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
    else{
          TutorMessageUI.displayInvalidMessage();
    }

    return result;
  }

  @Override
  public void clear() {
      for (int i = 0; i < array.length; i++)
      array[i] = null;
      numberOfEntries = 0;
  }

  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      array[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      result = array[givenPosition - 1];
    }

    return result;
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
  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  @Override
  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  @Override
  public boolean isFull() {
    return numberOfEntries == array.length;
  }

  @Override
  public String toString() {
    String outputStr = "";
    for (int index = 0; index < numberOfEntries; ++index) {
      outputStr += array[index] + "\n";
    }

    return outputStr;
  }

  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = numberOfEntries - 1;
    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = numberOfEntries - 1;
    System.arraycopy(array, removedIndex + 1, array, removedIndex, lastIndex - removedIndex);
  }
  
  private void checkCapacity(int capacity){
    if (capacity > MAX_CAPACITY)
    System.out.println("Its capacity exceeds the maximum allowed value.");
  } 
}