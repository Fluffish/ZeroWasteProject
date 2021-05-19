package model;

import Hibernate.Tables.User_Possess;
import Hibernate.Tables.Users;
import Hibernate.TablesManager.FoodManager;
import Hibernate.TablesManager.UserPossessManager;

import java.util.List;

public abstract class Utilities {
    public static StorageRoom getUserStorages(Users user){
        UserPossessManager userPossessManager = new UserPossessManager();
        FoodManager foodManager = new FoodManager();
        List<Integer> userStorages = userPossessManager.FindDistinctStorages(user.getId_user());
        StorageRoom storageRoom = new StorageRoom();
        for (int id_storage : userStorages){
            Storage storage = new Storage();
            List<Integer>foods = userPossessManager.FindFood(id_storage);
            for (int id_food : foods){
                storage.add(foodManager.FindFoodById(id_food));
            }
            storageRoom.add(storage);

        }
        return storageRoom;
    }
}
