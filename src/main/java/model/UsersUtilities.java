package model;

import model.Hibernate.Tables.*;
import model.Hibernate.TablesManager.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsersUtilities {
    private final UsersManager USERS_MANAGER = new UsersManager();
    private final UserPossessManager USER_POSSESS_MANAGER = new UserPossessManager();
    private final FoodManager FOOD_MANAGER = new FoodManager();
    private final RecipeManager RECIPE_MANAGER = new RecipeManager();
    private final RecipeTypeManager RECIPE_TYPE_MANAGER = new RecipeTypeManager();
    private final CharacterizeFoodManager CHARACTERIZE_FOOD_MANAGER = new CharacterizeFoodManager();
    private final CharacterizeRecipeManager CHARACTERIZE_RECIPE_MANAGER = new CharacterizeRecipeManager();
    private final UseFoodManager USE_FOOD_MANAGER = new UseFoodManager();
    private final Food EMPTY_STORAGE = new Food(1, "null");
    private final StorageTypeManager STORAGE_TYPE_MANAGER = new StorageTypeManager();
    private final FoodTypeManager FOOD_TYPE_MANAGER = new FoodTypeManager();

    protected StorageRoom storageRoom;
    protected Users user;

    public UsersUtilities(Users user) {
        this.user = user;
        this.storageRoom = getUserStorages(user);
    }


    public List<Food_Type> getAllFoodType() {
        return FOOD_TYPE_MANAGER.getAllFoodType();
    }

    public void addUserStorage(String storageName, float temperature) {
        List<Integer> idsStorage = STORAGE_TYPE_MANAGER.FindStorageByNameAndTemperature(storageName, temperature);

        if (idsStorage.size() == 0) {
            Storage_Type newStorageType = new Storage_Type(storageName, temperature);
            STORAGE_TYPE_MANAGER.Insert(Storage_Type.class.getName(), newStorageType);
            idsStorage = STORAGE_TYPE_MANAGER.FindStorageByNameAndTemperature(storageName, temperature);
        }

        Integer idStorage = idsStorage.get(0);

        User_Possess newUserPosses = new User_Possess(user.getId_user(), idStorage, EMPTY_STORAGE.getId_food(),
                "1", Timestamp.valueOf(LocalDateTime.now()),
                Timestamp.valueOf(LocalDateTime.now()), 0f);

        USER_POSSESS_MANAGER.Insert(User_Possess.class.getName(), newUserPosses);

        storageRoom.add(idStorage, new Storage(storageName, idStorage));
    }
    public StorageRoom getUserStorages(Users user) {
        List<Integer> userStorages = USER_POSSESS_MANAGER.FindDistinctStorages(user.getId_user());

        StorageRoom storageRoom = new StorageRoom();

        for (int idStorage : userStorages){
            Storage storage = new Storage(STORAGE_TYPE_MANAGER.FindStorageById(idStorage).getStorage_name(), idStorage);
            List<Integer> foods = USER_POSSESS_MANAGER.FindFood(idStorage);
            for (int idFood : foods){
                if (idFood != 1)
                    storage.add(idFood, FOOD_MANAGER.FindFoodById(idFood));
            }
            storageRoom.add(idStorage, storage);
        }

        return storageRoom;
    }

    public List<Food> getFoodOfTableFood() {
        return FOOD_MANAGER.FindAllFood();
    }

    public StorageRoom getStorageRoom() {
        return storageRoom;
    }

    public Integer addFood(String name, int idFoodType) {
        Food newFood = new Food(name);

        FOOD_MANAGER.Insert(Food.class.getName(), newFood);

        newFood = FOOD_MANAGER.FindFoodByName(name);

        Characterize_Food newCharacterizedFood = new Characterize_Food(newFood.getId_food(), idFoodType);

        CHARACTERIZE_FOOD_MANAGER.Insert(Characterize_Food.class.getName(), newCharacterizedFood);

        return newFood.getId_food();
    }

    public void addUserPossess(int idStorage, int idFood, String quantity,
                                      Timestamp expirationDate, float price) {
        User_Possess newUserPosses = new User_Possess(user.getId_user(), idStorage, idFood,
                                                      quantity, expirationDate,
                                                      Timestamp.valueOf(LocalDateTime.now()), price);

        USER_POSSESS_MANAGER.Insert(User_Possess.class.getName(), newUserPosses);

        storageRoom.getElement(idStorage).add(idFood, FOOD_MANAGER.FindFoodById(idFood));

        user.setUser_current_budget((int) (user.getUser_current_budget() - price));

        USERS_MANAGER.Merge(Users.class.getName(), user);
    }

    public void removeFoodUserPossess(int idFood, int idStorage, Timestamp add_date) {
        User_Possess user_possess = USER_POSSESS_MANAGER.FindUserPossess(user.getId_user(), idFood, idStorage, add_date);

        USER_POSSESS_MANAGER.Remove(User_Possess.class.getName(), user_possess);

        storageRoom.getElement(idStorage).remove(idFood);
    }

    public void removeStorageUserPossess(int idStorage) {
        List<User_Possess> selectedUserPossesses = USER_POSSESS_MANAGER.SelectStorage(user.getId_user(), idStorage);

        for (User_Possess selectedUserPossess : selectedUserPossesses){
            USER_POSSESS_MANAGER.Remove(User_Possess.class.getName(), selectedUserPossess);
        }

        storageRoom.remove(idStorage);
    }

    public void setEmptyStorage(int idStorage) {
        List<User_Possess> selectedUserPossesses = USER_POSSESS_MANAGER.SelectUserPossessFullStorage(user.getId_user(), idStorage);

        for (User_Possess selectedUserPossess : selectedUserPossesses){
            USER_POSSESS_MANAGER.Remove(User_Possess.class.getName(),selectedUserPossess);
        }

        storageRoom.getElement(idStorage).clear();
    }

    public List<Food> getAllFood() {
        List<Food> food = new ArrayList<Food>(0);

        for (Storage storage : storageRoom.values()) {
            for (Food foodProduct : storage.values()) {
                food.add(foodProduct);
            }
        }

        return food;
    }

    public List<Food> getVeryLimitedFood() {
        List<Food> veryLimitedFood = new ArrayList<Food>(0);
        List<Integer> foods = USER_POSSESS_MANAGER.FindVeryLimitedFood(user.getId_user());

        for (int id_food : foods){
            if (id_food != 1)
                veryLimitedFood.add(FOOD_MANAGER.FindFoodById(id_food));
        }

        return veryLimitedFood;
    }

    public List<Food> getLimitedFood() {
        List<Food> limitedFood = new ArrayList<Food>(0);
        List<Integer> foods = USER_POSSESS_MANAGER.FindLimitedFood(user.getId_user());

        for (int id_food : foods){
            if (id_food != 1)
                limitedFood.add(FOOD_MANAGER.FindFoodById(id_food));
        }

        return limitedFood;
    }

    public List<Food> getNotUrgentFood() {
        List<Food> nonUrgentFood = new ArrayList<Food>(0);
        List<Integer> foods = USER_POSSESS_MANAGER.FindNotUrgentFood(user.getId_user());

        for (int id_food : foods){
            if (id_food != 1)
                nonUrgentFood.add(FOOD_MANAGER.FindFoodById(id_food));
        }

        return nonUrgentFood;
    }

    public float getRemainingBudget() {
        return user.getUser_current_budget();
    }

    public List<Recipe> getAvailableRecipes() {
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
    public List<User_Possess> getAllUsersPossess() {
        return USER_POSSESS_MANAGER.GetAllUserPossession(user.getId_user());
    }

    public List<String> getRecipeType(int idRecipe) {
        List<Integer> idsRecipeType = CHARACTERIZE_RECIPE_MANAGER.findTypeByIdRecipe(idRecipe);
        List<String> recipeType = new ArrayList<>(0);

        for (int idRecipeType : idsRecipeType) {
            recipeType.add(RECIPE_TYPE_MANAGER.findTypeById(idRecipeType).get(0));
        }

        return recipeType;
    }



    public List<String> getAllUsername() {
        List<Users> allUsers = USERS_MANAGER.getAllUsers();
        List<String> allUsername = new ArrayList<>();
        for (Users user : allUsers) {
            allUsername.add(user.getUsername());
        } return allUsername; }
}
