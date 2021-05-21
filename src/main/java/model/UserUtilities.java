package model;

import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.Recipe;
import model.Hibernate.Tables.User_Possess;
import model.Hibernate.Tables.Users;
import model.Hibernate.TablesManager.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserUtilities {
    private static final UsersManager USERS_MANAGER = new UsersManager();
    private static final UserPossessManager USER_POSSESS_MANAGER = new UserPossessManager();
    private static final FoodManager FOOD_MANAGER = new FoodManager();
    private static final RecipeManager RECIPE_MANAGER = new RecipeManager();
    private static final RecipeTypeManager RECIPE_TYPE_MANAGER = new RecipeTypeManager();
    private static final CharacterizeRecipeManager CHARACTERIZE_RECIPE_MANAGER = new CharacterizeRecipeManager();
    private static final UseFoodManager USE_FOOD_MANAGER = new UseFoodManager();
    private static final Food EMPTY_STORAGE = new Food(1, "null");

    public static void addUserStorage(Users user, int idStorage) {
        addUserPossess(user, idStorage, EMPTY_STORAGE.getId_food(), "1",
                Timestamp.valueOf(LocalDateTime.now()), 0f);
    }

    public static void addUserPossess(Users user, int idStorage, int idFood, String quantity,
                                      Timestamp expirationDate, float price) {
        User_Possess newUserPosses = new User_Possess(user.getId_user(), idStorage, idFood,
                                                      quantity, expirationDate,
                                                      Timestamp.valueOf(LocalDateTime.now()), price);

        USER_POSSESS_MANAGER.Insert(User_Possess.class.getName(), newUserPosses);

        user.setUser_current_budget((int) (user.getUser_current_budget() - price));

        USERS_MANAGER.Merge(Users.class.getName(), user);
    }

    public static void removeFoodUserPossess(Users user, int idFood, int idStorage) {
        /* TODO */
    }

    public static void removeStorageUserPossess(Users user, int idStorage) {
        List<User_Possess> selectedUserPossesses = USER_POSSESS_MANAGER.selectStorage(user.getId_user(), idStorage);
        for (User_Possess selectedUserPossess : selectedUserPossesses){
            USER_POSSESS_MANAGER.Remove(User_Possess.class.getName(),selectedUserPossess);
        }
    }

    public static void setEmptyStorage(Users user, int idStorage) {
        /* TODO */
    }

    public static StorageRoom getUserStorages(Users user) {
        List<Integer> userStorages = USER_POSSESS_MANAGER.FindDistinctStorages(user.getId_user());

        StorageRoom storageRoom = new StorageRoom();

        for (int id_storage : userStorages){
            Storage storage = new Storage(id_storage);
            List<Integer> foods = USER_POSSESS_MANAGER.FindFood(id_storage);
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
        List<Food> veryLimitedFood = new ArrayList<Food>(0);
        List<Integer> foods = USER_POSSESS_MANAGER.FindVeryLimitedFood(user.getId_user());

        for (int id_food : foods){
            if (id_food != 1)
                veryLimitedFood.add(FOOD_MANAGER.FindFoodById(id_food));
        }

        return veryLimitedFood;
    }

    public static List<Food> getLimitedFood(Users user) {
        List<Food> limitedFood = new ArrayList<Food>(0);
        List<Integer> foods = USER_POSSESS_MANAGER.FindLimitedFood(user.getId_user());

        for (int id_food : foods){
            if (id_food != 1)
                limitedFood.add(FOOD_MANAGER.FindFoodById(id_food));
        }

        return limitedFood;
    }

    public static List<Food> getNotUrgentFood(Users user) {
        List<Food> nonUrgentFood = new ArrayList<Food>(0);
        List<Integer> foods = USER_POSSESS_MANAGER.FindNotUrgentFood(user.getId_user());

        for (int id_food : foods){
            if (id_food != 1)
                nonUrgentFood.add(FOOD_MANAGER.FindFoodById(id_food));
        }

        return nonUrgentFood;
    }

    public static List<Recipe> getAvailableRecipes(Users user, StorageRoom storageRoom) {
        List<Recipe> availableRecipes = new ArrayList<>(0);
        List<Recipe> recipes = RECIPE_MANAGER.GetAllRecipe();

        for (Recipe recipe : recipes) {
            boolean isAvailable = true;
            List<Integer> ingredients = USE_FOOD_MANAGER.FindUsedFood(recipe.getId_recipe());

            for (Integer ingrendient : ingredients) {
                if (!storageRoom.containsFood(ingrendient)) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable)
                availableRecipes.add(recipe);
        }

        return availableRecipes;
    }

    public static List<String> getRecipeType(int idRecipe) {
        List<Integer> idsRecipeType = CHARACTERIZE_RECIPE_MANAGER.findTypeByIdRecipe(idRecipe);
        List<String> recipeType = new ArrayList<>(0);

        for (int idRecipeType : idsRecipeType) {
            recipeType.add(RECIPE_TYPE_MANAGER.findTypeById(idRecipeType).get(0));
        }

        return recipeType;
    }
}
