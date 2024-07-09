
// Author: Kam Bee Foong

package adt;



public interface MapInterface<K extends Comparable<K>, V>{
    
    
            
    public boolean put(K Student, V TutorialGroup);
    
    public V get(K Student);
    
    public K getKey(V value);
    
    public boolean contains(K Student);
    
    public void remove(K Student);
    
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
    
    public V getValue(int position);
}
