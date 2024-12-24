package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Name1", "LastName1", (byte) 20);

        userService.saveUser("Name2", "LastName2", (byte) 25);

        userService.saveUser("Name3", "LastName3", (byte) 31);

        userService.saveUser("Name4", "LastName4", (byte) 38);

        userService.removeUserById(12);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        List<User> users = userService.getAllUsers();

        for (User user : users) {

            System.out.println("Пользователь:  " + user.getName() + " " + user.getLastName() + " , возраст - " + user.getAge() + " лет, id - " + user.getId());

        }

    }

}