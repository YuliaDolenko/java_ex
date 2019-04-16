package jdbc;

import jdbc.entities.User;

import java.util.List;

public class DataManager {

    public static void main(String[] args) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        List<User> users = dataBaseManager.readAllData();
        print(users);
//        dataBaseManager.updateName(1000, "Petro");
//        dataBaseManager.insert("Paulie1", "Askwith1", "1paskwith0@sohu.com", "Male", "140.202.113.153");
//        dataBaseManager.deleteById(1001);
//        dataBaseManager.updateIpByGender("8.8.8.8", "Female");
    }

    private static void print(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

