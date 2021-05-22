package model;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public abstract class Elements<T> {
    protected String name;
    protected HashMap<Integer, T> elements;

    public Elements(String name) {
        this.name = name;
        this.elements = new HashMap<>(0);

    }
    public Elements() {
        this.name = null;
        this.elements = new HashMap<>(0);
    }

    public void add(Integer key, T element) {
        elements.put(key, element);
    }

    public T getElement(Integer key) {
        return elements.get(key);
    }

    public boolean contains(Integer key) {
        return elements.containsKey(key);
    }

    public Set<Integer> keys() {
        return elements.keySet();
    }

    public Collection<T> values() {
        return elements.values();
    }

    public void clear() {
        elements.clear();
    }

    public void remove(Integer key) {
        elements.remove(key);
    }

    public void remove(T element) {
        elements.remove(element);
    }
}


