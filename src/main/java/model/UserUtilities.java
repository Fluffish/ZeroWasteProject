package model;

import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.Recipe;
import model.Hibernate.Tables.User_Possess;
import model.Hibernate.Tables.Users;
import model.Hibernate.TablesManager.FoodManager;
import model.Hibernate.TablesManager.UserPossessManager;
import model.Hibernate.TablesManager.UsersManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserUtilities {
    private static final UsersManager USERS_MANAGER = new UsersManager();
    private static final UserPossessManager USER_POSSESS_MANAGER = new UserPossessManager();
    private static final FoodManager FOOD_MANAGER = new FoodManager();
    private static final Food EMPTY_STORAGE = new Food(1, "null");

    public static void addUserStorage(Users user, int idStorage) {
        addUserPossess(user, idStorage, EMPTY_STORAGE.getId_food(), "1",
                Timestamp.valueOf(LocalDateTime.now()), 0f);
    }

    public static void addUserPossess(Users user, int idStorage, int idFood, String quantity,
                                      Timestamp expirationDate, float price) {
        User_Possess newUserPosses = new User_Possess(user.getId_user(), idStorage, idFood,
                                                      quantity, Timestamp.valueOf(LocalDateTime.now()),
                                                      expirationDate, price);

        USER_POSSESS_MANAGER.Insert(User_Possess.class.getName(), newUserPosses);

        user.setUser_current_budget((int) (user.getUser_current_budget() - price));

        USERS_MANAGER.Merge(Users.class.getName(), user);
    }

    public static StorageRoom getUserStorages(Users user) {
        List<Integer> userStorages = USER_POSSESS_MANAGER.FindDistinctStorages(user.getId_user());

        StorageRoom storageRoom = new StorageRoom();

        for (int id_storage : userStorages){
            Storage storage = new Storage(id_storage);
            List<Integer>foods = USER_POSSESS_MANAGER.FindFood(id_storage);
            for (int id_food : foods){
                if (id_food != 1)
                    storage.add(FOOD_MANAGER.FindFoodById(id_food));
            }
            storageRoom.add(storage);
        }

        return storageRoom;
    }

    public static float getRemainingBudget(Users users) {
        return users.getUser_current_budget();
    }

    public static List<Food> getAllFood(Users user, StorageRoom storageRoom) {
        List<Food> food = new ArrayList<Food>(0);

        for (Storage storage : storageRoom.elements) {
            for (Food foodProduct : storage.elements) {
                food.add(foodProduct);
            }
        }

        return food;
    }

    public static List<Food> getVeryLimitedFood(Users user) {
        /* TODO */
        return null;
    }

    public static List<Food> getLimitedFood(Users user) {
        /* TODO */
        return null;
    }

    public static List<Food> getNotUrgentFood(Users user) {
        /* TODO */
        return null;
    }

    public static List<Recipe> getAvailableRecipes(Users user) {
        /* TODO */
        return null;
    }
}
