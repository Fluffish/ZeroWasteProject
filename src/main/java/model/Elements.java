package model;
import java.util.ArrayList;

public abstract class Elements<T> {
    protected String name;
    protected ArrayList<T> elements;

    public Elements(String name) {
        this.name = name;
        this.elements = new ArrayList<T>(0);

    }
    public Elements() {
        this.name = null;
        this.elements = new ArrayList<T>(0);

    }

    public void add(T element) {
        elements.add(element);

    }

    public T getElement(int index) {
        return elements.get(index);
    }

    public void remove(T element) {
        elements.remove(element);

    }
}


