package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Pierre", "Curie", (byte) 46);
        userService.saveUser("Maria", "Curie", (byte) 66);
        userService.getAllUsers().forEach(user -> System.out.println("Пользователь: " + user.getName() +
                " " + user.getLastName() + ", возраст: " + user.getAge() + ", id: " + user.getId()));
        userService.removeUserById(1);
        userService.getAllUsers().forEach(user -> System.out.println("Пользователь: " + user.getName() +
                " " + user.getLastName() + ", возраст: " + user.getAge() + ", id: " + user.getId()));
        userService.cleanUsersTable();
        userService.saveUser("Verner", "Heisenberg", (byte) 74);
        userService.getAllUsers().forEach(user -> System.out.println("Пользователь: " + user.getName() +
                " " + user.getLastName() + ", возраст: " + user.getAge() + ", id: " + user.getId()));
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Niels", "Bohr", (byte) 77);
        userService.getAllUsers().forEach(user -> System.out.println("Пользователь: " + user.getName() +
                " " + user.getLastName() + ", возраст: " + user.getAge() + ", id: " + user.getId()));

    }

}
