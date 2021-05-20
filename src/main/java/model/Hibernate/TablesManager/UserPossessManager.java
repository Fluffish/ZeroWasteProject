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
        String sqlQuery = "SELECT DISTINCT id_storage FROM User_Possess WHERE id_user = " + id_user;
        List<User_Possess> possessedStorage = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess possess : possessedStorage) {
            result.add(possess.getId_storage());
        }

        return result;
    }

    public List<Integer> FindFood(int id_storage) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_food= '" + id_storage + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }


    public List<Integer> FindVeryLimitedFood() {
        Timestamp veryLimited = AppUtils.getTimestampForOneWeekAway();
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.food_limit_date < '" + veryLimited +"'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public List<Integer> FindLimitedFood() {
        Timestamp limited = AppUtils.getTimestampForTwoWeeksAway();
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.food_limit_date < '" + limited +"'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public List<Integer> FindNotUrgentFood() {
        Timestamp limited = AppUtils.getTimestampForTwoWeeksAway();
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.food_limit_date > '" + limited + "'";
        List<User_Possess> foodFound = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }
}
