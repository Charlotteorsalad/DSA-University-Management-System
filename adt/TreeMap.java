// Author: Kam Bee Foong
package adt;

import java.io.Serializable;

public class TreeMap<K extends Comparable<K>, V> implements MapInterface<K, V>, Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Entry<K, V>> entries = new ArrayList<>(); // Array to store key-value pairs
    private ArrayList<V> valuesList = new ArrayList<>();

    public TreeMap() {
    }

    private static class Entry<K extends Comparable<K>, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.setKey(key);
            this.setValue(value);
        }

        public K getKey() {
            return key;
        }

        private void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public boolean put(K key, V value) {
        int index = this.indexOf(key);
        if (index != -1) {
            entries.getEntry(index).setValue(value);
            return false;
        }
        valuesList.add(value);
        entries.add(new Entry<K, V>(key, value));
        sort();
        return true;

    }

    @Override
    public V get(K key) {
        for (int i = 1; i <= entries.getNumberOfEntries(); i++) {
            Entry<K, V> entry = entries.getEntry(i);
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public K getKey(V value) {
        for (int i = 1; i <= entries.getNumberOfEntries(); i++) {
            Entry<K, V> entry = entries.getEntry(i);
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // If the value is not found    }
    }

    @Override
    public boolean contains(K key) {
        for (int i = 1; i <= entries.getNumberOfEntries(); i++) {
            K entry = entries.getEntry(i).getKey();
            if (entry.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(K key) {
        for (int i = 1; i <= entries.getNumberOfEntries(); i++) {
            K entry = entries.getEntry(i).getKey();
            if (entry.equals(key)) {
                entries.remove(i);
                break;
            }
        }
    }

    @Override
    public int size() {
        return entries.getNumberOfEntries();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    private int indexOf(K key) {
        for (int i = 0; i < entries.getNumberOfEntries(); i++) {
            if (entries.getEntry(i + 1).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void sort() {
        boolean flip = false;

        while (flip) {
            flip = false;
            Entry<K, V> entry = null;
            Entry<K, V> next = null;
            int i;
            for (i = 0; i < entries.getNumberOfEntries() - 1; i++) {
                entry = entries.getEntry(i);
                next = entries.getEntry(i + 1);
                if (entry.getKey().compareTo(next.getKey()) > 0) {
                    flip = true;
                    break;
                }
            }

            if (flip) {
                entries.replace(i, next);
                entries.replace(i + 1, entry);
            }

        }
    }

    @Override
    public V getValue(int position){
        return entries.getEntry(position + 1).getValue();
    }

}
