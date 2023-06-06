package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

        private final static UserService userService = new UserServiceImpl();

        public static void main(String[] args) {
            userService.createUsersTable();

            userService.saveUser("Иван", "Иванов", (byte) 21);
            userService.saveUser("Петр", "Петров", (byte) 54);
            userService.saveUser("Василий", "Васильев", (byte) 67);
            userService.saveUser("Андрей", "Андреев", (byte) 32);
            userService.saveUser("Аркадий", "Аркадьев", (byte) 10);

            userService.removeUserById(3);

            userService.getAllUsers();

            userService.cleanUsersTable();

            userService.dropUsersTable();
    }
}
