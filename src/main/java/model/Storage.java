package model;

import model.Hibernate.Tables.Food;

public class Storage extends Elements<Food> {
    protected int idStorage;

    public Storage(int idStorage) {
        super();
        this.idStorage = idStorage;
    }

    public int getIdStorage() {
        return idStorage;
    }
}
