package model;

import model.Hibernate.Tables.Food;

public class Storage extends ListOfElement<Food> {
    protected int idStorage;


    public Storage(String name,int idStorage) {
        super(name);
        this.idStorage = idStorage;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public int getIdStorage() {
        return idStorage;
    }
}
