package model;

public class StorageRoom extends ListOfElement<Storage> {
    public StorageRoom() {
        super();
    }

    public boolean containsFood(int idFood) {
        for (Storage storage : elements.values()) {
            if (storage.contains(idFood))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "StorageRoom{" +
                "name='" + name + '\'' +
                ", elements=" + elements +
                '}';
    }
}
