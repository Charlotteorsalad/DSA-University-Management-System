// Author: Chai Jia You
package adt;

import java.io.Serializable;

public class JYTreeMap<K extends Comparable<K>, V> implements JYMapInterface<K, V>, Serializable {

    private static final long serialVersionUID = 1L;
    private JYArrayList<Entry<K, V>> entries = new JYArrayList<>(); // Array to store key-value pairs

    public JYTreeMap() {
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
//
//	@Override
//	public MapInterface<K, V> subMap(K fromStudent, K toStudent) {
//		TreeMap<K, V> subMap = new TreeMap<>();
//		for (int i = 0; i < numberOfEntries; i++) {
//			if (entries[i].Student.compareTo(fromStudent) >= 0 && entries[i].Student.compareTo(toStudent) <= 0) {
//				subMap.put(entries[i].Student, entries[i].TutorialGroup);
//			}
//		}
//		return subMap;
//	}

    @Override
    public boolean put(K key, V value) {
        int index = this.indexOf(key);
        if (index != -1) {
            entries.getEntry(index).setValue(value);
            return false;
        }

        entries.add(new Entry<K, V>(key, value));
        sort();
        return true;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < entries.getNumberOfEntries(); i++) {
            Entry<K, V> entry = entries.getEntry(i);
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        for (int i = 0; i < entries.getNumberOfEntries(); i++) {
            K entry = entries.getEntry(i).getKey();
            if (entry.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(K key) {
        int index = -1;
        for (int i = 0; i < entries.getNumberOfEntries(); i++) {
            K entry = entries.getEntry(i).getKey();
            if (entry.equals(key)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            entries.remove(index);
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
            if (entries.getEntry(i+1).key.equals(key)) {
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

//    public V[] getValue() {
//        V[] output = null;
//        for (int i = 1; i <= entries.getNumberOfEntries(); i++) {
//            output[i] = entries.getEntry(i).getValue();
//        }
//        return output;
//    }
    @Override
    public V getValue(int position){
        return entries.getEntry(position).getValue();
    }

}
