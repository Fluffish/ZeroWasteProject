import model.Hibernate.AppUtils;
import model.Hibernate.Tables.*;
import model.Hibernate.TablesManager.FoodManager;
import model.Hibernate.TablesManager.RecipeManager;
import model.Hibernate.TablesManager.UseFoodManager;
import model.connectionManager.ConnectingSession;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestInsert {

    public static void main(String[] args) {


       /* ConnectingSession session = new ConnectingSession("Brenda","brenda123");
        session.utilities.addUserPossess(1,2,"200", AppUtils.getTimestampForOneWeekAway(),5f);

        System.out.println(session.utilities.getLimitedFood());


        Characterize_Food newCharacterizedFood = new Characterize_Food(1, 2);
        System.out.println(newCharacterizedFood);

        RecipeManager recipeManager = new RecipeManager();

        List<String> recipesName = new LinkedList<>();

        recipesName.add("Bavarois à la fraise");

        recipesName.add("Lasagne au saumon");

        recipesName.add("Chili");

        recipesName.add("Pâtes à la carbonara");

        recipesName.add("Pancake");

        recipesName.add("Confiture de framboise");

        recipesName.add("Couscous");



        for (String recipe : recipesName) {

            Recipe newRecipe = new Recipe(recipe);

            recipeManager.Insert(Recipe.class.getName(), newRecipe);

        }



        UseFoodManager useFoodManager = new UseFoodManager();

        HashMap<Integer, List<String>> ingredientsRecettes = new HashMap<>();

        List<String> Bavarois = Arrays.asList("Fraise", "Crème Fraiche", "Gélatine", "Oeuf", "Sucre", "Farine");

        List<String> Lasagne = Arrays.asList("Lasagne", "Saumon", "Crème Fraiche", "Epinard", "Sel", "Farine");

        List<String> Chili = Arrays.asList("Haricot rouge", "Viande hachée", "Poudre chili", "Carotte", "Tomate", "Oignon", "Sel");

        List<String> Carbonara = Arrays.asList("Fraise", "Crème Fraiche", "Gélatine", "Oeuf", "Sucre", "Farine");

        List<String> Pancake = Arrays.asList("Lait", "Farine", "Oeuf", "Sucre", "Yaourt");

        List<String> Confiture = Arrays.asList("Framboise", "Sucre", "Vanille");

        List<String> Couscous = Arrays.asList("Navet", "Semoule", "Agneau", "Sel", "Carotte", "Pomme de terre");

        ingredientsRecettes.put(1,Bavarois);

        ingredientsRecettes.put(2,Lasagne);

        ingredientsRecettes.put(3,Chili);

        ingredientsRecettes.put(4,Carbonara);

        ingredientsRecettes.put(5,Pancake);

        ingredientsRecettes.put(6,Confiture);

        ingredientsRecettes.put(7,Couscous);

        for (int i = 1; i <=ingredientsRecettes.size(); i++) {

            for (String food : ingredientsRecettes.get(i)) {

                FoodManager foodManager = new FoodManager();

                Food foundFood = foodManager.FindFoodByName(food);

                Use_Food use_food;

                if (foundFood != null) {

                    use_food = new Use_Food(i,foundFood.getId_food());

                }

                else {

                    Food newFood = new Food(food);

                    foodManager.Insert(Food.class.getName(), newFood);

                    Food foundNewFood = foodManager.FindFoodByName(food);

                    use_food = new Use_Food(i,foundNewFood.getId_food());

                }

                useFoodManager.Insert(Use_Food.class.getName(), use_food);

            }

        }
    }
*/

}}



