package model.Hibernate.TablesManager;

import model.Hibernate.AppUtils;
import model.Hibernate.Tables.User_Possess;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserPossessManager extends Manager<User_Possess> {

    public List<Integer> FindUserPossession(Integer id_user) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_user = " + id_user;
        List<User_Possess> possessedStorage = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess possess : possessedStorage) {
            result.add(possess.getId_storage());
        }
        return result;
    }

    public List<Integer> FindDistinctStorages(Integer id_user) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_user = '" + id_user +"' GROUP BY id_storage" ;
        List<User_Possess> possessedStorage = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess possess : possessedStorage) {
            result.add(possess.getId_storage());
        }

        return result;
    }

    public List<Integer> FindFood(Integer id_storage) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_storage = '" + id_storage + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public User_Possess FindUserPossess(Integer id_user, Integer id_food, Integer id_storage, Timestamp add_date) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_user = '" + id_user + "' AND x.id_food = '" + id_food + "' AND x.id_storage = '" + id_storage + "' AND x.food_add_date = '" + add_date + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        if (foodFound.isEmpty())
            return null;

        return foodFound.get(0);
    }

    public List<User_Possess> SelectStorage(Integer id_user,Integer id_storage) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_storage = '" + id_storage +"' AND  x.id_user = '" + id_user + "'";
        List<User_Possess> selectedStorages = MakeQuery(User_Possess.class.getName(), sqlQuery);

        return selectedStorages;
    }

    public List<User_Possess> SelectUserPossessFullStorage(Integer id_user,Integer id_storage) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_storage = '" + id_storage + "' AND x.id_user = '" + id_user + "' AND x.id_food != '1'";
        List<User_Possess> selectedStorages = MakeQuery(User_Possess.class.getName(), sqlQuery);

        return selectedStorages;
    }

    public List<Integer> FindVeryLimitedFood(Integer id_user) {
        Timestamp veryLimited = AppUtils.getTimestampForOneWeekAway();
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.food_limit_date < '" + veryLimited + "' AND x.id_user = '" + id_user + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public List<Integer> FindLimitedFood(Integer id_user) {
        Timestamp limited = AppUtils.getTimestampForTwoWeeksAway();
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.food_limit_date < '" + limited + "' AND x.id_user = '" + id_user + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public List<Integer> FindNotUrgentFood(Integer id_user) {
        Timestamp nonUrgent = AppUtils.getTimestampForTwoWeeksAway();
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.food_limit_date > '" + nonUrgent + "' AND x.id_user = '" + id_user + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public List<User_Possess> GetAllUserPossession(Integer id_user) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_user = '" + id_user + "' AND x.id_food != '1'";
        List<User_Possess> possessedStorage = MakeQuery(User_Possess.class.getName(), sqlQuery);
        return possessedStorage;
    }
}
