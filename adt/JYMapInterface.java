// Author: Chai Jia You

package adt;

public interface JYMapInterface<K extends Comparable<K>, V>{
    
    public boolean put(K Student, V TutorialGroup);
    
    public V get(K Student);
    
    public boolean contains(K Student);
    
    public void remove(K Student);
    
    public int size();
    
    public boolean isEmpty();
    
    
    
    public void clear();
    
    
    
    public V getValue(int position);
}
