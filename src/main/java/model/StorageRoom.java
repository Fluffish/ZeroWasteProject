package model;

public class StorageRoom extends Elements<Storage> {
    public StorageRoom() {
        super();
    }

    @Override
    public String toString() {
        return "StorageRoom{" +
                "name='" + name + '\'' +
                ", elements=" + elements +
                '}';
    }
}
