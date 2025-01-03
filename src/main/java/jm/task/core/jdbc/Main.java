package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import static jm.task.core.jdbc.util.Util.getSessionFactory;


public class Main {

    public static void main(String[] args) {

        UserServiceImpl userServiceImpl =
                new UserServiceImpl(new jm.task.core.jdbc.dao.UserDaoHibernateImpl(Util.getSessionFactory()));

        // Создание таблицы
        userServiceImpl.createUsersTable();

        // Добавление пользователей
        userServiceImpl.saveUser("Иван", "Иванов", (byte) 25);
        userServiceImpl.saveUser("Пётр", "Петров", (byte) 30);
        userServiceImpl.saveUser("Анна", "Сидорова", (byte) 28);

        // Получение и вывод всех пользователей
        for (User user : userServiceImpl.getAllUsers()) {
            System.out.println(user);
        }

        // Очистка таблицы
//        userServiceImpl.cleanUsersTable();
//
//        // Удаление таблицы
//        userServiceImpl.dropUsersTable();


    }

}
