package model;

import model.Hibernate.Tables.Food;

public class Storage extends Elements<Food> {
    protected int idStorage;

    public Storage(int idStorage) {
        super();
        this.idStorage = idStorage;
    }

    public boolean contains(int idFood) {
        for (Food food : elements) {
            if (food.getId_food() == idFood)
                return true;
        }

        return false;
    }

    public int getIdStorage() {
        return idStorage;
    }
}
