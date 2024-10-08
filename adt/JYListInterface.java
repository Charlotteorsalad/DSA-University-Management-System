// Author: Chai Jia You

package adt;

public interface JYListInterface<T> {
   public boolean add(T newEntry);

  public boolean add(int newPosition, T newEntry);

  public T remove(int givenPosition);
  
  public void remove(T anEntry);

  public void clear();

  public boolean replace(int givenPosition, T newEntry);

  public T getEntry(int givenPosition);

  public int searchIndex(T anEntry);
  
  public boolean contains(T anEntry);

  public int getNumberOfEntries();

  public boolean isEmpty();

  public boolean isFull();
  
  public T getExits(String str);
  
  public int[] searchPosition(String word);

}