// Author: Tan Hao Yang

package adt;

import java.util.Iterator;

public interface GraphInterface<T> {
    
    public void addVertex(T newCourse);
    public boolean addEdge(T source, T dest);
    
    public boolean removeVertex(T id);
    public boolean removeEdge(T source, T dest);
    
    public boolean hasVertex(T id);
    public boolean hasEdge(T source, T dest);
    
    public T getEdge(T source, T dest);
    public Iterator<T> getIterator(T source);
    
}
