package model;

import model.Hibernate.Tables.Food;

public class ShoppingList extends Elements<Food> {
    private final static String NAME = "Liste de Course";

    public ShoppingList() {
        super(NAME);
    }

}
